package com.example.sleepwell

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val api = Api()
    val activeUser: MutableLiveData<User?> = MutableLiveData(null)

    fun login(login: String, password: String): Boolean {
        activeUser.value = api.login(login, password)
        return activeUser.value != null
    }

    fun logout(): Boolean {
        val user = activeUser.value
        if (user != null) {
            return if (api.logout(user.login)) {
                activeUser.value = null
                true
            } else {
                false
            }
        }
        return false
    }

    fun register(login: String, password: String): Boolean {
        return api.register(login, password)
    }
}