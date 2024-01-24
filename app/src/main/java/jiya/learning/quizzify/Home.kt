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


class Home : Fragment(R.layout.fragment_home) {
    private lateinit var btcreate: Button
    private lateinit var btfetch: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        auth = FirebaseAuth.getInstance()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Your existing code here
        btcreate = view.findViewById(R.id.createbutton)
        btfetch = view.findViewById(R.id.Getbutton)

        view.findViewById<TextView>(R.id.signoutTextView).setOnClickListener {
            auth.signOut()
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        btcreate.setOnClickListener {
            val intent = Intent(requireContext(), InsertionActivity::class.java)
            startActivity(intent)
        }

        btfetch.setOnClickListener {
            val intent = Intent(requireContext(), FetchActivity::class.java)
            startActivity(intent)
        }
    }
}

