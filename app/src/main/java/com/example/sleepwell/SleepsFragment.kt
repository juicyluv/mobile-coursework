package com.example.sleepwell

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sleepwell.databinding.FragmentSleepsBinding

class SleepsFragment: Fragment() {
    private var _binding: FragmentSleepsBinding? = null
    private val binding get() = _binding!!

    private var _model: SleepsViewModel? = null
    private val model get() = _model!!
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSleepsBinding.inflate(inflater, container, false)
        _model = SleepsViewModel()
        val view: View = binding.root

        model.getAllSleeps()

        val adapter = SleepsAdapter()
        binding.sleepsList.layoutManager = LinearLayoutManager(binding.root.context)
        binding.sleepsList.adapter = adapter

        model.sleeps.observe(viewLifecycleOwner) { sleeps ->
            if (sleeps.size == 0) {
                activity.let { (it as MainActivity).showMessage(getString(R.string.main_empty_sleeps_text)) }
            }
            adapter.addAll(sleeps)
        }

        return view
    }

    companion object {
        fun newInstance() = SleepsFragment()
    }
}