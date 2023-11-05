package com.example.homework5_leacture7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework5_leacture7.databinding.ActivityLogInBinding
import com.example.homework5_leacture7.databinding.ActivityMainBinding
import com.example.homework5_leacture7.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backBtn.setOnClickListener{
            this.finish()
        }
        binding.btnLogIn.setOnClickListener{
            handle()
        }
    }

    private fun handle(){
        val mail:String = binding.edtTxtLogInEmail.text.toString()
        val password:String = binding.edtTxtLogInPass.text.toString()
        if(mail.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Fill all fields!", Toast.LENGTH_SHORT).show()
            return
        }

        val mailR = mail.trim{it<=' '}
        val passwordR = password.trim{it<=' '}

        FirebaseAuth.getInstance().signInWithEmailAndPassword(mailR,passwordR).addOnCompleteListener{ task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "You Loged In successfuly", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Couldn't Log In", Toast.LENGTH_SHORT).show()
            }
        }
    }
}