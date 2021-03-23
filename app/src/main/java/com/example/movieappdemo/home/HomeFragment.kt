package com.example.movieappdemo.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.common.BaseFragment
import com.example.common.BaseViewModel
import com.example.common.library.HorizontalMarginItemDecoration
import com.example.domain.entities.Status
import com.example.movieappdemo.R
import com.example.movieappdemo.home.adapter.BannerItemAdapter
import com.example.movieappdemo.home.adapter.MovieAdapter
import com.example.movieappdemo.home.adapter.MovieItemAdapter
import com.example.movieappdemo.home.model.MovieItemModel
import com.example.movieappdemo.home.model.MovieListModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModel()

    var callbackItem: (String) -> Unit = {}
    var callbackItemBanner: (String) -> Unit = {}
    var adapterBanner = BannerItemAdapter()
    var adapterPopularMovie = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun getViewModel(): BaseViewModel = viewModel

    override fun initControl() {
        callbackItemBanner = {
            Toast.makeText(requireContext(), "ID: $it", Toast.LENGTH_LONG).show()
        }
    }

    override fun initUI() {
        initViewPaperBanner()
        initMovieDataAdapter()
    }

    override fun initEvent() {

        with(viewModel) {
            discoverLiveData.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let { discoverResult ->
                    when (discoverResult.responseType) {
                        Status.SUCCESSFUL -> {
                            discoverResult.data?.let {
                                adapterBanner.addAlls(viewModel.createBannerData())
                                adapterPopularMovie.addAlls(viewModel.createPopularMovie())
                            }
                        }
                        Status.ERROR -> {

                        }
                        Status.LOADING -> {

                        }
                    }

                }
            })
        }

    }

    override fun initConfig() {
        viewModel.getDiscover()
    }


    private fun initMovieDataAdapter() {
        adapterPopularMovie.callbackItem = callbackItem

        movieListRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = adapterPopularMovie
        }
    }

    private fun initViewPaperBanner() {

        adapterBanner.itemClickCallBack = callbackItemBanner

        viewPager2.adapter = adapterBanner


        // Add a PageTransformer that translates the next and previous items horizontally
        // towards the center of the screen, which makes them visible
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.15f * kotlin.math.abs(position))
        }
        viewPager2.setPageTransformer(pageTransformer)

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER


        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

            }
        })

        viewPager2.adapter = adapterBanner


        // The ItemDecoration gives the current (centered) item horizontal margin so that
        // it doesn't occupy the whole screen width. Without it the items overlap
        val itemDecoration = context?.let {
            HorizontalMarginItemDecoration(
                it,
                R.dimen.viewpager_current_item_horizontal_margin
            )
        }
        if (itemDecoration != null) {
            viewPager2.addItemDecoration(itemDecoration)
        }
    }

    fun createBannerData(): MutableList<MovieItemModel> {
        return mutableListOf<MovieItemModel>(
            MovieItemModel(
                id = "1",
                imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                title = ""
            ),
            MovieItemModel(
                id = "2",
                imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                title = ""
            ),
            MovieItemModel(
                id = "3",
                imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                title = ""
            ),
            MovieItemModel(
                id = "4",
                imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                title = ""
            ),
            MovieItemModel(
                id = "5",
                imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                title = ""
            )
        )
    }

    fun createMovieData(): MutableList<MovieListModel> {
        return mutableListOf<MovieListModel>(
            MovieListModel(
                id = "",
                title = getString(R.string.popular_movie),
                movieList = listOf(
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    )
                )

            ),
            MovieListModel(
                id = "",
                title = getString(R.string.upcoming_movie),
                movieList = listOf(
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    )
                )

            ),
            MovieListModel(
                id = "",
                title = getString(R.string.top_rated_movie),
                movieList = listOf(
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    )
                )

            ),
            MovieListModel(
                id = "",
                title = getString(R.string.popular_movie),
                movieList = listOf(
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    )
                )

            ),
            MovieListModel(
                id = "",
                title = getString(R.string.upcoming_movie),
                movieList = listOf(
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    )
                )

            ),
            MovieListModel(
                id = "",
                title = getString(R.string.top_rated_movie),
                movieList = listOf(
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    ),
                    MovieItemModel(
                        id = "",
                        imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg",
                        title = ""
                    )
                )

            )
        )
    }


}