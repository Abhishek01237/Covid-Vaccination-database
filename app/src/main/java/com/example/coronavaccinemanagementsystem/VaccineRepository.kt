package com.example.coronavaccinemanagementsystem

class VaccineRepository(private val db:VaccineDatabase) {

    suspend fun insert(items: VaccineItems)=db.getVaccineDAO().insert(items)
    suspend fun delete(items: VaccineItems)=db.getVaccineDAO().delete(items)
    suspend fun update(items: VaccineItems)=db.getVaccineDAO().update(items)

    fun getAllItems()=db.getVaccineDAO().getAllVaccineItems()

}