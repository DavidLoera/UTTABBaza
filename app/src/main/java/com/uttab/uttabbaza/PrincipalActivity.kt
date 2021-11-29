package com.uttab.uttabbaza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uttab.uttabbaza.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            val intent: Intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.register.setOnClickListener {
            val intent: Intent = Intent (this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}