package com.juliablack.galleryapp.interactor.main

import com.juliablack.galleryapp.repository.LaunchCountRepository
import io.reactivex.Single

class MainInteractorImpl(private val repository: LaunchCountRepository) : MainInteractor {

    override fun shouldShowDialogRate(): Single<Boolean> {
        return repository.getCountLaunch()
            .map { value -> return@map shouldShowDialogRate(value) }
    }

    private fun shouldShowDialogRate(count: Int): Boolean {
        return count == 2 || (count - 2) % 4 == 0
    }
}