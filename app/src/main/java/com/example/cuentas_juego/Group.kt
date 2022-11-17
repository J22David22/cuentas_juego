package com.example.cuentas_juego

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Group(
    @PrimaryKey (autoGenerate = true) val id:Int,
    var jugadores: List<String>
)
