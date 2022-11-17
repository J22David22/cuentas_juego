package com.example.cuentas_juego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var listaAdapter:ListaAdapter
    lateinit var jugadores: List<String>
    lateinit var jugadores2:List<String>
    var dataList = mutableListOf<Group>()

    lateinit var button_crear_grupo:MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_grupos)
        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        listaAdapter= ListaAdapter(applicationContext)
        recyclerView.adapter=listaAdapter
        jugadores=listOf("Jaime","David", "", "", "", "")
        jugadores2 = listOf("Ofe","David", "Jaime", "", "", "")
        dataList.add(Group(0,jugadores))
        dataList.add(Group(1,jugadores2))

        listaAdapter.setDataList(dataList)

        button_crear_grupo=findViewById(R.id.button_crear_grupo)


        button_crear_grupo.setOnClickListener{
            getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.layout_main, CrearFragment::class.java, null,"crear_grupo")
                ?.addToBackStack("")
                ?.commit()
        }

    }
}