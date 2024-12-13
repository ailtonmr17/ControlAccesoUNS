package com.example.controlaccesouns

import AccessLogsFragment
import AssignLabsFragment
import ManageCardsFragment
import ReportsFragment
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.drawerLayout)
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)

        // Configurar la Toolbar
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Mostrar el fragmento inicial (Registros de Accesos)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AccessLogsFragment()) // Asegúrate de usar el fragmento correcto
                .commit()
            navigationView.setCheckedItem(R.id.nav_access_logs) // Seleccionar el ítem del menú correspondiente
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_access_logs -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AccessLogsFragment())
                    .commit()
            }
            R.id.nav_assign_labs -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AssignLabsFragment())
                    .commit()
            }
            R.id.nav_manage_cards -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ManageCardsFragment())
                    .commit()
            }
            R.id.nav_reports -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ReportsFragment())
                    .commit()
            }
            R.id.nav_logout -> {
                startActivity(Intent(this, LoginActivity::class.java))
                finish() // Finalizar la actividad actual
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
