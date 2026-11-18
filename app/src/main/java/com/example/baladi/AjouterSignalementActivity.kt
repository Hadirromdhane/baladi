
package com.example.baladi

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AjouterSignalementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ajouter_signalement_activity)

        val spType = findViewById<Spinner>(R.id.spType)
        val edtAdresse = findViewById<EditText>(R.id.edtAdresse)
        val edtDescription = findViewById<EditText>(R.id.edtDescription)
        val btnEnvoyer = findViewById<Button>(R.id.btnEnvoyer)

        val types = ArrayList <String>()
            types.add ("Nid-de-poule")
            types.add ("Éclairage public")
            types.add ("Déchets")
            types.add ("Fuite d'eau")
            types.add ("Espaces verts")


        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, types )


        spType.adapter = adapter //pour relier spinner bl adapter

        btnEnvoyer.setOnClickListener {

            val type = spType.selectedItem.toString()
            val adresse = edtAdresse.text.toString()
            val description = edtDescription.text.toString()

            if (adresse.isEmpty() || description.isEmpty()) {

                Toast.makeText(
                    this,
                    "Veuillez remplir tous les champs",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val date = SimpleDateFormat(
                    "dd/MM/yyyy",
                    Locale.getDefault()
                ).format(Date())

                val intent = Intent()
                intent.putExtra("type", type)
                intent.putExtra("adresse", adresse)
                intent.putExtra("description", description)
                intent.putExtra("date", date)

                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}
