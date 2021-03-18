package com.example.movieappdemo.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.common.extension.dp
import com.example.movieappdemo.R
import com.example.movieappdemo.home.SpacesItemDecoration
import com.example.movieappdemo.home.model.MovieItemModel
import com.example.movieappdemo.home.model.MovieListModel
import kotlinx.android.synthetic.main.item_movie_layout.view.*
import kotlinx.android.synthetic.main.movie_layout.view.*

class MovieAdapter(
    var movieDataList: MutableList<MovieListModel> = mutableListOf()
) : RecyclerView.Adapter<MovieAdapter.MovieListViewHolder>() {

    var callbackItem: (String) -> Unit = {}

    fun addAlls(data: List<MovieListModel>) {
        movieDataList.clear()
        movieDataList.addAll(data)
        notifyDataSetChanged()
    }

    inner class MovieListViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        fun bindView(item: MovieListModel, position: Int) {
            v.apply {

                titleMovieList.text = item.title

                val movieItemAdapter = MovieItemAdapter()
                movieItemAdapter.callback = callbackItem
                movieItemAdapter.addAlls(item.movieList)

                movieDataRecyclerView.apply {
                    layoutManager =
                        LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = movieItemAdapter
                    //addItemDecoration(SpacesItemDecoration(10.dp()))
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_layout, parent, false)
        return MovieListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movieDataList.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bindView(movieDataList[position], position)
    }
}