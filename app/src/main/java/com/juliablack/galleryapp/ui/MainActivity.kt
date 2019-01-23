package com.juliablack.galleryapp.ui

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.juliablack.galleryapp.interactor.main.MainInteractorImpl
import com.juliablack.galleryapp.presenter.MainPresenter
import com.juliablack.galleryapp.presenter.MainPresenterImpl
import com.juliablack.galleryapp.repository.LaunchCountRepositoryImpl
import com.juliablack.galleryapp.util.PreferenceHelper


class MainActivity : AppCompatActivity(), MainPresenter.View {


    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.juliablack.galleryapp.R.layout.activity_main)
        presenter = createPresenter()
    }

    private fun createPresenter(): MainPresenter {
        val preferenceHelper = PreferenceHelper(this.applicationContext)
        val launchCountRepository = LaunchCountRepositoryImpl(preferenceHelper)
        val interactor = MainInteractorImpl(launchCountRepository)
        return MainPresenterImpl(this, interactor)

    }

    override fun showDialogRate() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Rate our app")
            .setMessage("Rate in Google Play?")
            .setNegativeButton("LATER") { dialog, _ ->
                run {
                    dialog.cancel()
                    presenter.onClickNegativeDialogRate()
                }
            }
            .setPositiveButton("OK") { dialog, _ ->
                run {
                    dialog.cancel()
                    presenter.onClickPositiveDialogRate()
                }
            }
        val alert = builder.create()
        alert.show()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()

    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }
}
