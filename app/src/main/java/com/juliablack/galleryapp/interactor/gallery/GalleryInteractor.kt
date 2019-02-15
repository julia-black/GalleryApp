package com.juliablack.galleryapp.interactor.gallery

import com.juliablack.galleryapp.data.flickr.model.PhotoApiModel
import io.reactivex.Single

interface GalleryInteractor {

    fun getPhotos(pageNum: Int, pageSize: Int): Single<List<PhotoApiModel>>

}