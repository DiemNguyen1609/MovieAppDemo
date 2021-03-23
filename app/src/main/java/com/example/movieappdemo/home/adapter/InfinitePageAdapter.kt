package com.example.movieappdemo.home.movieData

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.movieappdemo.R
import com.example.movieappdemo.home.model.MovieItemModel
import java.util.*


open class InfinitePagerAdapter : PagerAdapter{

    var itemClickCallBack: (id: String) -> Unit = {}

    lateinit var mLayoutInflater: LayoutInflater
    lateinit var context: Context
    var movieData: MutableList<MovieItemModel> = mutableListOf()

    override fun getCount(): Int {
        return if (realCount == 0) {
            0
        } else Int.MAX_VALUE
        // warning: scrolling to very high values (1,000,000+) results in
        // strange drawing behaviour
    }

   constructor(
        context: Context,
        movieData: MutableList<MovieItemModel> = mutableListOf()
    ) {
        this.context = context
        this.movieData = movieData
        mLayoutInflater =
            LayoutInflater.from(context)
    }

    /**
     * @return the [.getCount] result of the wrapped movieData
     */
    val realCount: Int
        get() = movieData.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val virtualPosition = position % realCount
        debug("instantiateItem: real position: $position")
        debug("instantiateItem: virtual position: $virtualPosition")
        val layout = mLayoutInflater.inflate(R.layout.banner_item_layout, container, false)

        val imgView: AppCompatImageView = layout.findViewById(R.id.bannerImageView)
        val rootViewConstraint: CardView = layout.findViewById(R.id.rootViewConstraint)
        val item = movieData[virtualPosition]

        Glide.with(imgView)
            .load(item.imgRes)
            .into(imgView)

        rootViewConstraint.setOnClickListener {
            itemClickCallBack.invoke(
                item.id
            )
        }
        container.addView(layout,0)

        // only expose virtual position to the inner movieData
        return layout
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        val virtualPosition = position % realCount
        debug("destroyItem: real position: $position")
        debug("destroyItem: virtual position: $virtualPosition")

        // only expose virtual position to the inner movieData
        container.removeView(`object` as View)
    }

    /*
     * Delegate rest of methods directly to the inner movieData.
     */


//    fun isViewFromObject(view: View?, `object`: Any?): Boolean {
//
//    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as View
    }

    /*
     * End delegation
     */
    private fun debug(message: String) {
        if (DEBUG) {
            //Log.d(TAG, message)
        }
    }

    companion object {
        private const val TAG = "InfinitePagerAdapter"
        private const val DEBUG = false
    }

}