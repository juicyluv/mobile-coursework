package com.example.sleepwell

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.UUID

class AddSleepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sleep)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addSleep(sleep: Sleep) {
        sleepsDataList.add(sleep)
    }

    fun onClickCancel(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onClickAddSleep(view: View) {
        val startDateInput = findViewById<EditText>(R.id.addSleepStartDateText)
        val startTimeInput = findViewById<EditText>(R.id.addSleepStartTimeText)
        val endDateInput = findViewById<EditText>(R.id.addSleepEndDateText)
        val endTimeInput = findViewById<EditText>(R.id.addSleepEndTimeText)
        val ratingInput = findViewById<EditText>(R.id.addSleepRatingText)

        val startDate = startDateInput.text.trim().toString()
        val startTime = startTimeInput.text.trim().toString()
        val endDate = endDateInput.text.trim().toString()
        val endTime = endTimeInput.text.trim().toString()
        var rating = 0

        if (startDate.isEmpty()) {
            startDateInput.error = "Обязательное поле"
            return
        }

        if (startTime.isEmpty()) {
            startTimeInput.error = "Обязательное поле"
            return
        }

        if (endDate.isEmpty()) {
            endDateInput.error = "Обязательное поле"
            return
        }

        if (endTime.isEmpty()) {
            endTimeInput.error = "Обязательное поле"
            return
        }

        try {
            rating = ratingInput.text.trim().toString().toInt()
        } catch (nfe: NumberFormatException) {
            ratingInput.error = "Обязательное поле"
            return
        }

        if (rating < 1 || rating > 5) {
            ratingInput.error = "Рейтинг должен быть между 1 и 5"
            return
        }

        addSleep(Sleep(UUID.randomUUID().toString(), "$startDate $startTime", "$endDate $endTime", rating))

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}