package com.example.sleepwell

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sleepwell.databinding.FragmentSleepsBinding

class SleepsFragment : Fragment() {
    private var _binding: FragmentSleepsBinding? = null
    private val binding get() = _binding!!
    private val adapter = SleepAdapter()

    private var _model: SleepViewModel? = null
    private val model get() = _model!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSleepsBinding.inflate(inflater, container, false)
        _model = SleepViewModel(activity.let { (it as MainActivity).getActiveUser() })
        binding.sleepsList.layoutManager = LinearLayoutManager(binding.root.context)
        binding.sleepsList.adapter = adapter

        model.getSleepsByCurrentUser()

        model.sleeps.observe(viewLifecycleOwner) { sleeps ->
            if (sleeps.size == 0) {
                activity.let { (it as MainActivity).showMessage(getString(R.string.empty_sleeps_message)) }
            }
            adapter.setSleeps(sleeps)
        }

        val addSleepButton: Button = binding.addSleepButton

        addSleepButton.setOnClickListener {
            activity.let {
                (it as MainActivity).goToAddSleepFragment(model)
            }
        }

        return binding.root
    }

    companion object {
        fun newInstance() = SleepsFragment()
    }
}