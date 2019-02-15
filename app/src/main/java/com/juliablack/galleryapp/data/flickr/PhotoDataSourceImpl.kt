package com.juliablack.galleryapp.data.flickr

import com.juliablack.galleryapp.data.flickr.model.Photo
import com.juliablack.galleryapp.net.FlickrApiService
import com.juliablack.galleryapp.providers.ApiKeyProvider
import io.reactivex.Single

class PhotoDataSourceImpl(
    private val flickrApiService: FlickrApiService,
    private val apiKeyProvider: ApiKeyProvider,
    private val resultMapper: PhotoResultMapper
) : PhotoDataSource {

    override fun getRecent(pageNumber: Int, perPage: Int): Single<List<Photo>> {
        return flickrApiService.getRecent(
            FLICKR_PHOTOS_GET_RECENT,
            apiKeyProvider.getApiKey(),
            JSON,
            NO_JSON_CALLBACK,
            perPage,
            pageNumber,
            URL_S
        ).map { resultMapper.mapToPhotosUrl(it) }
    }

    companion object {
        const val FLICKR_PHOTOS_GET_RECENT = "flickr.photos.getRecent"
        const val JSON = "json"
        const val NO_JSON_CALLBACK = "1"
        const val URL_S = "url_s"
    }
}