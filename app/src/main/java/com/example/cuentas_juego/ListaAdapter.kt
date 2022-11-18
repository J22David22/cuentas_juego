package com.example.cuentas_juego

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cuentas_juego.room_database.Group

class ListaAdapter (context: AppCompatActivity, val info: Bundle): RecyclerView.Adapter<ListaAdapter.MyViewHolder>(){

    class MyViewHolder(val layout: View):RecyclerView.ViewHolder(layout)
    private var context: AppCompatActivity =context

    var myGroupIds: ArrayList<Int> = info.getIntegerArrayList("ids") as ArrayList<Int>
    var myJug1: ArrayList<String> = info.getStringArrayList("jug1s") as ArrayList<String>
    var myJug2: ArrayList<String> = info.getStringArrayList("jug2s") as ArrayList<String>
    var myJug3: ArrayList<String> = info.getStringArrayList("jug3s") as ArrayList<String>
    var myJug4: ArrayList<String> = info.getStringArrayList("jug4s") as ArrayList<String>
    var myJug5: ArrayList<String> = info.getStringArrayList("jug5s") as ArrayList<String>
    var myJug6: ArrayList<String> = info.getStringArrayList("jug6s") as ArrayList<String>

    private lateinit var myAdapter:RecyclerView.Adapter<ListaAdapter.MyViewHolder>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var label_jug1_main=holder.layout.findViewById<TextView>(R.id.label_jug1_main)
        label_jug1_main.text=myJug1[position]

        var label_jug2_main=holder.layout.findViewById<TextView>(R.id.label_jug2_main)
        label_jug2_main.text=myJug2[position]

        var label_jug3_main=holder.layout.findViewById<TextView>(R.id.label_jug3_main)
        label_jug3_main.text=myJug3[position]

        var label_jug4_main=holder.layout.findViewById<TextView>(R.id.label_jug4_main)
        label_jug4_main.text=myJug4[position]

        var label_jug5_main=holder.layout.findViewById<TextView>(R.id.label_jug5_main)
        label_jug5_main.text=myJug5[position]

        var label_jug6_main=holder.layout.findViewById<TextView>(R.id.label_jug6_main)
        label_jug6_main.text=myJug6[position]


        holder.layout.setOnClickListener{
            Toast.makeText(holder.itemView.context,"label_jug2_main", Toast.LENGTH_LONG).show()
            val datos=Bundle()
            datos.putInt("id",myGroupIds[position])
            datos.putString("jug1",label_jug1_main!!.text as String)
            datos.putString("jug2",label_jug2_main!!.text as String)
            datos.putString("jug3",label_jug3_main!!.text as String)
            datos.putString("jug4",label_jug4_main!!.text as String)
            datos.putString("jug5",label_jug5_main!!.text as String)
            datos.putString("jug6",label_jug6_main!!.text as String)


            context.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.layout_main, CrearFragment::class.java, datos,"detail")
                ?.addToBackStack("")
                ?.commit()
        }
    }

    override fun getItemCount(): Int {
        return myGroupIds.size
    }
}