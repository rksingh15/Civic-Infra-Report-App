package com.example.shopping

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupToolbar()
        displayWelcomeMessage()

        val imageDetail: TextView = findViewById(R.id.imageDetail)
        val image1: ImageView = findViewById(R.id.image1)
        val image2: ImageView = findViewById(R.id.image2)
        val image3: ImageView = findViewById(R.id.image3)
        val image4: ImageView = findViewById(R.id.image4)
        val image5: ImageView = findViewById(R.id.image5)
        val image6: ImageView = findViewById(R.id.image6)
        val nextPage: Button = findViewById(R.id.buttonNext)

        nextPage.setOnClickListener {
            val intent = Intent(this, SiteApplication::class.java)
            startActivity(intent)

            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }



        image1.setOnClickListener {
            imageDetail.text = getString(R.string.ImageText1)
        }
        image2.setOnClickListener {
            imageDetail.text = getString(R.string.ImageText2)
        }
        image3.setOnClickListener {
            imageDetail.text = getString(R.string.ImageText3)
        }
        image4.setOnClickListener {
            imageDetail.text = getString(R.string.ImageText4)
        }
        image5.setOnClickListener {
            imageDetail.text = getString(R.string.ImageText5)
        }
        image6.setOnClickListener {
            imageDetail.text = getString(R.string.ImageText6)
        }


    }


    /*
     Sets up the toolbar with a back button.
     */
    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Enable the back button in the toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    /*
      Displays a welcome message with the username.
     */
    private fun displayWelcomeMessage() {
        val username = intent.getStringExtra("username") ?: "User"
        supportActionBar?.title = "Welcome, $username"
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, LoginPage::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)

                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
                true
            }

            R.id.action_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
                true
            }

            R.id.action_profile -> {
                val intent = Intent(this, ProfileShow::class.java)
                startActivity(intent)

                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }

            R.id.action_logout -> {
                val intent = Intent(this, LoginPage::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)

                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
