package com.example.sleepwell

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel

class MainActivityViewModel() : ViewModel() {
    private val api = APIImpl()

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllSleeps(): ArrayList<Sleep> {
        return api.getAllSleeps()
    }
}