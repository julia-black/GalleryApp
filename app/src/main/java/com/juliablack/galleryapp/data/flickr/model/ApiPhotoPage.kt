package com.juliablack.galleryapp.data.flickr.model

import com.google.gson.annotations.SerializedName

class ApiPhotoPage(
    val page: Int,
    val pages: Int,
    val total: Int,
    @SerializedName("perpage") val perPage: Int,
    @SerializedName("photo") val photos: List<PhotoApiModel>?
)