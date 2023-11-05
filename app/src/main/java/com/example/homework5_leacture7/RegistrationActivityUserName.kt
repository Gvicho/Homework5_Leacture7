package com.example.homework5_leacture7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework5_leacture7.databinding.ActivityRegistrationBinding
import com.example.homework5_leacture7.databinding.ActivityRegistrationUserNameBinding

class RegistrationActivityUserName : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationUserNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationUserNameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backBtn.setOnClickListener{
            this.finish()
        }
        binding.btnSingUp.setOnClickListener{
            handle()
        }
    }

    private fun handle(){
        val userName = binding.edtTxtRegUsrnm.text.toString()

        if(userName.isEmpty()){
            Toast.makeText(this, "Please enter your nikname", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Hi $userName,Your accaunt is ready", Toast.LENGTH_LONG).show()
            finish()
        }
    }

}