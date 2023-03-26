package com.example.sleepwell

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SleepAdapter : RecyclerView.Adapter<SleepViewHolder>() {

    private val sleepsList = arrayListOf<Sleep>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sleep, parent, false)
        return SleepViewHolder(view)
    }

    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
        holder.bind(sleepsList[position])
    }

    override fun getItemCount() = sleepsList.size

    fun addSleep(sleep: Sleep) {
        sleepsList.add(sleep)
        notifyDataSetChanged()
    }

    fun addAll(results: ArrayList<Sleep>) {
        sleepsList.clear()
        sleepsList.addAll(results)
    }
}