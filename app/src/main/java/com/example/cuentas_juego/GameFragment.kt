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
import androidx.fragment.app.findFragment
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


    var table_juego:TableLayout?=null
    var numJuego:Int=0

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




        val editView0=EditText(context)
        val tableRow1=TableRow(context)
        val textView1=TextView(context)
        val editView1=EditText(context)
        val editView2=EditText(context)
        val editView3=EditText(context)
        val editView4=EditText(context)
        val editView5=EditText(context)

        val tablejuegoRow1=TableRow(context)



        textView1.textSize= 30F
        editView1.textSize= 30F

        var jugador1= arguments?.getString("jugador1")
        var jugador2= arguments?.getString("jugador2")
        var jugador3= arguments?.getString("jugador3")
        var jugador4= arguments?.getString("jugador4")
        var jugador5= arguments?.getString("jugador5")
        var jugador6= arguments?.getString("jugador6")




        if(!jugador1.isNullOrBlank()){
            val tableRow0=TableRow(context)

            val textView0=TextView(context)
            editView0.textSize= 30F
            textView0.textSize= 30F

            tableRow0.addView(textView0)
            tableRow0.addView(editView0)
            tablePuntos?.addView(tableRow0)
            if (jugador1.length>=3){
                textView0.text=" "+ jugador1.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView0.text=" "+ jugador1.toString().uppercase()+" "
            }
        }
        if(!jugador2.isNullOrBlank()){
            val tableRow1=TableRow(context)

            val textView1=TextView(context)
            editView1.textSize= 30F
            textView1.textSize= 30F

            tableRow1.addView(textView1)
            tableRow1.addView(editView1)
            tablePuntos?.addView(tableRow1)
            if (jugador2.length>=3){
                textView1.text=" "+ jugador2.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView1.text=" "+ jugador2.toString().uppercase()+" "
            }
        }
        if(!jugador3.isNullOrBlank()){
            val tableRow2=TableRow(context)

            val textView2=TextView(context)
            editView2.textSize= 30F
            textView2.textSize= 30F

            tableRow2.addView(textView2)
            tableRow2.addView(editView2)
            tablePuntos?.addView(tableRow2)
            if (jugador3.length>=3){
                textView2.text=" "+ jugador3.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView2.text=" "+ jugador3.toString().uppercase()+" "
            }
        }
        if(!jugador4.isNullOrBlank()){
            val tableRow3=TableRow(context)

            val textView3=TextView(context)
            editView3.textSize= 30F
            textView3.textSize= 30F

            tableRow3.addView(textView3)
            tableRow3.addView(editView3)
            tablePuntos?.addView(tableRow3)
            if (jugador4.length>3){
                textView3.text=" "+ jugador4.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView3.text=" "+ jugador4.toString().uppercase()+" "
            }
        }
        if(!jugador5.isNullOrBlank()){
            val tableRow4=TableRow(context)
            val textView4=TextView(context)
            editView4.textSize= 30F
            textView4.textSize= 30F

            tableRow4.addView(textView4)
            tableRow4.addView(editView4)
            tablePuntos?.addView(tableRow4)
            if (jugador5.length>3){
                textView4.text=" "+ jugador5.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView4.text=" "+ jugador5.toString().uppercase()+" "
            }
        }
        if(!jugador6.isNullOrBlank()){
            val tableRow5=TableRow(context)

            val textView5=TextView(context)
            editView5.textSize= 30F
            textView5.textSize= 30F

            tableRow5.addView(textView5)
            tableRow5.addView(editView5)
            tablePuntos?.addView(tableRow5)
            if (jugador6.length>3){
                textView5.text=" "+ jugador6.toString().uppercase().substring(0,3)+" "
            }
            else{
                textView5.text=" "+ jugador6.toString().uppercase()+" "
            }
        }



        tablePuntos?.addView(tableRow1)

        alertDialog.setView(view)
        val dialog=alertDialog.create()
        dialog.show()


        val botonGuardarPuntos=view.findViewById<Button>(R.id.boton_aceptar)
        botonGuardarPuntos.setOnClickListener{

            Toast.makeText(context, "Prueba aceptar", Toast.LENGTH_SHORT).show()
            if(!jugador1.isNullOrBlank()){
                val punt_juga1=editView0.text.toString()
                val textjuga1juego1=TextView(context)
                textjuga1juego1.textSize=30F
                textjuga1juego1.text=punt_juga1

                tablejuegoRow1.addView(textjuga1juego1)
                table_juego?.addView(tablejuegoRow1)
                dialog.dismiss()
            }


            if(!jugador2.isNullOrBlank()){
                val punt_juga2=editView1.text.toString()
                val textjuga2juego1=TextView(context)
                textjuga2juego1.textSize=30F
                textjuga2juego1.text=punt_juga2

                tablejuegoRow1.addView(textjuga2juego1)

                dialog.dismiss()
            }

            if(!jugador3.isNullOrBlank()){
                val punt_juga3=editView2.text.toString()
                val textjuga3juego1=TextView(context)
                textjuga3juego1.textSize=30F
                textjuga3juego1.text=punt_juga3

                tablejuegoRow1.addView(textjuga3juego1)

                dialog.dismiss()
            }

            if(!jugador4.isNullOrBlank()){
                val punt_juga4=editView3.text.toString()
                val textjuga4juego1=TextView(context)
                textjuga4juego1.textSize=30F
                textjuga4juego1.text=punt_juga4

                tablejuegoRow1.addView(textjuga4juego1)

                dialog.dismiss()
            }

            if(!jugador5.isNullOrBlank()){
                val punt_juga5=editView4.text.toString()
                val textjuga5juego1=TextView(context)
                textjuga5juego1.textSize=30F
                textjuga5juego1.text=punt_juga5

                tablejuegoRow1.addView(textjuga5juego1)

                dialog.dismiss()
            }

            if(!jugador6.isNullOrBlank()){
                val punt_juga6=editView5.text.toString()
                val textjuga6juego1=TextView(context)
                textjuga6juego1.textSize=30F
                textjuga6juego1.text=punt_juga6

                tablejuegoRow1.addView(textjuga6juego1)

                dialog.dismiss()
            }


            numJuego=numJuego+1
        }

        val botonCancelarPuntos=view.findViewById<Button>(R.id.boton_cancelar)
        botonCancelarPuntos.setOnClickListener{
            Toast.makeText(context, "Prueba cancelar", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
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