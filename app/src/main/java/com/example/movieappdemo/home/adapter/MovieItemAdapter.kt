package com.example.movieappdemo.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappdemo.R
import com.example.movieappdemo.home.model.MovieItemModel
import kotlinx.android.synthetic.main.item_movie_layout.view.*

class MovieItemAdapter(
    var movieData: MutableList<MovieItemModel> = mutableListOf()
) : RecyclerView.Adapter<MovieItemAdapter.MovieItemViewHolder>() {

    var callback: (String) -> Unit = {}

    fun addAlls(data: List<MovieItemModel>) {
        movieData.clear()
        movieData.addAll(data)
        notifyDataSetChanged()
    }

    inner class MovieItemViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        fun bindView(item: MovieItemModel, position: Int, lastItem: Int) {
            v.apply {

                Glide.with(context)
                    .load(item.imgRes)
                    .placeholder(R.drawable.img_movie)
                    .into(movieItemImage)

                setOnClickListener {
                    callback.invoke(item.id)
                }


                when (position) {
                    0 -> {
                        cardviewMovieItem.setPadding(
                            context.resources.getDimension(R.dimen._15).toInt(),
                            0,
                            0,
                            0
                        )
                    }
                    lastItem -> {
                        cardviewMovieItem.setPadding(
                            context.resources.getDimension(R.dimen._10).toInt(),
                            0,
                            context.resources.getDimension(R.dimen._15).toInt(),
                            0
                        )
                    }
                    else -> {
                        cardviewMovieItem.setPadding( context.resources.getDimension(R.dimen._10).toInt(), 0, 0, 0)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_layout, parent, false)
        return MovieItemViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bindView(movieData[position], position, movieData.size - 1)
    }
}