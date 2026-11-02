// LoginActivity.kt
package com.kawther.school

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kawther.school.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NotificationHelper.createChannels(this)

        binding.btnLogin.setOnClickListener {
            val user = binding.etUsername.text.toString().trim()
            val pass = binding.etPassword.text.toString().trim()
            if (user == "student" && pass == "123456") {
                saveLoginState(true, user)
                NotificationHelper.showWelcomeNotification(this, user)
                goToMain()
            } else {
                Toast.makeText(this, "بيانات الدخول غير صحيحة (جرب: student / 123456)", Toast.LENGTH_LONG).show()
            }
        }

        binding.tvGuest.setOnClickListener {
            saveLoginState(true, "ضيف")
            goToMain()
        }
    }

    private fun saveLoginState(isLoggedIn: Boolean, username: String) {
        getSharedPreferences("KawtherPrefs", Context.MODE_PRIVATE).edit().apply {
            putBoolean("isLoggedIn", isLoggedIn)
            putString("username", username)
            apply()
        }
    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}