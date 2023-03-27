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

    fun setSleeps(sleeps: ArrayList<Sleep>){
        sleepsList.clear()
        sleepsList.addAll(sleeps)
    }

    fun addSleep(sleep: Sleep) {
        sleepsList.add(sleep)
    }
}