package com.example.login

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = getSharedPreferences("info", MODE_PRIVATE)
//        binding.loginUsername.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP)
//        binding.loginPassword.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_ATOP)

        binding.btnLogin.setOnClickListener{
            var reguser = preferences.getString("user", "")
            var regpass = preferences.getString("password", "")

            var loguser = binding.loginUsername.text.toString()
            var logpass = binding.loginPassword.text.toString()

            if ((reguser == loguser) && (regpass == logpass)) {
                intent = Intent(applicationContext, MainWelcome::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Повторите попытку", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnRegister.setOnClickListener{
            intent = Intent(applicationContext, MainRegister::class.java)
            startActivity(intent)
        }
    }
}