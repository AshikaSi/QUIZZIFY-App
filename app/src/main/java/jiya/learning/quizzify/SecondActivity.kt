package jiya.learning.quizzify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import jiya.learning.quizzify.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
            firebaseAuth= FirebaseAuth.getInstance()
        binding.SignIn1TextView.setOnClickListener{
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        binding.SignUp1Button.setOnClickListener{

            val email = binding.emailEditText.text.toString()
            val username = binding.username1EditText.text.toString()
            val pass = binding.password1EditText.text.toString()
            val confirmpass=binding.confirmEditText.text.toString()

            if (email.isNotEmpty() && username.isNotEmpty() && pass.isNotEmpty() && confirmpass.isNotEmpty()){
                if(pass==confirmpass){
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this, FirstActivity::class.java)
                        startActivity(intent)

                    }else{
                        Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                    }
                }
                }else{
                    Toast.makeText(this,"Password is Not Matching.",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Empty Fields Are Not Allowed.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}