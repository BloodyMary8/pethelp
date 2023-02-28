package com.chernikova.pethelp.domain

import com.chernikova.pethelp.MainRepository
import com.chernikova.pethelp.PreferenceProvider.Companion.TOKEN
import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.pethelp.utils.Converter
import com.chernikova.remote_module.FndApi
import com.chernikova.remote_module.json.KeyData
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject

class Interactor(private val repo: MainRepository, private val retrofitService: FndApi, private val preferences: PreferenceCategory, private val prefs: PreferenceProvider) {
    var progressBarState: BehaviorSubject<Boolean> = BehaviorSubject.create()

    fun getToken() {
        progressBarState.onNext(true)
lFromDB(): Observable<List<AnimalCard>> = repo.getAllFromDB()
        object ID {
            const val KEY = "mMJYr8LX3Z7KjJgbUAJEbqByvxM5sus4JDQ6RsDc76MLloo5gn"
        }
        object SECRET {
            const val KEY = "h6FyE7JZ0qr1W8YoHva3xzebwbWkmusJc7NHaQzm"
        }
