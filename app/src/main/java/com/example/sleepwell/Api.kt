package com.example.sleepwell

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.UUID

interface IApi {
    fun login(login: String, password: String): User?
    fun logout(login: String): Boolean
    fun register(login: String, password: String): Boolean
    fun addUserSleep(sleep: Sleep)
    fun getUserSleeps(user: User): ArrayList<Sleep>
}

class Api : IApi {
    override fun login(login: String, password: String): User? {
        val users = usersDataList
        for (user in users) {
            if (user.login == login && user.password == password) {
                return user
            }
        }
        return null
    }

    override fun logout(login: String): Boolean {
        val users = usersDataList
        for (user in users) {
            if (user.login == login) {
                return true
            }
        }
        return false
    }

    override fun register(login: String, password: String): Boolean {
        val users = usersDataList
        for (user in users) {
            if (user.login == login) {
                return false
            }
        }
        usersDataList.add(User(UUID.randomUUID().toString(), login, password))
        return true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun addUserSleep(sleep: Sleep) {
        sleepsDataList.add(sleep)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getUserSleeps(user: User): ArrayList<Sleep> {
        val sleeps = ArrayList<Sleep>()
        for (sleep in sleepsDataList) {
            if (sleep.user.id == user.id) {
                sleeps.add(sleep)
            }
        }
        return sleeps
    }
}