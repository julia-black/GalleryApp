package com.juliablack.galleryapp.repository

import io.reactivex.Completable
import io.reactivex.Single

interface LaunchCountRepository {

    fun getCountLaunch(): Single<Int>
    fun setCountLaunch(value : Int): Completable

}