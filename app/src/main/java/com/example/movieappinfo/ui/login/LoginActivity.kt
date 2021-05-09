package com.example.movieappinfo.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieappinfo.App
import com.example.movieappinfo.R
import com.example.movieappinfo.databinding.ActivitySigninBinding
import com.example.movieappinfo.di.component.DaggerApplicationComponent
import com.example.movieappinfo.ui.home.MovieListActivity
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private var viewModel: LoginViewModel? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBindings(savedInstanceState)
    }


    private fun setupBindings(savedInstanceState: Bundle?) {
        DaggerApplicationComponent.factory().create(this.application as App).inject(this)
        val activityBinding: ActivitySigninBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_signin)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        activityBinding.model = viewModel
        if (savedInstanceState == null) {
            viewModel?.init()
        }
        activityBinding.model = viewModel

        setupButtonClick()
    }


    private fun setupButtonClick() {
        viewModel?.getLoginFields()?.observe(this, Observer { loginModel ->
            Toast.makeText(
                this@LoginActivity,
                "Login Successfully",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this, MovieListActivity::class.java)
            startActivity(intent)
        })
    }
}