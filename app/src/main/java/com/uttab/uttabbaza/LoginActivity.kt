package com.uttab.uttabbaza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uttab.uttabbaza.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        setContentView(R.layout.activity_principal)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.register.setOnClickListener {
            val intent: Intent = Intent (this, RegisterActivity::class.java)
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