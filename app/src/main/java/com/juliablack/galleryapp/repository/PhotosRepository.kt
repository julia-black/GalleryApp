package com.juliablack.galleryapp.repository

import com.juliablack.galleryapp.data.flickr.model.Photo
import io.reactivex.Single

interface PhotosRepository {

    fun getRecent(pageNum: Int, pageSize: Int): Single<List<Photo>>
}