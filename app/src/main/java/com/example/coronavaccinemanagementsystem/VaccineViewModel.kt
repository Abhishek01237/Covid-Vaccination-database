package com.example.coronavaccinemanagementsystem

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VaccineViewModel(private val repository: VaccineRepository): ViewModel() {



    fun insert(items: VaccineItems)= GlobalScope.launch(Dispatchers.IO) {
        repository.insert(items)
    }

    fun delete(items: VaccineItems)= GlobalScope.launch(Dispatchers.IO) {
        repository.delete(items)
    }

    fun update(items: VaccineItems)= GlobalScope.launch(Dispatchers.IO) {
        repository.update(items)
    }

    fun getAllVaccineItems()=repository.getAllItems()




}