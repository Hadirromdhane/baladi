package com.example.baladi

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listeactivity)

        val listSignalements =
            findViewById<ListView>(R.id.listSignalements)

        val btnAjouter =
            findViewById<Button>(R.id.btnAjouter)

        val signalements = ArrayList<String>()

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            signalements
        )

        listSignalements.adapter = adapter

        btnAjouter.setOnClickListener {
            val intent = Intent(this, AjouterSignalementActivity::class.java)
            startActivity(intent)
        }
    }
}
