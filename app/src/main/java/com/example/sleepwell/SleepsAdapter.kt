package com.example.sleepwell

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sleepwell.databinding.SleepsItemBinding

class SleepsAdapter : RecyclerView.Adapter<SleepsAdapter.SleepsHolder>() {

    private val sleepsList = arrayListOf<Sleep>()

    class SleepsHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = SleepsItemBinding.bind(item)
        fun bind(sleep: Sleep) {
            binding.start.text = "Начало: " + sleep.start
            binding.end.text = "Конец: " + sleep.end
            binding.rating.text = "Качество: " + sleep.rating
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sleeps_item, parent, false)
        return SleepsHolder(view)
    }

    override fun onBindViewHolder(holder: SleepsHolder, position: Int) {
        holder.bind(sleepsList[position])
    }

    override fun getItemCount(): Int {
        return sleepsList.size
    }

    fun addAll(results: ArrayList<Sleep>) {
        sleepsList.clear()
        sleepsList.addAll(results)
    }
}