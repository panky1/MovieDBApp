package com.example.movieappinfo.ui.login.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.example.movieappinfo.BR
import com.example.movieappinfo.R

class LoginForm : BaseObservable() {

    private val fields = LoginFields()
    private val errors = LoginErrorFields()
    private val buttonClick = MutableLiveData<LoginFields>()


    @Bindable
    fun isValid(): Boolean {
        var valid: Boolean = isEmailValid(false)
        valid = isPasswordValid(false) && valid
        notifyPropertyChanged(BR.emailError)
        notifyPropertyChanged(BR.passwordError)
        return valid
    }


    fun isEmailValid(setMessage: Boolean): Boolean {
        val email = fields.getEmail()
        if (email != null && email.length > 5) {
            val indexOfAt = email.indexOf("@")
            val indexOfDot = email.lastIndexOf(".")
            return if (indexOfAt > 0 && indexOfDot > indexOfAt && indexOfDot < email.length - 1) {
                errors.setEmail(null)
                notifyPropertyChanged(BR.valid)
                true
            } else {
                if (setMessage) {
                    errors.setEmail(R.string.email_hint)
                    notifyPropertyChanged(BR.valid)
                }
                false
            }
        }
        if (setMessage) {
            errors.setEmail(R.string.email_hint)
            notifyPropertyChanged(BR.valid)
        }
        return false
    }


    fun isPasswordValid(setMessage: Boolean): Boolean {
        val password = fields.getPassword()
        return if (password != null && password.length > 5) {
            errors.setPassword(null)
            notifyPropertyChanged(BR.valid)
            true
        } else {
            if (!setMessage&& password != null && password.length > 0) {
                errors.setPassword(R.string.pwd_hint)
                notifyPropertyChanged(BR.valid)
            }
            false
        }
    }


    fun onClick() {
        if (isValid()) {
            buttonClick.value = fields
        }
    }


    fun getLoginFields(): MutableLiveData<LoginFields>? {
        return buttonClick
    }


    fun getFields(): LoginFields? {
        return fields
    }


    @Bindable
    fun getEmailError(): Int? {
        return errors.getEmail()
    }


    @Bindable
    fun getPasswordError(): Int? {
        return errors.getPassword()
    }


}