package com.example.coronavaccinemanagementsystem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class VaccineViewModelFactory(private val repository: VaccineRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VaccineViewModel(repository) as T
    }



}