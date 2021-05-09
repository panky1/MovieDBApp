package com.example.movieappinfo.di.modules

import android.content.Context
import com.example.movieappinfo.util.annotations.ApplicationScope
import com.example.movieappinfo.util.annotations.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides


@Module
class ContextModule(private val context: Context) {


    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext(): Context {
        return context
    }

}