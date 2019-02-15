package com.juliablack.galleryapp.net

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes id: Int): String

}
