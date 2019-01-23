package com.juliablack.galleryapp.repository

import com.juliablack.galleryapp.util.PreferenceHelper
import io.reactivex.Completable
import io.reactivex.Single

class LaunchCountRepositoryImpl(private val preferenceHelper: PreferenceHelper) : LaunchCountRepository {

    override fun getCountLaunch(): Single<Int> {
        return preferenceHelper.getInt(KEY_LAUNCH_COUNT,0)
    }

    override fun setCountLaunch(value: Int): Completable {
        return preferenceHelper.putInt(KEY_LAUNCH_COUNT, value)
    }

    companion object {
        const val KEY_LAUNCH_COUNT = "launch_count"
    }

}