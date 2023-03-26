package com.example.sleepwell

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sleepwell.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_sleeps.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var sleepAdapter: SleepAdapter
//    private var currentFragment: FragmentType = FragmentType.MAIN

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        retrieveSleeps()
    }

    private fun initRecyclerView() {
        sleepAdapter = SleepAdapter()

        with(sleepsList) {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = sleepAdapter
            this.setHasFixedSize(true)
        }
    }

    fun showMessage(msg: String) {

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun retrieveSleeps() {
        lifecycleScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                sleepAdapter.setSleeps(sleepsDataList)
            }
        }
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