package com.example.coronavaccinemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {
    private val RC_SIGN_IN=7
    private lateinit var googleSignInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id_auth))
            .requestEmail()
            .build()

         googleSignInClient = GoogleSignIn.getClient(this, gso)

        val signInButton: SignInButton =findViewById(R.id.signInButton)
        signInButton.setOnClickListener{
            signIn()
            Log.d("Fire007","hehe boii")
        }
        val button: Button =findViewById(R.id.button)
        button.setOnClickListener{
            startActivity(Intent(this,MobNumEnter::class.java))
        }

    }
    fun signIn() {

        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d("success", "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("error", "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val auth= FirebaseAuth.getInstance()
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("fire007", "signInWithCredential:success")
                    Toast.makeText(this,"successful",Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser

                    startActivity(Intent(this,MainActivity::class.java))
                    Log.d("Fire007","FirebaseAuthwithgoogle: ${user?.displayName}")

                } else {
                    Toast.makeText(this,"not successful",Toast.LENGTH_SHORT).show()
                    Log.w("fire007", "signInWithCredential:failure", task.exception)
                }
            }
    }

}