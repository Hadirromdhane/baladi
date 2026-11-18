package com.example.baladi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val edtNom = findViewById<EditText>(R.id.edtNom)
        val edtPrenom = findViewById<EditText>(R.id.edtPrenom)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtTel = findViewById<EditText>(R.id.edtTel)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val edtConfirmPassword =
            findViewById<EditText>(R.id.edtConfirmPassword)

        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {

            val nom = edtNom.text.toString()
            val prenom = edtPrenom.text.toString()
            val email = edtEmail.text.toString()
            val tel = edtTel.text.toString()
            val password = edtPassword.text.toString()
            val confirmPassword =
                edtConfirmPassword.text.toString()

            if (nom.isEmpty() || prenom.isEmpty() ||
                email.isEmpty() || tel.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty()) {

                Toast.makeText(this,
                    "Veuillez remplir tous les champs",
                    Toast.LENGTH_SHORT).show()

            } else if (password != confirmPassword) {

                Toast.makeText(this,
                    "Les mots de passe ne correspondent pas",
                    Toast.LENGTH_SHORT).show()

            } else {

                UserData.email = email
                UserData.password = password

                Toast.makeText(this,
                    "Compte créé avec succès !",
                    Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
