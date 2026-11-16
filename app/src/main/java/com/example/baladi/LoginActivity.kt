package com.example.baladi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

    class LoginActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_login)

            // Récupérer les éléments XML
            val edtEmail = findViewById<EditText>(R.id.edtEmail)
            val edtPassword = findViewById<EditText>(R.id.edtPassword)
            val btnLogin = findViewById<Button>(R.id.btnLogin)
            val txtRegister = findViewById<TextView>(R.id.txtRegister)

            // Cliquer sur S'inscrire
            txtRegister.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }

            // Cliquer sur Se connecter

            btnLogin.setOnClickListener {

                val email = edtEmail.text.toString().trim()
                val password = edtPassword.text.toString()

                // Vérifier si les champs sont vides
                if (email.isEmpty() || password.isEmpty()) {

                    Toast.makeText(
                        this,
                        "Veuillez remplir tous les champs",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                // Vérifier le format de l'adresse e-mail
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                    Toast.makeText(
                        this,
                        "Adresse e-mail invalide",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                // Vérifier la longueur du mot de passe
                else if (password.length < 6) {

                    Toast.makeText(
                        this,
                        "Le mot de passe doit contenir au moins 6 caractères",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                // Si toutes les vérifications sont correctes affiche l activite home
                else {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                }
            }
        }
