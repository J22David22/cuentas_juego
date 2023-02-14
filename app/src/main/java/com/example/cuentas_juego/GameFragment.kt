package com.example.cue

import com.example.cuentas_juego.R


import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class GameFragment : Fragment() {

    lateinit var service:String
    var idtraido:Int = 0
    lateinit var params:LinearLayout.LayoutParams
    lateinit var boton_agregar:MaterialButton
    lateinit var boton_editar:MaterialButton
    lateinit var boton_borrar:MaterialButton

    var puntos_jugador_1= mutableListOf<Double>()
    var puntos_jugador_2= mutableListOf<Double>()
    var puntos_jugador_3= mutableListOf<Double>()
    var puntos_jugador_4= mutableListOf<Double>()
    var puntos_jugador_5= mutableListOf<Double>()
    var puntos_jugador_6= mutableListOf<Double>()


    var table_juego:TableLayout?=null
    var table_provisionales:TableLayout?=null
    var table_turno:TableLayout?=null
    var table_calculo_juego:TableLayout?=null




    var positivos:Int=0
    var negativos:Int=0
    var total:Int=0
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

        table_turno=view?.findViewById(R.id.table_turno)
        table_turno?.removeAllViews()

        table_provisionales=view?.findViewById(R.id.table_puntajes_provisionales)
        table_provisionales?.removeAllViews()

        table_calculo_juego=view?.findViewById(R.id.table_calculo_juego)
        table_calculo_juego?.removeAllViews()




        val tableRow0=TableRow(context)
        val textView0=TextView(context)
        val textView1=TextView(context)
        val textView2=TextView(context)
        val textView3=TextView(context)
        val textView4=TextView(context)
        val textView5=TextView(context)

        textView0.textSize= 25F
        textView0.setTextColor(Color.BLUE)
        textView1.textSize= 25F
        textView1.setTextColor(Color.GREEN)
        textView2.textSize= 25F
        textView2.setTextColor(Color.RED)
        textView3.textSize= 25F
        textView3.setTextColor(Color.MAGENTA)
        textView4.textSize= 25F
        textView4.setTextColor(Color.DKGRAY)
        textView5.textSize= 25F
        textView5.setTextColor(Color.CYAN)

        val tablejuegoRow1=TableRow(context)


        //val tableRowR1=TableRow(context)

        //val textViewR0=TextView(context)
        /*val textViewR1=TextView(context)
        val textViewR2=TextView(context)
        val textViewR3=TextView(context)
        val textViewR4=TextView(context)
        val textViewR5=TextView(context)*/


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





        val textViewJuego1=TextView(context)
        val tableRow1Juego1=TableRow(context)
        textViewJuego1.textSize=25F
        textViewJuego1.text=""
        tableRow1Juego1.addView(textViewJuego1)
        table_turno?.addView(tableRow1Juego1)

        val textViewPositivo=TextView(context)
        val tableRowPositivos=TableRow(context)
        textViewPositivo.textSize=25F
        textViewPositivo.text=" P + "
        tableRowPositivos.addView(textViewPositivo)
        table_calculo_juego?.addView(tableRowPositivos)

        val textViewNegativo=TextView(context)
        val tableRowNegativos=TableRow(context)
        textViewNegativo.textSize=25F
        textViewNegativo.text=" N - "
        tableRowNegativos.addView(textViewNegativo)
        table_calculo_juego?.addView(tableRowNegativos)

        val textViewAcumulado=TextView(context)
        val tableRowAcumulado=TableRow(context)
        textViewAcumulado.textSize=25F
        textViewAcumulado.setTextColor(Color.CYAN)
        textViewAcumulado.text="-->"
        tableRowAcumulado.addView(textViewAcumulado)
        table_calculo_juego?.addView(tableRowAcumulado)


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


    }

    private fun agregar_datos() {
        val alertDialog=AlertDialog.Builder(requireActivity())
        val view=layoutInflater.inflate(R.layout.ingresar_puntos,null)


        var tablePuntos:TableLayout?=null

        tablePuntos=view?.findViewById(R.id.tablePuntos)
        tablePuntos?.removeAllViews()




        val editView0=EditText(context)
        editView0.setRawInputType(InputType.TYPE_CLASS_PHONE)
        val tableRow10=TableRow(context)
        //val textView1=TextView(context)
        val editView1=EditText(context)
        val editView2=EditText(context)
        val editView3=EditText(context)
        val editView4=EditText(context)
        val editView5=EditText(context)

        editView0.isSingleLine = true
        editView1.isSingleLine = true
        editView2.isSingleLine = true
        editView3.isSingleLine = true
        editView4.isSingleLine = true
        editView5.isSingleLine = true

        editView1?.inputType=InputType.TYPE_CLASS_PHONE
        editView2?.inputType=InputType.TYPE_CLASS_PHONE
        editView3.inputType=InputType.TYPE_CLASS_PHONE
        editView4.inputType=InputType.TYPE_CLASS_PHONE
        editView5.inputType=InputType.TYPE_CLASS_PHONE



        editView1?.textSize= 25F

        var jugador1= arguments?.getString("jugador1")
        var jugador2= arguments?.getString("jugador2")
        var jugador3= arguments?.getString("jugador3")
        var jugador4= arguments?.getString("jugador4")
        var jugador5= arguments?.getString("jugador5")
        var jugador6= arguments?.getString("jugador6")




        if(!jugador1.isNullOrBlank()){
            val tableRow0=TableRow(context)

            val textView0=TextView(context)
            editView0.textSize= 25F
            editView0.hint="          "
            textView0.textSize= 25F

            tableRow0.addView(textView0)
            tableRow0.addView(editView0)
            tablePuntos?.addView(tableRow0)
            if (jugador1.length>=3){
                textView0.text="    "+ jugador1.toString().uppercase().substring(0,3)+"    "
            }
            else{
                textView0.text="     "+ jugador1.toString().uppercase()+"    "
            }
        }
        if(!jugador2.isNullOrBlank()){
            val tableRow1=TableRow(context)

            val textView1=TextView(context)
            editView1.textSize= 25F
            editView1.hint="          "
            textView1.textSize= 25F

            tableRow1.addView(textView1)
            tableRow1.addView(editView1)
            tablePuntos?.addView(tableRow1)
            if (jugador2.length>=3){
                textView1.text="    "+ jugador2.toString().uppercase().substring(0,3)+"    "
            }
            else{
                textView1.text="    "+ jugador2.toString().uppercase()+"    "
            }
        }
        if(!jugador3.isNullOrBlank()){
            val tableRow2=TableRow(context)

            val textView2=TextView(context)
            editView2.textSize= 25F
            textView2.textSize= 25F

            tableRow2.addView(textView2)
            tableRow2.addView(editView2)
            tablePuntos?.addView(tableRow2)
            if (jugador3.length>=3){
                textView2.text="    "+ jugador3.toString().uppercase().substring(0,3)+"    "
            }
            else{
                textView2.text="    "+ jugador3.toString().uppercase()+"    "
            }
        }
        if(!jugador4.isNullOrBlank()){
            val tableRow3=TableRow(context)

            val textView3=TextView(context)
            editView3.textSize= 25F
            textView3.textSize= 25F

            tableRow3.addView(textView3)
            tableRow3.addView(editView3)
            tablePuntos?.addView(tableRow3)
            if (jugador4.length>3){
                textView3.text="    "+ jugador4.toString().uppercase().substring(0,3)+"    "
            }
            else{
                textView3.text="    "+ jugador4.toString().uppercase()+"    "
            }
        }
        if(!jugador5.isNullOrBlank()){
            val tableRow4=TableRow(context)
            val textView4=TextView(context)
            editView4.textSize= 25F
            textView4.textSize= 25F

            tableRow4.addView(textView4)
            tableRow4.addView(editView4)
            tablePuntos?.addView(tableRow4)
            if (jugador5.length>3){
                textView4.text="    "+ jugador5.toString().uppercase().substring(0,3)+"    "
            }
            else{
                textView4.text="    "+ jugador5.toString().uppercase()+"    "
            }
        }
        if(!jugador6.isNullOrBlank()){
            val tableRow5=TableRow(context)

            val textView5=TextView(context)
            editView5.textSize= 25F
            textView5.textSize= 25F

            tableRow5.addView(textView5)
            tableRow5.addView(editView5)
            tablePuntos?.addView(tableRow5)
            if (jugador6.length>3){
                textView5.text="    "+ jugador6.toString().uppercase().substring(0,3)+"    "
            }
            else{
                textView5.text="    "+ jugador6.toString().uppercase()+"    "
            }
        }

        tablePuntos?.addView(tableRow10)

        alertDialog.setView(view)
        val dialog=alertDialog.create()
        dialog.show()





        val botonGuardarPuntos=view.findViewById<Button>(R.id.boton_aceptar)
        botonGuardarPuntos.setOnClickListener{


            if(numJuego==0){
                val tableRowR1=TableRow(context)
                val tableRowR2=TableRow(context)
                val tableRowR3=TableRow(context)

                val textViewR0=TextView(context)
                val textViewR1=TextView(context)
                val textViewR2=TextView(context)
                val textViewR3=TextView(context)
                val textViewR4=TextView(context)
                val textViewR5=TextView(context)

                val textViewq0=TextView(context)
                val textViewq1=TextView(context)
                val textViewq2=TextView(context)
                val textViewq3=TextView(context)
                val textViewq4=TextView(context)
                val textViewq5=TextView(context)

                val textViewz0=TextView(context)
                val textViewz1=TextView(context)
                val textViewz2=TextView(context)
                val textViewz3=TextView(context)
                val textViewz4=TextView(context)
                val textViewz5=TextView(context)

                textViewR0.textSize = 25F
                textViewR0.setTextColor(Color.BLUE)
                textViewR1.textSize = 25F
                textViewR1.setTextColor(Color.GREEN)
                textViewR2.textSize= 25F
                textViewR2?.setTextColor(Color.RED)
                textViewR3?.textSize= 25F
                textViewR3?.setTextColor(Color.MAGENTA)
                textViewR4?.textSize= 25F
                textViewR4?.setTextColor(Color.DKGRAY)
                textViewR5?.textSize= 25F
                textViewR5?.setTextColor(Color.CYAN)

                textViewq0.textSize = 25F
                textViewq0.setTextColor(Color.BLUE)
                textViewq1.textSize = 25F
                textViewq1.setTextColor(Color.GREEN)
                textViewq2.textSize= 25F
                textViewq2?.setTextColor(Color.RED)
                textViewq3?.textSize= 25F
                textViewq3?.setTextColor(Color.MAGENTA)
                textViewq4?.textSize= 25F
                textViewq4?.setTextColor(Color.DKGRAY)
                textViewq5?.textSize= 25F
                textViewq5?.setTextColor(Color.CYAN)

                textViewz0.textSize = 25F
                textViewz0.setTextColor(Color.BLUE)
                textViewz1.textSize = 25F
                textViewz1.setTextColor(Color.GREEN)
                textViewz2.textSize= 25F
                textViewz2?.setTextColor(Color.RED)
                textViewz3?.textSize= 25F
                textViewz3?.setTextColor(Color.MAGENTA)
                textViewz4?.textSize= 25F
                textViewz4?.setTextColor(Color.DKGRAY)
                textViewz5?.textSize= 25F
                textViewz5?.setTextColor(Color.CYAN)

                tableRowR1?.addView(textViewR0)
                tableRowR1?.addView(textViewR1)
                tableRowR1?.addView(textViewR2)
                tableRowR1?.addView(textViewR3)
                tableRowR1?.addView(textViewR4)
                tableRowR1?.addView(textViewR5)

                tableRowR2?.addView(textViewq0)
                tableRowR2?.addView(textViewq1)
                tableRowR2?.addView(textViewq2)
                tableRowR2?.addView(textViewq3)
                tableRowR2?.addView(textViewq4)
                tableRowR2?.addView(textViewq5)

                tableRowR3?.addView(textViewz0)
                tableRowR3?.addView(textViewz1)
                tableRowR3?.addView(textViewz2)
                tableRowR3?.addView(textViewz3)
                tableRowR3?.addView(textViewz4)
                tableRowR3?.addView(textViewz5)

                /*tableRowR1.setBackgroundColor(Color.parseColor("#98FB98"))
                tableRowR2.setBackgroundColor(Color.parseColor("#FF9999"))
                tableRowR3 .setBackgroundColor(Color.parseColor("#FF99FF"))*/

                table_provisionales?.addView(tableRowR1)
                table_provisionales?.addView(tableRowR2)
                table_provisionales?.addView(tableRowR3)
            }
            else {

            }



            val tablejuegoRow1=TableRow(context)
            Toast.makeText(context, "Prueba aceptar", Toast.LENGTH_SHORT).show()
            if(!jugador1.isNullOrBlank()){


                val punt_juga1=editView0.text.toString()
                val textjuga1juego1=TextView(context)
                textjuga1juego1.textSize=25F
                textjuga1juego1.setTextColor(Color.BLUE)
                textjuga1juego1.text="    "+punt_juga1
                puntos_jugador_1.add(punt_juga1.toDouble())

                val renglon0 = table_provisionales?.getChildAt(0) as TableRow
                val renglon1 = table_provisionales?.getChildAt(1) as TableRow
                val renglon2 = table_provisionales?.getChildAt(2) as TableRow
                val tvr00 = renglon0.getVirtualChildAt(0) as TextView
                val tvr10 = renglon1.getVirtualChildAt(0) as TextView
                val tvr20 = renglon2.getVirtualChildAt(0) as TextView
                var temp=""
                var por=0

                if(numJuego<7)
                {
                    if(punt_juga1.isBlank()||punt_juga1!!.toInt()==0){

                        if(numJuego==0){
                            tvr00.text=(20).toString()
                            tvr10.text=0.toString()
                        }else{
                            temp=tvr00.text.toString()
                            por= temp.toInt()
                            tvr00.text=(por+numJuego*20+20).toString()
                        }

                    }else{
                        if(numJuego==0){
                            tvr00.text= "0"
                            tvr10.text=punt_juga1
                            tvr20.text= (0-punt_juga1.toDouble()).toInt().toString()
                        }else{
                            val temp=tvr00.text.toString()
                            var por= temp.toInt()
                            if(punt_juga1.toInt()==0){
                                tvr00.text=(por+numJuego*20+20).toString()
                            }
                            tvr10.text = puntos_jugador_1.sum().toInt().toString()

                        }

                    }
                    tvr20.text= (tvr00.text.toString().toDouble()-puntos_jugador_1.sum()).toInt().toString()

                    tablejuegoRow1.addView(textjuga1juego1)
                    table_juego?.addView(tablejuegoRow1)
                    dialog.dismiss()

                }

            }


            if(!jugador2.isNullOrBlank()){

                val punt_juga2=editView1.text.toString()
                val textjuga2juego1=TextView(context)
                textjuga2juego1.textSize=25F
                textjuga2juego1.setTextColor(Color.GREEN)
                textjuga2juego1.text=" "+punt_juga2
                puntos_jugador_2.add(punt_juga2.toDouble())

                val renglon0 = table_provisionales?.getChildAt(0) as TableRow
                val renglon1 = table_provisionales?.getChildAt(1) as TableRow
                val renglon2 = table_provisionales?.getChildAt(2) as TableRow
                val tvr01 = renglon0.getVirtualChildAt(1) as TextView
                val tvr11 = renglon1.getVirtualChildAt(1) as TextView
                val tvr21 = renglon2.getVirtualChildAt(1) as TextView
                var temp=""
                var por=0

                if(numJuego<7)
                {
                    if(punt_juga2.isBlank()||punt_juga2!!.toInt()==0){

                        if(numJuego==0){
                            tvr01.text=(20).toString()
                            tvr11.text=0.toString()
                        }else{
                            temp=tvr01.text.toString()
                            por= temp.toInt()
                            tvr01.text=(por+numJuego*20+20).toString()
                        }

                    }else{
                        if(numJuego==0){
                            tvr01.text= "0"
                            tvr11.text=punt_juga2
                            tvr21.text= (0-punt_juga2.toDouble()).toInt().toString()
                        }else{
                            val temp=tvr01.text.toString()
                            var por= temp.toInt()
                            if(punt_juga2.toInt()==0){
                                tvr01.text=(por+numJuego*20+20).toString()
                            }
                            tvr11.text =puntos_jugador_2.sum().toInt().toString()

                        }

                    }
                    tvr21.text= (tvr01.text.toString().toDouble()-puntos_jugador_2.sum()).toInt().toString()



                    tablejuegoRow1.addView(textjuga2juego1)
                    dialog.dismiss()
                }
            }

            if(!jugador3.isNullOrBlank()){

                val punt_juga3=editView2.text.toString()
                val textjuga3juego1=TextView(context)
                textjuga3juego1.textSize=25F
                textjuga3juego1.setTextColor(Color.RED)
                textjuga3juego1.text=" "+punt_juga3
                puntos_jugador_3.add(punt_juga3.toDouble())

                val renglon0 = table_provisionales?.getChildAt(0) as TableRow
                val renglon1 = table_provisionales?.getChildAt(1) as TableRow
                val renglon2 = table_provisionales?.getChildAt(2) as TableRow
                val tvr02 = renglon0.getVirtualChildAt(2) as TextView
                val tvr12 = renglon1.getVirtualChildAt(2) as TextView
                val tvr22 = renglon2.getVirtualChildAt(2) as TextView
                var temp=""
                var por=0

                if(numJuego<7)
                {
                    if(punt_juga3.isBlank()||punt_juga3!!.toInt()==0){

                        if(numJuego==0){
                            tvr02.text=(20).toString()
                            tvr12.text=0.toString()
                        }else{
                            temp=tvr02.text.toString()
                            por= temp.toInt()
                            tvr02.text=(por+numJuego*20+20).toString()
                        }

                    }else{
                        if(numJuego==0){
                            tvr02.text= "0"
                            tvr12.text=punt_juga3
                            tvr22.text= (0-punt_juga3.toDouble()).toInt().toString()
                        }else{
                            val temp=tvr02.text.toString()
                            var por= temp.toInt()
                            if(punt_juga3.toInt()==0){
                                tvr02.text=(por+numJuego*20+20).toString()
                            }
                            tvr12.text =puntos_jugador_3.sum().toInt().toString()

                        }

                    }
                    tvr22.text= (tvr02.text.toString().toDouble()-puntos_jugador_3.sum()).toInt().toString()



                    tablejuegoRow1.addView(textjuga3juego1)
                    dialog.dismiss()
                }

            }

            if(!jugador4.isNullOrBlank()){

                val punt_juga4=editView3.text.toString()
                val textjuga4juego1=TextView(context)
                textjuga4juego1.textSize=25F
                textjuga4juego1.setTextColor(Color.MAGENTA)
                textjuga4juego1.text=" "+punt_juga4
                puntos_jugador_4.add(punt_juga4.toDouble())

                val renglon0 = table_provisionales?.getChildAt(0) as TableRow
                val renglon1 = table_provisionales?.getChildAt(1) as TableRow
                val renglon2 = table_provisionales?.getChildAt(2) as TableRow
                val tvr03 = renglon0.getVirtualChildAt(3) as TextView
                val tvr13 = renglon1.getVirtualChildAt(3) as TextView
                val tvr23 = renglon2.getVirtualChildAt(3) as TextView
                var temp=""
                var por=0

                if(numJuego<7)
                {
                    if(punt_juga4.isBlank()||punt_juga4!!.toInt()==0){

                        if(numJuego==0){
                            tvr03.text=(20).toString()
                            tvr13.text=0.toString()
                        }else{
                            temp=tvr03.text.toString()
                            por= temp.toInt()
                            tvr03.text=(por+numJuego*20+20).toString()
                        }

                    }else{
                        if(numJuego==0){
                            tvr03.text= "0"
                            tvr13.text=punt_juga4
                            tvr23.text= (0-punt_juga4.toDouble()).toInt().toString()
                        }else{
                            val temp=tvr03.text.toString()
                            var por= temp.toInt()
                            if(punt_juga4.toInt()==0){
                                tvr03.text=(por+numJuego*20+20).toString()
                            }
                            tvr13.text =puntos_jugador_4.sum().toInt().toString()

                        }

                    }
                    tvr23.text= (tvr03.text.toString().toDouble()-puntos_jugador_4.sum()).toInt().toString()



                    tablejuegoRow1.addView(textjuga4juego1)
                    dialog.dismiss()
                }

            }

            if(!jugador5.isNullOrBlank()){

                val punt_juga5=editView4.text.toString()
                val textjuga5juego1=TextView(context)
                textjuga5juego1.textSize=25F
                textjuga5juego1.setTextColor(Color.DKGRAY)
                textjuga5juego1.text=" "+punt_juga5
                puntos_jugador_5.add(punt_juga5.toDouble())

                val renglon0 = table_provisionales?.getChildAt(0) as TableRow
                val renglon1 = table_provisionales?.getChildAt(1) as TableRow
                val renglon2 = table_provisionales?.getChildAt(2) as TableRow
                val tvr04 = renglon0.getVirtualChildAt(4) as TextView
                val tvr14 = renglon1.getVirtualChildAt(4) as TextView
                val tvr24 = renglon2.getVirtualChildAt(4) as TextView
                var temp=""
                var por=0

                if(numJuego<7)
                {
                    if(punt_juga5.isBlank()||punt_juga5!!.toInt()==0){

                        if(numJuego==0){
                            tvr04.text=(20).toString()
                            tvr14.text=0.toString()
                        }else{
                            temp=tvr04.text.toString()
                            por= temp.toInt()
                            tvr04.text=(por+numJuego*20+20).toString()
                        }

                    }else{
                        if(numJuego==0){
                            tvr04.text= "0"
                            tvr14.text=punt_juga5
                            tvr24.text= (0-punt_juga5.toDouble()).toInt().toString()
                        }else{
                            val temp=tvr04.text.toString()
                            var por= temp.toInt()
                            if(punt_juga5.toInt()==0){
                                tvr04.text=(por+numJuego*20+20).toString()
                            }
                            tvr14.text =puntos_jugador_5.sum().toInt().toString()

                        }

                    }
                    tvr24.text= (tvr04.text.toString().toDouble()-puntos_jugador_5.sum()).toInt().toString()



                    tablejuegoRow1.addView(textjuga5juego1)
                    dialog.dismiss()
                }

            }

            if(!jugador6.isNullOrBlank()){

                val punt_juga6=editView5.text.toString()
                val textjuga6juego1=TextView(context)
                textjuga6juego1.textSize=25F
                textjuga6juego1.setTextColor(Color.CYAN)
                textjuga6juego1.text=" "+punt_juga6
                puntos_jugador_6.add(punt_juga6.toDouble())

                val renglon0 = table_provisionales?.getChildAt(0) as TableRow
                val renglon1 = table_provisionales?.getChildAt(1) as TableRow
                val renglon2 = table_provisionales?.getChildAt(2) as TableRow
                val tvr05 = renglon0.getVirtualChildAt(5) as TextView
                val tvr15 = renglon1.getVirtualChildAt(5) as TextView
                val tvr25 = renglon2.getVirtualChildAt(5) as TextView
                var temp=""
                var por=0

                if(numJuego<7)
                {
                    if(punt_juga6.isBlank()||punt_juga6!!.toInt()==0){

                        if(numJuego==0){
                            tvr05.text=(20).toString()
                            tvr15.text=0.toString()
                        }else{
                            temp=tvr05.text.toString()
                            por= temp.toInt()
                            tvr05.text=(por+numJuego*20+20).toString()
                        }

                    }else{
                        if(numJuego==0){
                            tvr05.text= "0"
                            tvr15.text=punt_juga6
                            tvr25.text= (0-punt_juga6.toDouble()).toInt().toString()
                        }else{
                            val temp=tvr05.text.toString()
                            var por= temp.toInt()
                            if(punt_juga6.toInt()==0){
                                tvr05.text=(por+numJuego*20+20).toString()
                            }
                            tvr15.text =puntos_jugador_6.sum().toInt().toString()

                        }

                    }
                    tvr25.text= (tvr05.text.toString().toDouble()-puntos_jugador_6.sum()).toInt().toString()



                    tablejuegoRow1.addView(textjuga6juego1)
                    dialog.dismiss()
                }

            }



            numJuego=numJuego+1
            val textViewJuego1=TextView(context)
            val tableRow1Juego1=TableRow(context)
            textViewJuego1.textSize=25F
            textViewJuego1.text="J"+numJuego.toString()
            tableRow1Juego1.addView(textViewJuego1)
            table_turno?.addView(tableRow1Juego1)

        }

        val botonCancelarPuntos=view.findViewById<Button>(R.id.boton_cancelar)
        botonCancelarPuntos.setOnClickListener{
            Toast.makeText(context, "Prueba cancelar", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
    }


}