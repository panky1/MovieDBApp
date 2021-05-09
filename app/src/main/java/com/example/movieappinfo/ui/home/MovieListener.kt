package com.example.movieappinfo.ui.home

interface MovieListener {
    fun onFetchStarted()
    fun onFetchFinished()
    fun onFailure(message: String)
}