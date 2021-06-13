package com.example.login

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.databinding.ActivityMainWelcomeBinding

class MainWelcome: AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("info", MODE_PRIVATE)
        var reguser = preferences.getString("user", "")
        var regpassw = preferences.getString("password", "")

        binding.userInfo.text = "Имя пользователя:"+reguser.toString()
        binding.userPassword.text = "Пароль пользователя:"+regpassw.toString()

        binding.btnExit.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}