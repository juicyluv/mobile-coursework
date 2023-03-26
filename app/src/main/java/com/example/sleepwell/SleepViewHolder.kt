package com.example.sleepwell

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_sleep.view.*

class SleepViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    fun bind(sleep: Sleep) {

        with(itemView) {
            sleep.run {
                startTextView.text = start
                endTextView.text = end
                ratingTextView.text = rating.toString()
            }
        }
    }
}