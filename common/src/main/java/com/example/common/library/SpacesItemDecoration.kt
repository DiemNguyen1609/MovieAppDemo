package com.example.common.library

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacesItemDecoration(val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) % 3 == 0) {
            outRect.right = space
        }

        if(parent.getChildLayoutPosition(view) % 3 == 2){
            outRect.left = space
        }

        if(parent.getChildLayoutPosition(view) % 3 == 1){
        }
    }
}