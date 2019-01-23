package com.juliablack.galleryapp.interactor.main

import io.reactivex.Single

interface MainInteractor {

    fun shouldShowDialogRate() : Single<Boolean>

}