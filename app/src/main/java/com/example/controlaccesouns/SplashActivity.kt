package com.example.controlaccesouns


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Configurar el retraso para mostrar la siguiente pantalla
        Handler(Looper.getMainLooper()).postDelayed({
            // Navegar a la pantalla de inicio de sesión
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Finaliza SplashActivity para no volver a ella
        }, 3000) // Retraso de 3 segundos
    }
}
