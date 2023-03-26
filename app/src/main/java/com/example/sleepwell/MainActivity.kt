package com.example.sleepwell

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.commit
import com.example.sleepwell.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentFragment: FragmentType = FragmentType.MAIN
    private val model = MainActivityViewModel()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun showMessage(msg: String) {
        binding.message.text = msg
    }

//    fun goToAboutFragment() {
//        supportFragmentManager.commit {
//            replace(binding.frameFragments.id, AboutFragment.newInstance())
//            addToBackStack("main")
//        }
//        currentFragment = FragmentType.ABOUT
//    }
//
//    fun goToAddSleepFragment() {
//        supportFragmentManager.commit {
//            replace(binding.frameFragments.id, AddSleepFragment.newInstance())
//            addToBackStack("main")
//        }
//        currentFragment = FragmentType.ADD_SLEEP
//    }

}