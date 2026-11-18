package com.example.baladi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

    class LoginActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_login)
            // Récupérer les éléments XML

            val btnRegister = findViewById<Button>(R.id.btnRegister)
            val edtEmail = findViewById<EditText>(R.id.edtEmail)
            val edtPassword = findViewById<EditText>(R.id.edtPassword)
            val btnLogin = findViewById<Button>(R.id.btnLogin)

            // Cliquer sur S'inscrire
            btnRegister.setOnClickListener {
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

                // Vérifier les informations du compte
                else if (email == UserData.email &&
                    password == UserData.password) {

                    Toast.makeText(
                        this,
                        "Connexion réussie",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(this, ListeActivity ::class.java)
                    startActivity(intent)
                    finish()

                } else {

                    Toast.makeText(
                        this,
                        "Email ou mot de passe incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }