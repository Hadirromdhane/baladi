package com.example.baladi

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val screen = findViewById<View>(R.id.Screen)

        screen.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)

            finish()
        }
    }
}
