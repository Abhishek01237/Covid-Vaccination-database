package com.example.coronavaccinemanagementsystem

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VaccineDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: VaccineItems)

    @Delete
    suspend fun delete(item:VaccineItems)

    @Update
    suspend fun update(item: VaccineItems)

    @Query("Select *FROM vaccine_items ")

    fun getAllVaccineItems(): LiveData<List<VaccineItems>>
}