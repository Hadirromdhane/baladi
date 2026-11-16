
package com.example.baladi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listactivity)

        val listSignalements =
            findViewById<ListView>(R.id.listSignalements)

        val btnAjouter =
            findViewById<Button>(R.id.btnAjouter)

        btnAjouter.setOnClickListener {
            val intent = Intent(this, AjouterSignalementActivity::class.java)
            startActivity(intent)
        }
    }
}
