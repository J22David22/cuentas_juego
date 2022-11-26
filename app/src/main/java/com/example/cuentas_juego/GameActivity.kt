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



        var idGroupTraido = intent.getIntExtra("idGroupPasa",0)
        var jugador1 = intent.getStringExtra("jugador1")
        var jugador2 = intent.getStringExtra("jugador2")
        var jugador3 = intent.getStringExtra("jugador3")
        var jugador4 = intent.getStringExtra("jugador4")
        var jugador5 = intent.getStringExtra("jugador5")
        var jugador6 = intent.getStringExtra("jugador6")
        Toast.makeText(this,"Id Traido: "+idGroupTraido.toString(), Toast.LENGTH_SHORT).show()


         getSupportFragmentManager()?.beginTransaction()
             ?.setReorderingAllowed(true)
             ?.replace(R.id.fragment_container_view_home, GameFragment().apply {
                 arguments=Bundle().apply {
                     putString("idGroupPasa",idGroupTraido.toString())
                     putString("jugador1",jugador1)
                     putString("jugador2",jugador2)
                     putString("jugador3",jugador3)
                     putString("jugador4",jugador4)
                     putString("jugador5",jugador5)
                     putString("jugador6",jugador6)
                 }
             })
             ?.addToBackStack("")
             ?.commit()




    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_inferior_game, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.icon_cuentas -> {
            var idGroupTraido = intent.getIntExtra("idGroupPasa",0)
            Toast.makeText(this, "Icono cuentas", Toast.LENGTH_LONG).show()
            var info:Bundle = Bundle()
            info.putString("idGroupPasa",idGroupTraido.toString())
            Toast.makeText(this,"Id Traido: "+idGroupTraido.toString(), Toast.LENGTH_SHORT).show()
            getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fragment_container_view_home, CuentasFragment::class.java, null,"tabla")
                ?.addToBackStack("")
                ?.commit()

            true
        }
        R.id.icon_tabla -> {
            Toast.makeText(this, "Icono tabla", Toast.LENGTH_LONG).show()

            /*var idGroupTraido = intent.getIntExtra("idGroupPasa",0)

            var info:Bundle = Bundle()
            info.putInt("idGroupPasa",idGroupTraido)
            Toast.makeText(this,"Id Traido: "+idGroupTraido.toString(), Toast.LENGTH_SHORT).show()

            getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fragment_container_view_home, GameFragment::class.java, info,"tabla")
                ?.addToBackStack("")
                ?.commit()*/

            true
        }
        else -> super.onOptionsItemSelected(item)

    }
}