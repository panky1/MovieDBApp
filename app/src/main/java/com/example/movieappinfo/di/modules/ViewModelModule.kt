package com.example.movieappinfo.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappinfo.di.ViewModelFactory
import com.example.movieappinfo.di.key.ViewModelKey
import com.example.movieappinfo.ui.home.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindHomeViewModel(movieListViewModel: MovieListViewModel): ViewModel



}