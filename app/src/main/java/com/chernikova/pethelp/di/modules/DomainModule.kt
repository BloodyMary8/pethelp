package com.chernikova.pethelp.di.modules

import android.content.Context
import com.chernikova.pethelp.MainRepository
import com.chernikova.pethelp.domain.PreferenceProvider
import com.chernikova.pethelp.domain.Interactor
import com.chernikova.pethelp.domain.PreferenceCategory
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
    //Создаем экземпляр SharedPreferences
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    //Создаем экземпляр SharedPreferences
    fun categoryPreferences(context: Context) = PreferenceCategory(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, fndApi: FndApi, preferenceCategory: PreferenceCategory,preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = fndApi, preferences = preferenceCategory,prefs = preferenceProvider)
}