package com.juliablack.galleryapp.data.flickr.model

import com.google.gson.annotations.SerializedName

data class PhotoApiModel(
    val id: Long,
    val owner: String,
    val secret: String,
    val server: Int,
    val title: String,
    val farm: Int = 0,
    @SerializedName("ispublic") val isPublic: Int,
    @SerializedName("isfriend") val isFriend: Int
) {
    override fun toString(): String {
        return "$title"
    }
}
