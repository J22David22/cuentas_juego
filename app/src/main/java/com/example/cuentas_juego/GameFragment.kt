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

        var tablePuntos:TableLayout?=null

        tablePuntos=view?.findViewById(R.id.tablePuntos)
        tablePuntos?.removeAllViews()





        val tableRow1=TableRow(context)
        val textView1=TextView(context)
        val editView1=EditText(context)



        textView1.textSize= 30F
        editView1.textSize= 30F

        var jugador1= arguments?.getString("jugador1")
        var jugador2= arguments?.getString("jugador2")
        var jugador3= arguments?.getString("jugador3")
        var jugador4= arguments?.getString("jugador4")
        var jugador5= arguments?.getString("jugador5")
        var jugador6= arguments?.getString("jugador6")




        if(!jugador1.isNullOrBlank()){
            if (jugador1.length>=3){
                val tableRow0=TableRow(context)
                val editView0=EditText(context)
                val textView0=TextView(context)
                editView0.textSize= 30F
                textView0.textSize= 30F
                textView0.text=" "+ jugador1.toString().uppercase().substring(0,3)+" "
                tableRow0.addView(textView0)
                tableRow0.addView(editView0)
                tablePuntos?.addView(tableRow0)
            }
            else{
            }
        }
        if(!jugador2.isNullOrBlank()){
            if (jugador2.length>=3){
                val tableRow1=TableRow(context)
                val editView1=EditText(context)
                val textView1=TextView(context)
                editView1.textSize= 30F
                textView1.textSize= 30F
                textView1.text=" "+ jugador2.toString().uppercase().substring(0,3)+" "
                tableRow1.addView(textView1)
                tableRow1.addView(editView1)
                tablePuntos?.addView(tableRow1)
            }
            else{
            }
        }
        if(!jugador3.isNullOrBlank()){
            if (jugador3.length>=3){
                val tableRow2=TableRow(context)
                val editView2=EditText(context)
                val textView2=TextView(context)
                editView2.textSize= 30F
                textView2.textSize= 30F
                textView2.text=" "+ jugador3.toString().uppercase().substring(0,3)+" "
                tableRow2.addView(textView2)
                tableRow2.addView(editView2)
                tablePuntos?.addView(tableRow2)
            }
            else{
            }
        }
        if(!jugador4.isNullOrBlank()){
            if (jugador4.length>3){
                val tableRow3=TableRow(context)
                val editView3=EditText(context)
                val textView3=TextView(context)
                editView3.textSize= 30F
                textView3.textSize= 30F
                textView3.text=" "+ jugador4.toString().uppercase().substring(0,3)+" "
                tableRow3.addView(textView3)
                tableRow3.addView(editView3)
                tablePuntos?.addView(tableRow3)
            }
            else{
            }
        }
        if(!jugador5.isNullOrBlank()){
            if (jugador5.length>3){
                val tableRow4=TableRow(context)
                val editView4=EditText(context)
                val textView4=TextView(context)
                editView4.textSize= 30F
                textView4.textSize= 30F
                textView4.text=" "+ jugador5.toString().uppercase().substring(0,3)+" "
                tableRow4.addView(textView4)
                tableRow4.addView(editView4)
                tablePuntos?.addView(tableRow4)
            }
            else{
            }
        }
        if(!jugador6.isNullOrBlank()){
            if (jugador6.length>3){
                val tableRow5=TableRow(context)
                val editView5=EditText(context)
                val textView5=TextView(context)
                editView5.textSize= 30F
                textView5.textSize= 30F
                textView5.text=" "+ jugador6.toString().uppercase().substring(0,3)+" "
                tableRow5.addView(textView5)
                tableRow5.addView(editView5)
                tablePuntos?.addView(tableRow5)
            }
            else{
            }
        }



        tablePuntos?.addView(tableRow1)

        alertDialog.setView(view)
        val dialog=alertDialog.create()
        dialog.show()


        val botonGuardarPuntos=view.findViewById<Button>(R.id.boton_aceptar)
        botonGuardarPuntos.setOnClickListener{
            Toast.makeText(context, "Prueba aceptar", Toast.LENGTH_SHORT).show()
        }

        val botonCancelarPuntos=view.findViewById<Button>(R.id.boton_cancelar)
        botonCancelarPuntos.setOnClickListener{
            Toast.makeText(context, "Prueba cancelar", Toast.LENGTH_SHORT).show()
        }
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