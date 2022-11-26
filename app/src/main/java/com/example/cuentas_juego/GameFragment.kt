package com.example.cuentas_juego

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginLeft
import com.example.cuentas_juego.room_database.Group
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class GameFragment : Fragment() {

    lateinit var service:String
    var idtraido:Int = 0
    lateinit var params:LinearLayout.LayoutParams
    lateinit var boton_agregar:MaterialButton
    lateinit var boton_editar:MaterialButton
    lateinit var boton_borrar:MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val fragment_game = inflater.inflate(R.layout.fragment_game, container, false)

        service= arguments?.getString("idGroupPasa").toString()

        if(service!="null"){
            func(service)
        }




        return fragment_game

    }

    private fun func(service: String) {
        Toast.makeText(context,"service"+service,Toast.LENGTH_SHORT).show()
        var a = 0
        for(i in 0..service.toInt()){

            a=a+i

        }

        var jugador1= arguments?.getString("jugador1")
        var jugador2= arguments?.getString("jugador2")
        var jugador3= arguments?.getString("jugador3")
        var jugador4= arguments?.getString("jugador4")
        var jugador5= arguments?.getString("jugador5")
        var jugador6= arguments?.getString("jugador6")
        Toast.makeText(context,"pla: "+jugador1+jugador2,Toast.LENGTH_SHORT).show()
        Toast.makeText(context,"pla: "+jugador3+jugador4,Toast.LENGTH_SHORT).show()
        Toast.makeText(context,"pla: "+jugador5+jugador6,Toast.LENGTH_SHORT).show()

        var table_juego:TableLayout?=null

        table_juego=view?.findViewById(R.id.table_cuentas)
        table_juego?.removeAllViews()


        val tableRow0=TableRow(context)
        val textView0=TextView(context)
        val textView1=TextView(context)
        val textView2=TextView(context)
        val textView3=TextView(context)
        val textView4=TextView(context)
        val textView5=TextView(context)

        textView0.textSize= 30F
        textView1.textSize= 30F
        textView2.textSize= 30F
        textView3.textSize= 30F
        textView4.textSize= 30F
        textView5.textSize= 30F


        if(!jugador1.isNullOrBlank()){
            if (jugador1.length>3){
                textView0.text=" "+ jugador1.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView0.text=" "+ jugador1.toString().uppercase()+" "
            }
        }
        if(!jugador2.isNullOrBlank()){
            if (jugador2.length>3){
                textView1.text=" "+ jugador2.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView1.text=" "+ jugador2.toString().uppercase()+" "
            }
        }
        if(!jugador3.isNullOrBlank()){
            if (jugador3.length>3){
                textView2.text=" "+ jugador3.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView2.text=" "+ jugador3.toString().uppercase()+" "
            }
        }
        if(!jugador4.isNullOrBlank()){
            if (jugador4.length>3){
                textView3.text=" "+ jugador4.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView3.text=" "+ jugador4.toString().uppercase()+" "
            }
        }
        if(!jugador5.isNullOrBlank()){
            if (jugador5.length>3){
                textView4.text=" "+ jugador5.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView4.text=" "+ jugador5.toString().uppercase()+" "
            }
        }
        if(!jugador6.isNullOrBlank()){
            if (jugador6.length>3){
                textView5.text=" "+ jugador6.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView5.text=" "+ jugador6.toString().uppercase()+" "
            }
        }

        tableRow0.addView(textView0)
        tableRow0.addView(textView1)
        tableRow0.addView(textView2)
        tableRow0.addView(textView3)
        tableRow0.addView(textView4)
        tableRow0.addView(textView5)

        table_juego?.addView(tableRow0)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        boton_agregar=view.findViewById(R.id.boton_agregar)
        boton_editar=view.findViewById(R.id.boton_editar)
        boton_borrar=view.findViewById(R.id.boton_eliminar)

        service= arguments?.getString("idGroupPasa").toString()

        if(service!="null"){
            func(service)

            boton_agregar.setOnClickListener{
                agregar_datos()
            }
        }

        //setup_table()

    }

    private fun agregar_datos() {
        val alertDialog=AlertDialog.Builder(requireActivity())
        val view=layoutInflater.inflate(R.layout.ingresar_puntos,null)
        alertDialog.setView(view)
        val dialog=alertDialog.create()
        dialog.show()
    }

    private fun setup_table() {

        var table_juego:TableLayout?=null

        table_juego=view?.findViewById(R.id.table_cuentas)
        table_juego?.removeAllViews()

        val tableRow0=TableRow(context)
        val textView0=TextView(context)
        val textView1=TextView(context)
        val textView2=TextView(context)

        textView0.text="JAI"
        textView1.text="OFE"
        textView2.text="DAV"

        tableRow0.addView(textView0)
        tableRow0.addView(textView1)
        tableRow0.addView(textView2)

        table_juego?.addView(tableRow0)
    }

}