package com.example.cuentas_juego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cuentas_juego.room_database.GruposDatabase
import com.example.cuentas_juego.room_database.repository.GroupRepository
import com.example.cuentas_juego.room_database.viewModel.GroupViewModel
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var myGroupsIds: ArrayList<Int> = ArrayList()
    private var myJug1: ArrayList<String> = ArrayList()
    private var myJug2: ArrayList<String> = ArrayList()
    private var myJug3: ArrayList<String> = ArrayList()
    private var myJug4: ArrayList<String> = ArrayList()
    private var myJug5: ArrayList<String> = ArrayList()
    private var myJug6: ArrayList<String> = ArrayList()

    private lateinit var listRecyclerView:RecyclerView
    private lateinit var myAdapter:RecyclerView.Adapter<ListaAdapter.MyViewHolder>

    private lateinit var groupViewModel: GroupViewModel
    private lateinit var groupRepository: GroupRepository

    lateinit var button_crear_grupo: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var info: Bundle= Bundle()

        info.putIntegerArrayList("ids", myGroupsIds)
        info.putStringArrayList("jug1s", myJug1)
        info.putStringArrayList("jug2s", myJug2)
        info.putStringArrayList("jug3s", myJug3)
        info.putStringArrayList("jug4s", myJug4)
        info.putStringArrayList("jug5s", myJug5)
        info.putStringArrayList("jug6s", myJug6)

        listRecyclerView = findViewById(R.id.recycler_grupos)
        listRecyclerView.layoutManager=LinearLayoutManager(this)
        myAdapter = ListaAdapter(this as AppCompatActivity, info)

        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter=myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        cargar_grupos()

        button_crear_grupo = findViewById(R.id.button_crear_grupo)

        button_crear_grupo.setOnClickListener {
            getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.layout_main, CrearFragment::class.java, info, "crear_grupo")
                ?.addToBackStack("")
                ?.commit()
        }

    }


    fun cargar_grupos() {
        val db=GruposDatabase.getDatabase(this)
        val gruposDAO=db.gruposDao()

        groupRepository= GroupRepository(gruposDAO)
        groupViewModel= GroupViewModel(groupRepository)


        var result = groupViewModel.getAllGroups()

        result.invokeOnCompletion {
            var theGroups = groupViewModel.getTheGroups()

            var i=0
            myGroupsIds.clear()
            myJug1.clear()
            myJug2.clear()
            myJug3.clear()
            myJug4.clear()
            myJug5.clear()
            myJug6.clear()
            while(i<theGroups!!.size) {
                myGroupsIds.add(theGroups[i].id)
                myJug1.add(theGroups[i].jugador1!!.toString())
                myJug2.add(theGroups[i].jugador2!!.toString())
                myJug3.add(theGroups[i].jugador3!!.toString())
                myJug4.add(theGroups[i].jugador4!!.toString())
                myJug5.add(theGroups[i].jugador5!!.toString())
                myJug6.add(theGroups[i].jugador6!!.toString())

                i++
            }
            myAdapter.notifyDataSetChanged()

        }
    }
}

