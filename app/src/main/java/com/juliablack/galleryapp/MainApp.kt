package com.juliablack.galleryapp

import android.app.Application
import android.util.Log
import com.juliablack.galleryapp.interactor.appStart.AppStartInteractorImpl
import com.juliablack.galleryapp.data.launch.LaunchCountRepositoryImpl
import com.juliablack.galleryapp.util.PreferenceHelper
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startApp()
    }

    private fun startApp() {
        val helper = PreferenceHelper(this)
        val launchCountRepository = LaunchCountRepositoryImpl(helper)
        val appStartInteractor = AppStartInteractorImpl(launchCountRepository)

        appStartInteractor.countAppStart().subscribe(object : CompletableObserver {
            override fun onComplete() {
                Log.d(LOG_TAG, "onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d(LOG_TAG, "onSubscribe")
            }

            override fun onError(e: Throwable) {
                Log.d(LOG_TAG, "onError")
            }
        })

    }

    companion object {
        const val LOG_TAG = "MainApp"
    }
}