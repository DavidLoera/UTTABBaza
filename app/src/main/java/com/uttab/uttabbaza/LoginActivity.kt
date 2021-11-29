package com.uttab.uttabbaza

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.huawei.agconnect.auth.AGConnectAuth
import com.huawei.agconnect.auth.AGConnectUser
import com.huawei.agconnect.auth.HwIdAuthProvider
import com.huawei.hmf.tasks.Task
import com.huawei.hms.support.account.AccountAuthManager
import com.huawei.hms.support.account.request.AccountAuthParams
import com.huawei.hms.support.account.request.AccountAuthParamsHelper
import com.huawei.hms.support.account.result.AuthAccount
import com.huawei.hms.support.hwid.ui.HuaweiIdAuthButton
import com.uttab.uttabbaza.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    companion object{
        const val HW_ID=100
    }
    private lateinit var  binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val huaweiBtn = findViewById<HuaweiIdAuthButton>(R.id.huaweiIdBtn)
        val mailBtn = findViewById<Button>(R.id.mailbtn)
        val anonimBtn = findViewById<Button>(R.id.anonimo)

        huaweiBtn.setOnClickListener{
            signInHuawei()
        }

        mailBtn.setOnClickListener {
            mailSignIn()
        }

        anonimBtn.setOnClickListener {
            anonSingIn()
        }

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

    private fun anonSingIn() {
        TODO("Not yet implemented")
    }

    private fun mailSignIn() {
        TODO("Not yet implemented")
    }

    private fun signInHuawei() {
        val authParams: AccountAuthParams = AccountAuthParamsHelper(AccountAuthParams.DEFAULT_AUTH_REQUEST_PARAM)
            .setAccessToken()
            .createParams();
        val service = AccountAuthManager.getService(this, authParams)

// Enable the sign-in process when necessary. For example, you can create a button and call the following method in the button tap event:
        startActivityForResult(service!!.signInIntent, HW_ID)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            HW_ID -> processHWId(data)
        }
    }

    private fun processHWId(data: Intent?) {
        val authAccountTask: Task<AuthAccount> = AccountAuthManager.parseAuthResultFromIntent(data)
        if (authAccountTask.isSuccessful()) {
            val authAccount: AuthAccount = authAccountTask.result
            Log.i("HWID", "accessToken:" + authAccount.getAccessToken())

            val credential = HwIdAuthProvider.credentialWithToken(authAccount.accessToken)
            AGConnectAuth.getInstance().signIn(credential).addOnSuccessListener {
                // onSuccess
                val user = it.user
                it.user.let {
                    jumpToHome(user)
                }

            }.addOnFailureListener {
                // onFail
            }
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
}