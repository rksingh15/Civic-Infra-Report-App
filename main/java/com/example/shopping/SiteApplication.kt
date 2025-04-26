package com.example.shopping

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel

class SiteApplication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site_application)

        val button: Button = findViewById(R.id.openPunjab)
        val Rbutton: Button = findViewById(R.id.openPunjabResister)

        button.setOnClickListener {
            val url = "https://connect.punjab.gov.in/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            startActivity(intent)
        }
        Rbutton.setOnClickListener {
            val url = "https://connect.punjab.gov.in/ssocitizen/register/https:%2F%2Fconnect.punjab.gov.in"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            startActivity(intent)
        }
    }
}