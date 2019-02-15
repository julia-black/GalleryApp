package com.juliablack.galleryapp.net

import android.content.Context
import androidx.annotation.StringRes

class ResourceManagerImpl(private val context: Context) : ResourceManager {

    override fun getString(@StringRes id: Int): String {
        return context.getString(id)
    }
}