package com.juliablack.galleryapp.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel

class MainActivityVM(application: Application) : AndroidViewModel(application) {
    val ver = ObservableField<Double>(0.0)
    var test = ObservableField<String>()

    fun setLogin(it: CharSequence?) {
        test.set(it.toString())
        it?.let { chars ->
            if (chars.length > 5) {
                ver.set(1.0)
            }
        }
    }
}