package com.juliablack.galleryapp.presenter

import android.util.Log
import com.juliablack.galleryapp.interactor.main.MainInteractor
import io.reactivex.disposables.CompositeDisposable

class MainPresenterImpl(private val view: MainPresenter.View, private val interactor: MainInteractor) : MainPresenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onStart() {
        compositeDisposable.add(interactor.shouldShowDialogRate().subscribe(
            { result -> if (result) view.showDialogRate() },
            { error -> Log.d("MainPresenter", "error: ${error.message}") }
        ))
    }

    override fun onStop() {
        compositeDisposable.dispose()
    }

    private val logTag = "MainPresenter"

    override fun onClickNegativeDialogRate() {
        Log.d(logTag, "Negative result")
    }

    override fun onClickPositiveDialogRate() {
        Log.d(logTag, "Positive result")
    }

    override fun onFieldsFilled() {
        view.showButtonSignIn()
        Log.d(logTag, "on Fields filled")
    }

    override fun onClickSign() {
        view.goToGalleryActivity()
        Log.d(logTag, "click sign")
    }
}