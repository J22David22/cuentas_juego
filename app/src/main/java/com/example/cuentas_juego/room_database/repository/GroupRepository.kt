package com.example.cuentas_juego.room_database.repository

import com.example.cuentas_juego.room_database.Group
import com.example.cuentas_juego.room_database.GruposDAO

class GroupRepository (val groupDao: GruposDAO){

    suspend fun getAllGroups(): List<Group>{
        return groupDao.getAllGroups()
    }

    suspend fun insertGroup(group: Group): Long{
        return groupDao.insertGroup(group)
    }

    suspend fun deleteGroup(group: Group){
        return groupDao.deleteGroup(group)
    }

    suspend fun insertGroups(group: List<Group>): List<Long>{
        return groupDao.insertGroups(group)
    }
}