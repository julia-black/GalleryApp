package com.juliablack.galleryapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.juliablack.galleryapp.R
import com.juliablack.galleryapp.data.flickr.PhotoDataSourceImpl
import com.juliablack.galleryapp.data.flickr.PhotoResultMapperImpl
import com.juliablack.galleryapp.data.flickr.PhotosRepositoryImpl
import com.juliablack.galleryapp.data.flickr.model.Photo
import com.juliablack.galleryapp.net.FlickrApi
import com.juliablack.galleryapp.net.ResourceManagerImpl
import com.juliablack.galleryapp.presenter.MainPresenter
import com.juliablack.galleryapp.providers.FlickrApiKeyProvider
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription


class GalleryActivity : AppCompatActivity() {

    companion object {
        val TAG = GalleryActivity::class.java.simpleName.toString()
    }

    private lateinit var subscription: Subscription
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        testGettingPhotos()
    }

    private fun testGettingPhotos() {
        val resourceManager = ResourceManagerImpl(applicationContext)
        val apiKeyProvider = FlickrApiKeyProvider(resourceManager)
        val flickrApi = FlickrApi()
        val photoResultMapper = PhotoResultMapperImpl()
        val photoDataSource = PhotoDataSourceImpl(flickrApi.service, apiKeyProvider, photoResultMapper)
        val photosRepository = PhotosRepositoryImpl(photoDataSource)
        photosRepository.getRecent(0, 10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Photo>> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onSuccess(t: List<Photo>) {
                    Log.d(GalleryActivity.TAG, t.toString())
                }

                override fun onError(e: Throwable) {
                    Log.d(GalleryActivity.TAG, "error: ${e.message}")
                }
            })
    }
}
