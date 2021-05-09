package com.example.movieappinfo.di.component

import com.example.movieappinfo.App
import com.example.movieappinfo.di.modules.ApiModule
import com.example.movieappinfo.di.modules.ViewModelModule
import com.example.movieappinfo.ui.home.MovieListActivity
import com.example.movieappinfo.ui.login.LoginActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class, ViewModelModule::class, ApiModule::class]
)
interface ApplicationComponent : AndroidInjector<App> {
    fun inject(movieListActivity: MovieListActivity)

    fun inject(loginActivity: LoginActivity)


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): ApplicationComponent
    }

}