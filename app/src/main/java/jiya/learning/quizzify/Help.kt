package jiya.learning.quizzify

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.TextView


class Help : Fragment(R.layout.fragment_help) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access the TextView and Button from the layout
        val helpTextView = view.findViewById<TextView>(R.id.helpTextView)
        val openGoogleButton = view.findViewById<Button>(R.id.openGoogleButton)

        // Set click listener for the button to open Google
        openGoogleButton.setOnClickListener {
            openGoogle()
        }
    }

    private fun openGoogle() {
        // Create an Intent to open Google in a web browser
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        startActivity(intent)
    }
}