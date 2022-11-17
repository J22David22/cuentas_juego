package com.example.cuentas_juego

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaAdapter (context: Context): RecyclerView.Adapter<ListaAdapter.ViewHolder>(){

    var dataList = emptyList<Group>()

    internal fun setDataList(dataList:List<Group>){
        this.dataList=dataList
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var jug1Label: TextView = itemView.findViewById(R.id.label_jug1_main)
        var jug2Label: TextView = itemView.findViewById(R.id.label_jug2_main)
        var jug3Label: TextView = itemView.findViewById(R.id.label_jug3_main)
        var jug4Label: TextView = itemView.findViewById(R.id.label_jug4_main)
        var jug5Label: TextView = itemView.findViewById(R.id.label_jug5_main)
        var jug6Label: TextView = itemView.findViewById(R.id.label_jug6_main)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data =dataList[position]

        holder.jug1Label.text=data.jugadores[0]
        holder.jug2Label.text=data.jugadores[1]
        holder.jug3Label.text=data.jugadores[2]
        holder.jug4Label.text=data.jugadores[3]
        holder.jug5Label.text=data.jugadores[4]
        holder.jug6Label.text=data.jugadores[5]
    }

    override fun getItemCount() = dataList.size

}