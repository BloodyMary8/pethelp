package com.chernikova.pethelp.domain


import com.chernikova.pethelp.MainRepository
import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.pethelp.utils.Converter
import com.chernikova.remote_module.FndApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject


class Interactor(private val repo: MainRepository, private val retrofitService: FndApi) {
        var progressBarState: BehaviorSubject<Boolean> = BehaviorSubject.create()

        fun getAnimalFromApi( page: Int) {
            //Показываем ProgressBar
            progressBarState.onNext(true)
            //Метод getDefaultCategoryFromPreferences() будет нам получать при каждом запросе нужный нам список фильмов
            retrofitService.getAnimal(Bearer.KEY,1)
                .subscribeOn(Schedulers.io())
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
    //fun getSearchResultFromApi(search: String): Observable<List<AnimalCard>> = retrofitService.getAnimalsFromSearch(Bearer.KEY, 1)
     //  .map {
    //        Converter.convertApiListToDtoList(it.fndAnimal)
    //   }

    fun getAnimalFromDB(): Observable<List<AnimalCard>> = repo.getAllFromDB()

    object Bearer {
        const val KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiJtTUpZcjhMWDNaN0tqSmdiVUFKRWJxQnl2eE01c3VzNEpEUTZSc0RjNzZNTGxvbzVnbiIsImp0aSI6ImY2NGZhNmQ3Mzc3MTE5M2IwNGYyYzI5MmIyNjk5MjA2YmFiZWVkOTMxOWE1MDIwNTJhMGIwNzEzMWRiNmJhNzZhNjI1MWE5OTA2NTdiMjY4IiwiaWF0IjoxNjczMjQxNTE3LCJuYmYiOjE2NzMyNDE1MTcsImV4cCI6MTY3MzI0NTExNywic3ViIjoiIiwic2NvcGVzIjpbXX0.rZMuZfyxMnETMHtIdrzxRcO6OVrqFcfP_nio1KQu-aUemikRyl8tVt5B99PdI0iJ3v8hAeZGMJOh0--dat7BdTeXbjYon97iTXoOiDRbVqyfAis87C79FvLw-wWesJv7Ckc-6jm5EX9l8nQ9NPEA6bRCOCtqW-QgBEYBgWfuRzUbHoSmAz3J2dEvnLVTEME3HSfqVrBomSIG1lQzpdZXiTktKGpcBpngs4d9mi9sJO6Lr46-RB2Qv-hUYupEQGOrjnL6rxKieOFsjVLsecT-D75lnnX2Ana39QmLtlAvdalvvkeUA10VRmVEcT5hceSug9VwM04xNqVkREJtf67dRA"
    }
}
