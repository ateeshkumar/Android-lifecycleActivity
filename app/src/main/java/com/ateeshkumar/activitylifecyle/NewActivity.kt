package com.ateeshkumar.activitylifecyle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewActivity: AppCompatActivity(){

//        override fun onClick(view: View?) {
//            try {
//                Toast.makeText(
//                    this@NewActivity,
//                    "Action listener is an active",
//                    Toast.LENGTH_LONG
//                ).show()
//            } catch (e: Exception) {
//                println(e)
//            }
//
//        }
  private  lateinit var btnLogin: Button
  private  lateinit var username: EditText
  private  lateinit var password: EditText
  private  lateinit var txtForgathers: TextView
  private  lateinit var txtRegister: TextView
    private val validMobileNumber = "8004640159"
   private val validPassword = arrayOf("tony","iron","bravo","brush","ateesh","google")
   private lateinit var sharedPreference: SharedPreferences

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       sharedPreference = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
       val isLoggedIn = sharedPreference.getBoolean("isLoggedIn",false)
       setContentView(R.layout.activity_new)
       if(isLoggedIn){
           val intent = Intent(this@NewActivity,MainActivity::class.java)
           startActivity(intent)
           finish()
       }

        println("onCreate action")
        title="Ates"
        btnLogin = findViewById(R.id.btnLogin)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        txtForgathers = findViewById(R.id.txtForgathers)
        txtRegister = findViewById(R.id.txtRegister)


//       shorthand method
//        btnLogin.setOnClickListener{
//            Toast.makeText(this@NewActivity, "On click is active", Toast.LENGTH_LONG).show()
//            val intent = Intent(this@NewActivity, MainActivity::class.java)
//            startActivity(intent)
//        }

//       check othentication using pass
       btnLogin.setOnClickListener{
           val mobileno= username.text.toString()
           val pass = password.text.toString()
           var nameOfavencher = "avrnture"
           val intent = Intent(this@NewActivity, MainActivity::class.java)
           if (mobileno==validMobileNumber){
               if(pass==validPassword[0]){
                  nameOfavencher="tony"
                   savPreference(nameOfavencher)
                   startActivity(intent)
               }else if(pass==validPassword[1]){
                   nameOfavencher="Iron man"
                   savPreference(nameOfavencher)

                   startActivity(intent)
               }else if (pass==validPassword[2]){
                   nameOfavencher= "Caption america"
                   savPreference(nameOfavencher)

               }else if(pass==validPassword[3]){
                 nameOfavencher = "The Hulk"
                   savPreference(nameOfavencher)

                   startActivity(intent)
               }else if(pass == validPassword[4]){
                  nameOfavencher="Ateesh kumar"
                   savPreference(nameOfavencher)

                   startActivity(intent)
               }else if(pass == validPassword[5]){
                  nameOfavencher="Google"
                   savPreference(nameOfavencher)

                   startActivity(intent)
               }else{
                   Toast.makeText(this, "Invalid Input!!", Toast.LENGTH_SHORT).show()
               }
           }else{
               Toast.makeText(this@NewActivity, "Invalid Input!!", Toast.LENGTH_LONG).show()
           }
       }
    }
    override fun onStart() {
        super.onStart()
        println("Start action")
    }

    override fun onResume() {
        super.onResume()
        println("onResume action")
    }

    override fun onPause() {
        super.onPause()
        println("onPause action")
        finish()
    }

    override fun onStop() {
        super.onStop()
        println("onStop action")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy action")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart action")
    }

    private fun savPreference(title: String){
        sharedPreference.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreference.edit().putString("Title",title).apply()
    }

}