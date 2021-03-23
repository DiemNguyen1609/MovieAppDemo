package com.example.movieappdemo.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.BaseFragment
import com.example.common.BaseViewModel
import com.example.movieappdemo.R
import org.koin.android.viewmodel.ext.android.viewModel


class SearchFragment : BaseFragment() {

    private val viewModel: SearchViewModel by viewModel()


    override fun getViewModel(): BaseViewModel = viewModel

    override fun initControl() {

    }

    override fun initUI() {

    }

    override fun initEvent() {

    }

    override fun initConfig() {

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


}