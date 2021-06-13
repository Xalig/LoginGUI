package com.example.login

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivityMainRegisterBinding
import com.example.login.databinding.ActivityMainWelcomeBinding

class MainRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.registerName.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
//        binding.registerPassword.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)

        binding.btnSave.setOnClickListener{
            var userinfo = binding.registerName.text.toString()
            var userpassw = binding.registerPassword.text.toString()
            var sharedPreferences = this.getSharedPreferences("info", MODE_PRIVATE)
            var editor = sharedPreferences.edit()

            editor.putString("user", "$userinfo").apply()
            editor.putString("password", "$userpassw").apply()
            Toast.makeText(applicationContext, "Регистрация успешна", Toast.LENGTH_LONG).show()
            binding.registerName.text.clear()
            binding.registerPassword.text.clear()
        }


        binding.btnPrevious.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}