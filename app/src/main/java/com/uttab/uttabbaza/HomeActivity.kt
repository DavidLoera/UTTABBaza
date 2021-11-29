package com.uttab.uttabbaza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.huawei.agconnect.auth.AGConnectAuth

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bundle = intent.extras

        val name = bundle?.getString("account", "Usuario Anónimo")

        findViewById<TextView>(R.id.hello).setText(name)
        findViewById<Button>(R.id.logout).setOnClickListener{logout()}

    }

    private fun logout() {
        AGConnectAuth.getInstance().signOut()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}