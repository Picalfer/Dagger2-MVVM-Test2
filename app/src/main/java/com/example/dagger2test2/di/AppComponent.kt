package com.example.dagger2test2.di

import com.example.dagger2test2.di.modules.ViewModelProviderModule
import com.example.dagger2test2.view.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ViewModelProviderModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}