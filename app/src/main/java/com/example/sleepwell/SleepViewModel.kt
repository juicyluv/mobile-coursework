package com.example.sleepwell

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SleepViewModel(private val user: User?) : ViewModel() {
    private val api: IApi = Api()
    val sleeps: MutableLiveData<ArrayList<Sleep>> by lazy {
        MutableLiveData<ArrayList<Sleep>>()
    }

    init {
        getSleepsByCurrentUser()
    }

    fun getSleepsByCurrentUser() {
        if (user !== null) {
            sleeps.value = api.getUserSleeps(user)
        } else {
            sleeps.value = arrayListOf()
        }
    }

    fun addSleep(sleep: Sleep) {
        api.addUserSleep(sleep)
    }
}