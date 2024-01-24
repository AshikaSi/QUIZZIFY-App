package jiya.learning.quizzify

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Person : Fragment(R.layout.fragment_person) {
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_person, container, false)

        auth = FirebaseAuth.getInstance()

//        val email = arguments?.getString("email")
        val email = auth.currentUser!!.email
//        val displayName = arguments?.getString("displayName")

        val firebase: DatabaseReference = FirebaseDatabase.getInstance().getReference()


//        view.findViewById<TextView>(R.id.nameTextView).text = "$email\n$displayName"

        return view
    }
}
