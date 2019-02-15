package com.juliablack.galleryapp.data.flickr.model

import java.util.*

class Photo(private val url: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass::class != other.javaClass::class) return false
        val photo = other as Photo
        return Objects.equals(photo.url, url)
    }

    override fun toString(): String {
        return "Photo{url='$url'}"
    }

    override fun hashCode(): Int {
        return Objects.hashCode(url)
    }

    companion object {
        fun fromModel(model: PhotoApiModel): Photo {
            return Photo("https://farm${model.farm}.staticflickr.com/${model.server}/${model.id}_${model.secret}.jpg")
        }
    }
}