package com.juliablack.galleryapp.data.flickr.model

import com.google.gson.annotations.SerializedName

class Response(
    @SerializedName("photos") val photos: ApiPhotoPage? = null)