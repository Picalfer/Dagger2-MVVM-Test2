package com.example.dagger2test2.di.modules

import com.example.dagger2test2.data.AppDataBase
import com.example.dagger2test2.data.BaseDataBase
import com.example.dagger2test2.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelProviderModule {
    // помечаем скоуп
    @Singleton
    // помечаем, что этот метод преоставляет зависимость
    @Provides
    fun provideRepo(): BaseDataBase = AppDataBase()

    @Singleton
    @Provides
    fun provideViewModel(repo: BaseDataBase): MainViewModel = MainViewModel(repo)
}