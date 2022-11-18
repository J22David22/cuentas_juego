package com.example.cuentas_juego.room_database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface GruposDAO {
    @Query("SELECT*FROM 'Group'")
    suspend fun getAllGroups(): List<Group>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGroup(group: Group):Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  insertGroups(group: List<Group>):List<Long>

    @Update
    suspend fun updateGroup(group: Group)

    @Delete
    suspend fun deleteGroup(group: Group)
}