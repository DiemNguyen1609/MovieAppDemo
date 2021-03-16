package com.example.movieappdemo.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.extension.dp
import com.example.movieappdemo.MovieViewModel
import com.example.movieappdemo.R
import com.example.movieappdemo.home.adapter.MovieAdapter
import com.example.movieappdemo.home.model.MovieItemModel
import com.example.movieappdemo.home.model.MovieListModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.movie_layout.view.*
import retrofit2.http.Url


class HomeFragment : Fragment() {

    val callbackItem: (String) -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieAdapter = MovieAdapter()
        movieAdapter.callbackItem = callbackItem
        movieAdapter.addAlls(
            listOf(
                MovieListModel(
                    id = "",
                    title = getString(R.string.popular_movie),
                    movieList = listOf(
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        )
                    )

                ),
                MovieListModel(
                    id = "",
                    title = getString(R.string.upcoming_movie),
                    movieList = listOf(
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        )
                    )

                ),
                MovieListModel(
                    id = "",
                    title = getString(R.string.top_rated_movie),
                    movieList = listOf(
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        )
                    )

                ),
                MovieListModel(
                    id = "",
                    title = getString(R.string.popular_movie),
                    movieList = listOf(
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        )
                    )

                ),
                MovieListModel(
                    id = "",
                    title = getString(R.string.upcoming_movie),
                    movieList = listOf(
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        )
                    )

                ),
                MovieListModel(
                    id = "",
                    title = getString(R.string.top_rated_movie),
                    movieList = listOf(
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        ),
                        MovieItemModel(
                            id = "",
                            imgRes = "https://image.tmdb.org/t/p/w500/4s2d3xdyqotiVNHTlTlJjrr3q0H.jpg"
                        )
                    )

                )
            )
        )

        movieListRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = movieAdapter
            addItemDecoration(SpacesItemDecoration(15.dp()))
        }


    }


}