package com.juliablack.galleryapp.data.flickr

import com.juliablack.galleryapp.data.flickr.model.Photo
import com.juliablack.galleryapp.data.flickr.model.Response

class PhotoResultMapperImpl : PhotoResultMapper {

    override fun mapToPhotosUrl(response: Response): List<Photo>? {
        return response.photos?.photos?.map {
            Photo.fromModel(it)
        }
    }
}