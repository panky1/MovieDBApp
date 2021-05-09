package com.example.movieappinfo

import android.app.Application
import com.example.movieappinfo.di.component.ApplicationComponent
import com.example.movieappinfo.di.component.DaggerApplicationComponent
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import timber.log.Timber

class App : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: App
    }


    override fun onCreate() {
        super.onCreate()
        configureDagger()
        initTimber()
        instance = this
    }


    private fun configureDagger() {
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }


    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                @Nullable
                override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ":" + element.lineNumber
                }
            })
        }
    }


}