package com.example.cuentas_juego

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cuentas_juego.room_database.Group
import com.example.cuentas_juego.room_database.GruposDatabase
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class CrearFragment : Fragment() {

    lateinit var text_jug1_crear: TextInputEditText
    lateinit var text_jug2_crear: TextInputEditText
    lateinit var text_jug3_crear: TextInputEditText
    lateinit var text_jug4_crear: TextInputEditText
    lateinit var text_jug5_crear: TextInputEditText
    lateinit var text_jug6_crear: TextInputEditText
    lateinit var button_jugar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val crearView =  inflater.inflate(R.layout.fragment_crear, container, false)

        button_jugar=crearView.findViewById(R.id.button_jugar_grupo)

        text_jug1_crear=crearView.findViewById(R.id.text_jug1_crear)
        text_jug2_crear=crearView.findViewById(R.id.text_jug2_crear)
        text_jug3_crear=crearView.findViewById(R.id.text_jug3_crear)
        text_jug4_crear=crearView.findViewById(R.id.text_jug4_crear)
        text_jug5_crear=crearView.findViewById(R.id.text_jug5_crear)
        text_jug6_crear=crearView.findViewById(R.id.text_jug6_crear)

        var idGroup= requireArguments().getInt("id")
        var jug1= requireArguments().getString("jug1")
        var jug2= requireArguments().getString("jug2")
        var jug3= requireArguments().getString("jug3")
        var jug4= requireArguments().getString("jug4")
        var jug5= requireArguments().getString("jug5")
        var jug6= requireArguments().getString("jug6")

        text_jug1_crear.setText(jug1)
        text_jug2_crear.setText(jug2)
        text_jug3_crear.setText(jug3)
        text_jug4_crear.setText(jug4)
        text_jug5_crear.setText(jug5)
        text_jug6_crear.setText(jug6)

        button_jugar.setOnClickListener{


            val db= GruposDatabase.getDatabase(requireActivity())
            var updateOrCreate: Number
            val groupDAO=db.gruposDao()

            if (requireArguments().getString("jug1").isNullOrEmpty()){
                updateOrCreate=0

            }else{
                updateOrCreate=1
            }

            runBlocking {
                launch {
                    var idGroupPasa:Int
                    var datos: Bundle = Bundle()
                    if (updateOrCreate == 0) {
                        val group = Group(
                            0,
                            text_jug1_crear.text.toString(),
                            text_jug2_crear.text.toString(),
                            text_jug3_crear.text.toString(),
                            text_jug4_crear.text.toString(),
                            text_jug5_crear.text.toString(),
                            text_jug6_crear.text.toString()
                        )
                        var result = groupDAO.insertGroup(group)
                        if (result != -1L) {
                            (Activity.RESULT_OK)
                            activity?.finish()
                            idGroupPasa=result.toInt()
                            datos.putInt("idGroupPasa",idGroupPasa)
                            var intento=Intent(context,GameActivity::class.java)
                            intento.putExtras(datos)
                            startActivity(intento)
                        }

                    } else {
                        var idGroup =requireArguments().getInt("id", 0)

                        val group = Group(
                            idGroup,
                            text_jug1_crear.text.toString(),
                            text_jug2_crear.text.toString(),
                            text_jug3_crear.text.toString(),
                            text_jug4_crear.text.toString(),
                            text_jug5_crear.text.toString(),
                            text_jug6_crear.text.toString()
                        )
                        var result = groupDAO.updateGroup(group)
                        idGroupPasa=idGroup

                        var intento=Intent(requireActivity(),GameActivity::class.java)
                        //datos.putInt("idGroupPasa",idGroupPasa)
                        intento.putExtra("idGroupPasa", idGroupPasa)
                        intento.putExtra("jugador1", text_jug1_crear.text.toString())
                        intento.putExtra("jugador2", text_jug2_crear.text.toString())
                        intento.putExtra("jugador3", text_jug3_crear.text.toString())
                        intento.putExtra("jugador4", text_jug4_crear.text.toString())
                        intento.putExtra("jugador5", text_jug5_crear.text.toString())
                        intento.putExtra("jugador6", text_jug6_crear.text.toString())
                        startActivity(intento)
                    }

                }

            }


            //val intento =Intent(context,GameActivity::class.java)
            //startActivity(intento)
        }
        return crearView
    }
}