package com.example.movieappdemo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.BaseViewModel
import com.example.domain.entities.*
import com.example.domain.usecases.DiscoverUseCase
import com.example.movieappdemo.home.model.MovieItemModel
import com.example.movieappdemo.home.model.MovieListModel

class HomeViewModel(
    private val discoverUseCase: DiscoverUseCase
) : BaseViewModel() {
    private val _discoverLiveData = MutableLiveData<Event<Data<DiscoverResult>>>()
    val discoverLiveData: LiveData<Event<Data<DiscoverResult>>> = _discoverLiveData

    var discoverResult: DiscoverResult = DiscoverResult()


    fun getDiscover() {
        val disposable = discoverUseCase.requestDiscover()
            .doOnSubscribe {

            }
            .doOnComplete {

            }
            .subscribe({ response ->
                val data = Data(responseType = Status.SUCCESSFUL, data = response)
                discoverResult = response

                _discoverLiveData.value = Event(data)

            }, { error ->

                _discoverLiveData.value =
                    Event(Data(responseType = Status.ERROR, error = Error(error.message)))
                handleNetworkError(error)
            }, {

            })

        addDisposable(disposable)
    }

    fun createBannerData(): MutableList<MovieItemModel> {
        val results = discoverResult.results
        var data: MutableList<MovieItemModel> = mutableListOf()
        results.map {
            data.add(
                MovieItemModel(
                    id = it.id,
                    imgRes = imgURLRoot + it.backdropPath,
                    title = it.title

                )
            )
        }

        return data
    }

    fun createPopularMovie(): MutableList<MovieListModel> {
        val results = discoverResult.results
        var data: MutableList<MovieListModel> = mutableListOf()
        var movieList: MutableList<MovieItemModel> = mutableListOf()
        results.map {
            movieList.add(
                MovieItemModel(
                    id = it.id,
                    imgRes = imgURLRoot + it.backdropPath,
                    title = it.title

                )
            )
        }
        data.add(
            MovieListModel(
                id = POPULAR_MOVIES,
                title = "Popular Movies",
                movieList = movieList
            )
        )
        data.add(
            MovieListModel(
                id = UPCOMING_MOVIES,
                title = "Upcoming Movies",
                movieList = movieList
            )
        )
        data.add(
            MovieListModel(
                id = TOP_RATED,
                title = "Top Rated",
                movieList = movieList
            )
        )
        return data
    }

    companion object {
        const val POPULAR_MOVIES: String = "1"
        const val UPCOMING_MOVIES: String = "2"
        const val TOP_RATED: String = "3"
    }

}