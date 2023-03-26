package com.example.sleepwell
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

@RequiresApi(Build.VERSION_CODES.O)
class SleepsViewModel() : ViewModel() {
    private val api = APIImpl()

    val sleeps: MutableLiveData<ArrayList<Sleep>> by lazy {
        MutableLiveData<ArrayList<Sleep>>()
    }
    init {
        getAllSleeps()
    }
    fun getAllSleeps() {
        sleeps.value = api.getAllSleeps()
    }
}