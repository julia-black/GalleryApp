package com.juliablack.galleryapp.presenter

import android.util.Log
import com.juliablack.galleryapp.interactor.gallery.GalleryInteractor
import io.reactivex.disposables.CompositeDisposable

class GalleryPresenterImpl(val view: GalleryPresenter.View, val interactor: GalleryInteractor) : GalleryPresenter {
    private val compositeDisposable = CompositeDisposable()

    override fun onUpdate() {
        compositeDisposable.add(interactor.getPhotos(0, 20).subscribe(
            { result -> Log.d("Logger", result.toString()) },
            { error -> Log.d("Logger", error.message) }
        ))
    }

    override fun onStop() {
        compositeDisposable.dispose()
    }
}