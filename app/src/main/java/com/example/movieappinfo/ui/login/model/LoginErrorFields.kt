package com.example.movieappinfo.ui.login.model

class LoginErrorFields {

    private var email: Int? = null
    private var password: Int? = null


    fun getEmail(): Int? {
        return email
    }


    fun setEmail(email: Int?) {
        this.email = email
    }


    fun getPassword(): Int? {
        return password
    }


    fun setPassword(password: Int?) {
        this.password = password
    }

}