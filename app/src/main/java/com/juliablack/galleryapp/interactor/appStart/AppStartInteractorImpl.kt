package com.juliablack.galleryapp.interactor.appStart

import com.juliablack.galleryapp.repository.LaunchCountRepository
import io.reactivex.Completable

class AppStartInteractorImpl(private val repository: LaunchCountRepository) : AppStartInteractor {

    override fun countAppStart(): Completable {
        return repository.getCountLaunch()
            .flatMapCompletable { value ->
                return@flatMapCompletable repository.setCountLaunch(value + 1)
            }
    }
}