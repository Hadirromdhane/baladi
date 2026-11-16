
package com.example.baladi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
class SignalementActivity : AppCompatActivity() {
    private lateinit var imgPhoto: ImageView

    private val prendrePhoto =
        registerForActivityResult(
            ActivityResultContracts.TakePicturePreview()
        ) { bitmap: Bitmap? ->

            if (bitmap != null) {
                imgPhoto.setImageBitmap(bitmap)
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signalement)
        val btnPhoto = findViewById<Button>(R.id.btnPhoto)
        imgPhoto = findViewById(R.id.imgPhoto)

        btnPhoto.setOnClickListener {
            prendrePhoto.launch(null)
        }
        // Récupération des éléments
        val spinnerGouvernorat =
            findViewById<Spinner>(R.id.spinnerGouvernorat)

        val edtVilleRue =
            findViewById<EditText>(R.id.edtVilleRue)

        val spinnerType =
            findViewById<Spinner>(R.id.spinnerType)


        val btnEnvoyer =
            findViewById<Button>(R.id.btnEnvoyer)

        // Bouton Signaler
        btnEnvoyer.setOnClickListener {

            val gouvernorat = spinnerGouvernorat.selectedItem.toString()
            val villeRue = edtVilleRue.text.toString().trim()
            val type = spinnerType.selectedItem.toString()

            if (spinnerGouvernorat.selectedItemPosition == 0) {

                Toast.makeText(this,
                    "Choisir un gouvernorat",
                    Toast.LENGTH_SHORT).show()

            } else if (villeRue.isEmpty()) {

                edtVilleRue.error = "Saisir la ville et la rue"

            } else if (spinnerType.selectedItemPosition == 0) {

                Toast.makeText(this,
                    "Choisir un type de problème",
                    Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this,
                    "Signalement envoyé avec succès !",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}
