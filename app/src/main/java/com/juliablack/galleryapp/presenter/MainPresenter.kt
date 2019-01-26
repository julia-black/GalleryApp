package com.juliablack.galleryapp.presenter

interface MainPresenter {

    interface View {
        fun showDialogRate()
        fun showError(message: String?)
        fun showSuccess()
        fun showButtonSignIn()
        fun goToGalleryActivity()
    }

    fun onStart()
    fun onStop()
    fun onClickNegativeDialogRate()
    fun onClickPositiveDialogRate()
    fun onFieldsFilled()
    fun onClickSign()
}