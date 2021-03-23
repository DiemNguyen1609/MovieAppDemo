package com.example.movieappdemo.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.movieappdemo.R
import com.example.movieappdemo.home.model.MovieItemModel
import kotlinx.android.synthetic.main.banner_item_layout.view.*

open class BannerItemAdapter(
    var movieData: MutableList<MovieItemModel> = mutableListOf(),
) : RecyclerView.Adapter<BannerItemAdapter.BannerItemViewHoler>() {

    var itemClickCallBack: (id: String) -> Unit = {}


    fun addAlls(data: List<MovieItemModel>) {
        movieData.clear()
        movieData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerItemAdapter.BannerItemViewHoler {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.banner_item_layout, parent, false)
        return BannerItemViewHoler(layout)
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    override fun onBindViewHolder(holder: BannerItemAdapter.BannerItemViewHoler, position: Int) {
        holder.bindView(movieData[position], position, itemClickCallBack)

    }

    inner class BannerItemViewHoler(val v: View) : RecyclerView.ViewHolder(v) {
        fun bindView(
            item: MovieItemModel,
            position: Int,
            itemCallBack: (id: String) -> Unit
        ) {
            v.apply {
                Glide.with(bannerImageView)
                    .load(item.imgRes)
                    .into(bannerImageView)

                titleMovieTxv.text = item.title

                rootViewConstraint.setOnClickListener {
                    itemCallBack.invoke(
                        item.id
                    )
                }

            }
        }
    }
}

