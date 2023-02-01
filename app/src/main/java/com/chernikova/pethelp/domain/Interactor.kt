package com.chernikova.pethelp.domain

import com.chernikova.pethelp.MainRepository
import com.chernikova.pethelp.PreferenceProvider.Companion.TOKEN
import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.pethelp.utils.Converter
import com.chernikova.remote_module.FndApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject


class Interactor(private val repo: MainRepository, private val retrofitService: FndApi) {
    var progressBarState: BehaviorSubject<Boolean> = BehaviorSubject.create()

    private lateinit var preferenceProvider: com.chernikova.pethelp.PreferenceProvider

    fun getToken() {
        progressBarState.onNext(true)

        retrofitService.getToken(grantType = "client_credentials", ID.KEY, SECRET.KEY)
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                onError = {
                    println(it.localizedMessage)
                }
        )
        println()
        preferenceProvider.saveAuthToken(TOKEN)
    }
    fun getAnimalFromApi(type: String) {
        //Показываем ProgressBar
        progressBarState.onNext(true)
        //Метод getDefaultCategoryFromPreferences() будет нам получать при каждом запросе нужный нам список фильмов
        retrofitService.getAnimal(preferenceProvider.getAuthToken(),type)
            .observeOn(Schedulers.io())
            .map {
                Converter.convertApiListToDtoList(it.fndAnimal)
            }
            .subscribeBy(
                onError = {
                    progressBarState.onNext(false)
                },
                onNext = {
                    progressBarState.onNext(false)
                    repo.putToDb(it)
                }
            )
    }
    fun getAnimalFromDB(): Observable<List<AnimalCard>> = repo.getAllFromDB()
        object ID {
            const val KEY = "mMJYr8LX3Z7KjJgbUAJEbqByvxM5sus4JDQ6RsDc76MLloo5gn"
        }
        object SECRET {
            const val KEY = "h6FyE7JZ0qr1W8YoHva3xzebwbWkmusJc7NHaQzm"
        }
}
