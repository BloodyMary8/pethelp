package com.chernikova.pethelp.di

import com.chernikova.pethelp.di.modules.DatabaseModule
import com.chernikova.pethelp.di.modules.DomainModule
import com.chernikova.pethelp.view_model.HelpFragmentViewModel
import com.chernikova.pethelp.view_model.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton
import com.chernikova.remote_module.RemoteProvider

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    dependencies = [RemoteProvider::class],
    modules = [
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    //метод для того, чтобы появилась возможность внедрять зависимости в SettingsFragmentViewModel
    fun inject(helpFragmentViewModel: HelpFragmentViewModel)
}