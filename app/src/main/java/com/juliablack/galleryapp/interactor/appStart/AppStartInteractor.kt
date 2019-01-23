package com.juliablack.galleryapp.interactor.appStart

import io.reactivex.Completable

interface AppStartInteractor  {

    fun countAppStart() : Completable
}