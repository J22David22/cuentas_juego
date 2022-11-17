package com.example.cuentas_juego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.ButtonBarLayout
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.navigation.NavigationView

class GameActivity : AppCompatActivity() {

    lateinit var buttonAppBar: BottomAppBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_inferior_game, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.icon_cuentas -> {

            Toast.makeText(this, "Icono cuentas", Toast.LENGTH_LONG).show()

            getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fragment_container_view_home, CuentasFragment::class.java, null,"tabla")
                ?.addToBackStack("")
                ?.commit()

            true
        }
        R.id.icon_tabla -> {
            Toast.makeText(this, "Icono tabla", Toast.LENGTH_LONG).show()

            getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fragment_container_view_home, GameFragment::class.java, null,"tabla")
                ?.addToBackStack("")
                ?.commit()
            true
        }
        else -> super.onOptionsItemSelected(item)

    }
}