package jiya.learning.quizzify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.auth.FirebaseAuth

class OneActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var btcreate: Button
    private lateinit var btfetch: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        auth = FirebaseAuth.getInstance()

        val email = intent.getStringExtra("email")
        val displayName = intent.getStringExtra("displayName")
        val firebase: DatabaseReference = FirebaseDatabase.getInstance().getReference()

        btcreate =findViewById(R.id.createbutton)
        btfetch =findViewById(R.id.Getbutton)

        findViewById<TextView>(R.id.nameTextView).text = "$email\n$displayName"

        findViewById<TextView>(R.id.signoutTextView).setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
        }
        btcreate.setOnClickListener{
            val intent = Intent(this, InsertionActivity::class.java)
            startActivity(intent)
        }
        btfetch.setOnClickListener{
            val intent = Intent(this, FetchActivity::class.java)
            startActivity(intent)
        }


    }
}
