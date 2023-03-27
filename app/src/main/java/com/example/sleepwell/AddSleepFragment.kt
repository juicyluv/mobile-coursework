package com.example.sleepwell

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sleepwell.databinding.FragmentAddSleepBinding
import java.util.UUID

class AddSleepFragment(viewModel: SleepViewModel) : Fragment() {
    private var _binding: FragmentAddSleepBinding? = null
    private val binding get() = _binding!!

    private var _model: SleepViewModel = viewModel
    private val model get() = _model

    private var startDateInput: EditText? = null
    private var startTimeInput: EditText? = null
    private var endDateInput: EditText? = null
    private var endTimeInput: EditText? = null
    private var ratingInput: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddSleepBinding.inflate(inflater, container, false)
        _model = SleepViewModel(activity.let { (it as MainActivity).getActiveUser() })

        model.getSleepsByCurrentUser()
        init()

        binding.addSleepAddButton.setOnClickListener {
            addSleep()
        }

        return binding.root
    }

    private fun init() {
        startDateInput = binding.addSleepStartDateText
        startTimeInput = binding.addSleepStartTimeText
        endDateInput = binding.addSleepEndDateText
        endTimeInput = binding.addSleepEndTimeText
        ratingInput = binding.addSleepRatingText
    }

    private fun addSleep() {
        val startDate = startDateInput?.text?.trim().toString()
        val startTime = startTimeInput?.text?.trim().toString()
        val endDate = endDateInput?.text?.trim().toString()
        val endTime = endTimeInput?.text?.trim().toString()
        var rating = 0

        if (startDate.isEmpty()) {
            startDateInput?.error = "Обязательное поле"
            return
        }

        if (startTime.isEmpty()) {
            startTimeInput?.error = "Обязательное поле"
            return
        }

        if (endDate.isEmpty()) {
            endDateInput?.error = "Обязательное поле"
            return
        }

        if (endTime.isEmpty()) {
            endTimeInput?.error = "Обязательное поле"
            return
        }

        try {
            rating = ratingInput?.text?.trim().toString().toInt()
        } catch (nfe: NumberFormatException) {
            ratingInput?.error = "Обязательное поле"
            return
        }

        if (rating < 1 || rating > 5) {
            ratingInput?.error = "Рейтинг должен быть между 1 и 5"
            return
        }

        val activeUser = activity.let{(it as MainActivity).getActiveUser()}
        val sleep = Sleep(UUID.randomUUID().toString(), activeUser!!, "$startDate $startTime", "$endDate $endTime", rating)
        model.addSleep(sleep)

        activity?.let { (it as MainActivity).goToSleepsFragment() }
        startDateInput?.setText("")
        startTimeInput?.setText("")
        endDateInput?.setText("")
        endTimeInput?.setText("")
        ratingInput?.setText("")
    }

    companion object {
        fun newInstance(viewModel: SleepViewModel) = AddSleepFragment(viewModel)
    }
}