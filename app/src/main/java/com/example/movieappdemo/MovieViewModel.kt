package com.example.movieappdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entities.Data
import com.example.domain.entities.DiscoverResult
import com.example.domain.entities.Status
import com.example.domain.usecases.DiscoverUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.standalone.KoinComponent

class MovieViewModel(
    private val discoverUseCase: DiscoverUseCase
) : ViewModel(), KoinComponent {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private fun clearDisposables() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        clearDisposables()
    }

    private val _discoverLiveData = MutableLiveData<Data<DiscoverResult>>()
    val discoverLiveData: LiveData<Data<DiscoverResult>> = _discoverLiveData


    fun getDiscover() {
        val disposable = discoverUseCase.requestDiscover()
            .doOnSubscribe {

            }
            .doOnComplete {

            }
            .subscribe({ response ->

                val data = Data(
                    responseType = Status.SUCCESSFUL,
                    data = response
                )

                _discoverLiveData.value = data
            }, { error ->

                val data = Data<DiscoverResult>(
                    responseType = Status.ERROR,
                    error = Error(error.message)
                )
                _discoverLiveData.value = data
            }, {

            })

        addDisposable(disposable)
    }

}



