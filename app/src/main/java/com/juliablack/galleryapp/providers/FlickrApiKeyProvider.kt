package com.juliablack.galleryapp.providers

import com.juliablack.galleryapp.R
import com.juliablack.galleryapp.net.ResourceManager


class FlickrApiKeyProvider(private val resourceManager: ResourceManager) :
    ApiKeyProvider {

    override fun getApiKey(): String {
        return resourceManager.getString(R.string.flick_api_key)
    }
}