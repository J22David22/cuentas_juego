package com.example.cuentas_juego.room_database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Group (
    @PrimaryKey (autoGenerate = true) val id:Int,
    var jugador1: String?,
    var jugador2: String?,
    var jugador3: String?,
    var jugador4: String?,
    var jugador5: String?,
    var jugador6: String?
): java.io.Serializable{

}
