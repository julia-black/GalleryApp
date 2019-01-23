package com.juliablack.galleryapp.presenter

interface MainPresenter {

    interface View {
        fun showDialogRate()
    }

    fun onStart()
    fun onStop()
    fun onClickNegativeDialogRate()
    fun onClickPositiveDialogRate()
}