package com.example.sleepwell

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
val sleepsDataList: ArrayList<Sleep> = arrayListOf(
    Sleep("1","2023-03-25 22:30", "2023-03-26 07:30", 5),
    Sleep("2","2023-03-26 23:00", "2023-03-27 08:00", 3),
    Sleep("3","2023-03-24 23:30", "2023-03-24 08:30", 4),
    Sleep("4","2023-03-23 00:00", "2023-03-23 07:00", 5),
)