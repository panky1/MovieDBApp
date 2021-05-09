package com.example.movieappinfo.di.modules

import android.content.Context
import com.example.movieappinfo.ui.home.MovieListActivity
import com.example.movieappinfo.util.annotations.ActivityScope
import com.example.movieappinfo.util.annotations.qualifier.ActivityContext
import dagger.Module
import dagger.Provides


@Module
class MainActivityContextModule(private val mainActivity: MovieListActivity) {
    var context: Context = mainActivity

    @Provides
    @ActivityScope
    fun providesHomeActivity(): MovieListActivity {
        return mainActivity
    }


    @Provides
    @ActivityScope
    @ActivityContext
    fun provideContext(): Context {
        return context
    }

}