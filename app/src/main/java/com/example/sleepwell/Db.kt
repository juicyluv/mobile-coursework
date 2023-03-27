package com.example.sleepwell

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.UUID

val usersDataList : ArrayList<User> = arrayListOf(
    User(UUID.randomUUID().toString(),"test123", "pass"),
    User(UUID.randomUUID().toString(),"login", "password")
)

@RequiresApi(Build.VERSION_CODES.O)
val sleepsDataList: ArrayList<Sleep> = arrayListOf(
    Sleep(UUID.randomUUID().toString(), usersDataList[1], "25.03 22:30", "26.03 07:30", 5),
    Sleep(UUID.randomUUID().toString(), usersDataList[1],"26.03 23:00", "27.03 08:00", 3),
    Sleep(UUID.randomUUID().toString(), usersDataList[0],"24.03 23:30", "25.03 08:30", 4),
    Sleep(UUID.randomUUID().toString(), usersDataList[0],"27.03 00:00", "28.04 07:00", 5),
)