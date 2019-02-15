package com.juliablack.galleryapp.interactor.gallery

import com.juliablack.galleryapp.data.flickr.PhotoResultMapperImpl
import com.juliablack.galleryapp.data.flickr.model.PhotoApiModel
import com.juliablack.galleryapp.repository.PhotosRepository
import io.reactivex.Single

//class GalleryInteractorImpl(val photosRepository: PhotosRepository) : GalleryInteractor {
//    override fun getPhotos(pageNum: Int, pageSize: Int): Single<List<PhotoApiModel>> {
//        val mapper = PhotoResultMapperImpl()
//        return photosRepository.getRecentPhotos(pageNum, pageSize).map {
//            mapper.map(it)
//        }
//    }
//}