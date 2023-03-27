package com.example.sleepwell

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.commit
import com.example.sleepwell.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model = MainActivityViewModel()
    private var currentFragment: FragmentType = FragmentType.LOGIN
    private val api: IApi = Api()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model.activeUser.observe(this) { newUser ->
            if (newUser == null) {
                goToLoginFragment()
            } else {
                showMessage(getString(R.string.empty_text))
                goToMainFragment()
            }
        }
    }

    fun showMessage(text: String) {
        binding.message.text = text
    }

    fun login(login: String, password: String) {
        if (login == "" || password == "") {
            showMessage(getString(R.string.non_empty_fields_message))
            return
        }
        val loginCheck = model.login(login, password)
        if (!loginCheck) {
            showMessage(getString(R.string.bad_login_or_password_message))
        }
    }

    fun logout() {
        model.logout()
    }

    fun register(login: String, password: String) {
        if (login == "" || password == "") {
            showMessage(getString(R.string.non_empty_fields_message))
            return
        }
        if (model.register(login, password)) {
            showMessage(getString(R.string.success_registration_messsage))
        } else {
            showMessage(getString(R.string.login_already_exist_message))
        }
    }

    fun getActiveUser(): User? {
        return model.activeUser.value
    }

    private fun goToMainFragment() {
        supportFragmentManager.commit {
            replace(binding.frameFragments.id, MainFragment.newInstance())
        }
        currentFragment = FragmentType.MAIN
    }

    private fun goToLoginFragment() {
        supportFragmentManager.commit {
            replace(binding.frameFragments.id, LoginFragment.newInstance())
        }
        currentFragment = FragmentType.LOGIN
    }

    fun goToAboutFragment() {
        supportFragmentManager.commit {
            replace(binding.frameFragments.id, AboutFragment.newInstance())
            addToBackStack("main")
        }
        currentFragment = FragmentType.ABOUT
    }

    fun goToSleepsFragment() {
        supportFragmentManager.commit {
            replace(binding.frameFragments.id, SleepsFragment.newInstance())
            addToBackStack("main")
        }
        currentFragment = FragmentType.SLEEPS
    }
    fun goToAddSleepFragment(viewModel: SleepViewModel) {
        supportFragmentManager.commit {
            replace(binding.frameFragments.id, AddSleepFragment.newInstance(viewModel))
            addToBackStack("main")
        }
        currentFragment = FragmentType.ADD_SLEEP
    }
}