package com.example.shopping
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import java.io.File
import java.io.FileWriter
import java.io.IOException

class ProfileShow : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAddress: EditText
    private lateinit var btnSave: Button

    private val fileName = "user_profile.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_show)

        val pback: ImageView= findViewById(R.id.backIcon)

        pback.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)


            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            startActivity(intent)
            finish()
        }

        etFullName = findViewById(R.id.PFullName)
        etPhone = findViewById(R.id.PPhone)
        etEmail = findViewById(R.id.PEmail)
        etAddress = findViewById(R.id.PAddress)
        btnSave = findViewById(R.id.btnSave)

        ensureFileExists()
        loadProfile()

        btnSave.setOnClickListener {
            saveProfile()
        }
    }

    private fun ensureFileExists() {
        val file = File(filesDir, fileName)
        if (!file.exists()) {
            try {
                file.createNewFile()
                Toast.makeText(this, "Profile file created", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                Toast.makeText(this, "File creation failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveProfile() {
        val data = """
            ${etFullName.text}
            ${etPhone.text}
            ${etEmail.text}
            ${etAddress.text}
        """.trimIndent()

        try {
            val file = File(filesDir, fileName)
            val writer = FileWriter(file, false) // false = overwrite
            writer.write(data)
            writer.close()

            Toast.makeText(this, "Profile saved", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(this, "Failed to save profile", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadProfile() {
        try {
            val file = File(filesDir, fileName)
            if (file.exists()) {
                val lines = file.readLines()
                if (lines.size >= 4) {
                    etFullName.setText(lines[0])
                    etPhone.setText(lines[1])
                    etEmail.setText(lines[2])
                    etAddress.setText(lines[3])
                }
            }
        } catch (e: IOException) {
            Toast.makeText(this, "Error loading profile", Toast.LENGTH_SHORT).show()
        }
    }
}
