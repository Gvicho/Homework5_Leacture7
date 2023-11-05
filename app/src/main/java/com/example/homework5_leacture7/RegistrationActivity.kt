package com.example.homework5_leacture7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework5_leacture7.databinding.ActivityMainBinding
import com.example.homework5_leacture7.databinding.ActivityRegistrationBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backBtn.setOnClickListener(){
            this.finish()
        }

        binding.btnRegNext1.setOnClickListener{
            handle()
        }
    }

    private fun handle(){
        val mail:String = binding.edtTxtRegEmail.text.toString()
        val password:String = binding.edtTxtRegPass.text.toString()
        if(mail.isEmpty()||password.isEmpty()) {
            Toast.makeText(this, "Fill all fields!", Toast.LENGTH_SHORT).show()
            return
        }
        val mailR = mail.trim{it<=' '}
        val passwordR = password.trim{it<=' '}

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(mailR,passwordR).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Registration was Succesfull", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, RegistrationActivityUserName::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Registration was failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}