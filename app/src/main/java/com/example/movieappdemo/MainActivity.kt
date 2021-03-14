package com.example.movieappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeStatusBarColor(R.color.transparent_color)
    }

    private fun changeStatusBarColor(colorRes: Int) {
        val window = this.window
        window.statusBarColor = ContextCompat.getColor(this , colorRes)
    }




}