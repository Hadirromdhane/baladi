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
        setContentView(R.layout.activityhome)

        // Récupérer le LinearLayout
        val layoutSignalements =
            findViewById<LinearLayout>(R.id.layoutSignalements)

        // Récupérer le bouton filtres
        val btnFiltres =
            findViewById<Button>(R.id.btnFiltres)

        // Liste des signalements (données de test)
        val listeSignalements = listOf(

            Signalement(
                android.R.drawable.ic_menu_gallery,
                "Nid-de-poule sur la route",
                "En attente",
                "15/11/2026",
                "Gabès, Rue Habib Bourguiba",
                "Un grand trou dans la route qui gêne la circulation."
            ),

            Signalement(
                android.R.drawable.ic_menu_gallery,
                "Accumulation de déchets",
                "En cours",
                "14/11/2026",
                "Tunis, Centre-ville",
                "Des déchets sont accumulés sur le trottoir."
            ),

            Signalement(
                android.R.drawable.ic_menu_gallery,
                "Éclairage public cassé",
                "Résolu",
                "13/11/2026",
                "Sfax, Route de Tunis",
                "Un lampadaire ne fonctionne plus."
            )
        )

        // Afficher les signalements
        for (signalement in listeSignalements) {

            // Charger le fichier item_signalement.xml
            val card = LayoutInflater.from(this).inflate(
                R.layout.item_signalement,
                layoutSignalements,
                false
            )

            // Récupérer les éléments de la Card
            val imgSignalement =
                card.findViewById<ImageView>(R.id.imgSignalement)

            val txtType =
                card.findViewById<TextView>(R.id.txtType)

            val txtStatut =
                card.findViewById<TextView>(R.id.txtStatut)

            val txtDate =
                card.findViewById<TextView>(R.id.txtDate)

            val txtAdresse =
                card.findViewById<TextView>(R.id.txtAdresse)

            val txtDescription =
                card.findViewById<TextView>(R.id.txtDescription)

            // Remplir la Card avec les données
            imgSignalement.setImageResource(signalement.image)

            txtType.text = signalement.type
            txtStatut.text = signalement.statut
            txtDate.text = signalement.date
            txtAdresse.text = "📍 " + signalement.adresse
            txtDescription.text = signalement.description

            // Changer la couleur selon le statut
            when (signalement.statut) {
                "En attente" ->
                    txtStatut.setBackgroundColor(
                        android.graphics.Color.rgb(217, 154, 39)
                    )

                "En cours" ->
                    txtStatut.setBackgroundColor(
                        android.graphics.Color.rgb(40, 120, 190)
                    )

                "Résolu" ->
                    txtStatut.setBackgroundColor(
                        android.graphics.Color.rgb(36, 107, 80)
                    )
            }

            // Ajouter la Card dans la page Explorer
            layoutSignalements.addView(card)
        }

        // Action du bouton filtres
        btnFiltres.setOnClickListener {
            android.widget.Toast.makeText(
                this,
                "Filtres bientôt disponibles",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
    }
}
