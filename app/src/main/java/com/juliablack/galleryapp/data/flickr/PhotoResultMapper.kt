package com.juliablack.galleryapp.data.flickr

import com.juliablack.galleryapp.data.flickr.model.Photo
import com.juliablack.galleryapp.data.flickr.model.Response

interface PhotoResultMapper {

    fun mapToPhotosUrl(response: Response): List<Photo>?

}
