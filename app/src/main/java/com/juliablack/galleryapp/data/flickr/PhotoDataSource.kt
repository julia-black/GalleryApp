package com.juliablack.galleryapp.data.flickr

import com.juliablack.galleryapp.data.flickr.model.Photo
import io.reactivex.Single

interface PhotoDataSource {

    fun getRecent(pageNum: Int, pageSize: Int): Single<List<Photo>>
}