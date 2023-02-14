package com.chernikova.pethelp.view_model

import androidx.lifecycle.ViewModel
import com.chernikova.pethelp.App
import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.pethelp.domain.Interactor
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor
    val animalsListData: Observable<List<AnimalCard>>
    val showProgressBar: BehaviorSubject<Boolean>

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        animalsListData = interactor.getAnimalFromDB()
        getToken()
        getAnimals()

    }

    private fun getToken() {
      interactor.getTokenAccess()
    }

    fun getAnimals() {
        interactor.getAnimalFromApi("dog") //ЗДЕСЬ МЫ ВСАВЛЯЕМ С ИНТЕРАКТОРА
    }
}