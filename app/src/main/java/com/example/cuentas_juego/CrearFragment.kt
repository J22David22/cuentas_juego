package com.example.cuentas_juego

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class CrearFragment : Fragment() {

    lateinit var label_jug1_main: TextView
    lateinit var label_jug2_main: TextView
    lateinit var label_jug3_main: TextView
    lateinit var label_jug4_main: TextView
    lateinit var label_jug5_main: TextView
    lateinit var label_jug6_main: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val crearView =  inflater.inflate(R.layout.fragment_crear, container, false)

        button=crearView.findViewById(R.id.button_jugar_grupo)

        button.setOnClickListener{
            val intento =Intent(context,GameActivity::class.java)
            startActivity(intento)
        }
        return crearView
    }
}