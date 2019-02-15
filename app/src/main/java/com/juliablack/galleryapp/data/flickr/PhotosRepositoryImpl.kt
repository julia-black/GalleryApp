package com.juliablack.galleryapp.data.flickr

import com.juliablack.galleryapp.data.flickr.model.Photo
import com.juliablack.galleryapp.repository.PhotosRepository
import io.reactivex.Single

class PhotosRepositoryImpl(private val photoDataSource: PhotoDataSource) : PhotosRepository {
    override fun getRecent(pageNum: Int, pageSize: Int): Single<List<Photo>> {
        return photoDataSource.getRecent(pageNum, pageSize)
    }

}