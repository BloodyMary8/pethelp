package com.chernikova.pethelp.di.modules

import android.content.Context
import com.chernikova.pethelp.MainRepository
import com.chernikova.pethelp.domain.Interactor
import com.chernikova.remote_module.FndApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
//Передаем контекст для SharedPreferences через конструктор
class DomainModule(val context: Context) {
    //Нам нужно контекст как-то провайдить, поэтому создаем такой метод
    @Provides
    fun provideContext() = context


    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, fndApi: FndApi) = Interactor(repo = repository, retrofitService = fndApi)
}