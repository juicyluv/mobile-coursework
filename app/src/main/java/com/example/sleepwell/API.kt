package com.example.sleepwell

import android.os.Build
import androidx.annotation.RequiresApi

interface API {
    fun getAllSleeps(): ArrayList<Sleep>
}

class APIImpl : API {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getAllSleeps(): ArrayList<Sleep> {
        val sleepsList = sleepsDataList

        if(sleepsList.isNotEmpty()) {
            return sleepsList
        }

        return arrayListOf()
    }

}