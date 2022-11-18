package com.example.cuentas_juego.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Group::class),version = 1)
abstract class GruposDatabase: RoomDatabase() {
    abstract fun gruposDao(): GruposDAO

    companion object{
        @Volatile
        private var INSTANCE: GruposDatabase? = null

        fun getDatabase(context: Context): GruposDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                GruposDatabase::class.java,
                "GruposDatabase").build()
                INSTANCE =instance
                instance
            }
        }
    }
}