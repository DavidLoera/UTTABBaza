package com.uttab.uttabbaza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uttab.uttabbaza.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.login.setOnClickListener {
            val intent: Intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.arrow.setOnClickListener {
            val intent: Intent = Intent (this, PrincipalActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}