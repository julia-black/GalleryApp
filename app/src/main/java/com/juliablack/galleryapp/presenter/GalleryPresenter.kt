package com.juliablack.galleryapp.presenter

interface GalleryPresenter {

    interface View {
        fun showRecentPhotos()
    }

    fun onUpdate()

    fun onStop()
}