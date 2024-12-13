package com.example.controlaccesouns

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Referencias a los elementos de la vista
        val usernameEditText = findViewById<android.widget.EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<android.widget.EditText>(R.id.passwordEditText)
        val loginButton = findViewById<com.google.android.material.button.MaterialButton>(R.id.loginButton)

        // Configurar el botón de inicio de sesión
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese usuario y contraseña", Toast.LENGTH_SHORT).show()
            } else {
                // Simulación de autenticación
                if (username == "a" && password == "a") {
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                    // Navegar a MainActivity (panel principal que contiene el menú lateral y registros)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Finalizar la actividad actual para que no se pueda volver atrás
                } else {
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
