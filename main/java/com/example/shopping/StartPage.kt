package com.example.shopping

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class StartPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start_page)

        val videoView: VideoView = findViewById(R.id.videoView)

        try {

            val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.videostart2}")
            videoView.setVideoURI(videoUri)


            videoView.setOnCompletionListener {
                val intent = Intent(this, LoginPage::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }

            videoView.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
