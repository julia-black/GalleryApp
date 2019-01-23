package com.juliablack.galleryapp.util

import android.content.Context
import android.preference.PreferenceManager
import io.reactivex.Completable
import io.reactivex.Single

class PreferenceHelper(private val context: Context) {

    fun putInt(key: String, value: Int): Completable {
        return Completable.fromAction {
            PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(key, value)
                .apply()
        }
    }

    fun getInt(key: String, default: Int): Single<Int> {
        return Single.fromCallable {
            PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(key, default)
        }
    }
}