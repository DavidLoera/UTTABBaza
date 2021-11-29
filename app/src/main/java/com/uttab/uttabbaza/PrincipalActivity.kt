package com.uttab.uttabbaza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.huawei.agconnect.auth.AGConnectAuth
import com.huawei.agconnect.auth.AGConnectUser
import com.uttab.uttabbaza.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = AGConnectAuth.getInstance().currentUser
        if(user == null) jumpToLogin()
        else jumpToHome(user)



        binding.button2.setOnClickListener {
            val intent: Intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.register.setOnClickListener {
            val intent: Intent = Intent (this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun jumpToHome(user: AGConnectUser) {
        val intent = Intent(this, HomeActivity::class.java).let{
            it.putExtra("account", user.displayName)
            jump(it)
        }
    }

    private fun jump(intent:Intent){
        startActivity(intent)
        finish()
    }

    private fun jumpToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
    }


}