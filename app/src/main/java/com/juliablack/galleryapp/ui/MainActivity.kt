package com.juliablack.galleryapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.jakewharton.rxbinding.widget.RxTextView
import com.juliablack.galleryapp.R
import com.juliablack.galleryapp.data.launch.LaunchCountRepositoryImpl
import com.juliablack.galleryapp.databinding.ActivityMainBinding
import com.juliablack.galleryapp.interactor.main.MainInteractorImpl
import com.juliablack.galleryapp.presenter.MainPresenter
import com.juliablack.galleryapp.presenter.MainPresenterImpl
import com.juliablack.galleryapp.util.PreferenceHelper
import com.juliablack.galleryapp.viewmodel.MainActivityVM
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.Subscription
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private lateinit var subscription: Subscription
    private lateinit var presenter: MainPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.juliablack.galleryapp.R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainActivityVM::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = viewModel
        presenter = createPresenter()
    }

    private fun watchLogin() {
        val observableLogin: Observable<CharSequence> = RxTextView.textChanges(loginTextView)
        val observablePassword: Observable<CharSequence> = RxTextView.textChanges(passwordTextView)
        subscription = Observable.combineLatest(observableLogin, observablePassword) { login, password ->
            login.isNotBlank() && password.isNotBlank()
        }.debounce(1, TimeUnit.SECONDS).subscribe { isNotBlank -> if (isNotBlank) presenter.onFieldsFilled() }

        observableLogin.subscribe {
            binding.vm!!.setLogin(it)
        }
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
        watchLogin()

    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
        subscription.unsubscribe()
    }

    override fun showButtonSignIn() {
        buttonSignIn.setOnClickListener { presenter.onClickSign() }
        runOnUiThread {
            buttonSignIn.visibility = View.VISIBLE
        }
    }

    override fun showError(message: String?) {

    }

    override fun showSuccess() {

    }

    override fun goToGalleryActivity() {
        val intent = Intent(this@MainActivity, GalleryActivity::class.java)
        startActivity(intent)
    }
}
