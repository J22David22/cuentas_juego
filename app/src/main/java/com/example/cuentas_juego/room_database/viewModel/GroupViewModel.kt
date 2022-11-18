package com.example.cuentas_juego.room_database.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cuentas_juego.room_database.Group
import com.example.cuentas_juego.room_database.repository.GroupRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GroupViewModel (private val repository: GroupRepository): ViewModel(){

    var groups: List<Group>? = null

    fun getAllGroups(): Job {
        return viewModelScope.async {
            groups = repository.getAllGroups()
        }
    }

    fun getTheGroups(): List<Group>? {
        return groups
    }

    fun insertGroup(group: Group):Long{
        var idGroup: Long = 0
        viewModelScope.launch {
            idGroup=repository.insertGroup(group)
        }
        return idGroup
    }

    fun insertGroups(group: List<Group>?):List<Long>?{
        var idGroup: List<Long>? = null
        viewModelScope.launch {
            idGroup= repository.insertGroups(group!!)
        }
        return idGroup
    }
}