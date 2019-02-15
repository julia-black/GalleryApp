package com.juliablack.galleryapp.net


import com.juliablack.galleryapp.data.flickr.model.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApiService {

    @GET("services/rest")
    fun getRecent(
        @Query("method") method: String,
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallback: String,
        @Query("per_page") perPage: Int,
        @Query("page") pageNumber: Int,
        @Query("extras") extras: String
    ): Single<Response>
}