package com.example.baladi
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

    class RegisterActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.register)

            // Récupérer les éléments XML
            val edtNom = findViewById<EditText>(R.id.edtNom)
            val edtPrenom = findViewById<EditText>(R.id.edtPrenom)
            val edtEmail = findViewById<EditText>(R.id.edtEmail)
            val edtPassword = findViewById<EditText>(R.id.edtPassword)
            val edtConfirmPassword = findViewById<EditText>(R.id.edtConfirmPassword)

            val btnRegister = findViewById<Button>(R.id.btnRegister)
            val txtLogin = findViewById<TextView>(R.id.txtLogin)

            // Retourner à la page Login
            txtLogin.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

            // Cliquer sur Créer mon compte
            btnRegister.setOnClickListener {

                val nom = edtNom.text.toString().trim()
                val prenom = edtPrenom.text.toString().trim()
                val email = edtEmail.text.toString().trim()
                val password = edtPassword.text.toString()
                val confirmPassword = edtConfirmPassword.text.toString()

                // Vérifier les champs vides
                if (nom.isEmpty() || prenom.isEmpty() ||
                    password.isEmpty() || confirmPassword.isEmpty()) {

                    Toast.makeText(
                        this,
                        "Veuillez remplir tous les champs",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                // Vérifier la confirmation du mot de passe
                else if (password != confirmPassword) {

                    Toast.makeText(
                        this,
                        "mots de passe incorrect",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                // Toutes les vérifications sont correctes
                else {

                    Toast.makeText(
                        this,
                        "inscription valide",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
        }
    }

