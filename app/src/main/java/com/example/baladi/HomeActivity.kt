package com.example.baladi

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExplorerActivity : AppCompatActivity() {

    // Classe qui représente un signalement
    data class Signalement(
        val image: Int,
        val type: String,
        val statut: String,
        val date: String,
        val adresse: String,
        val description: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listeactivity)
    }
}
