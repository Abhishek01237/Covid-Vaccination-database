package com.example.coronavaccinemanagementsystem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vaccine_items")
data class VaccineItems (
    @ColumnInfo(name = "personName")
    var personName:String,

    @ColumnInfo(name = "vaccineName")
    var vaccineName:String,

    @ColumnInfo(name = "dose")
    var dose:Int,

    @ColumnInfo(name = "aadharNum")
    var aadharNum:String

){

    @PrimaryKey(autoGenerate = true)
    var id:Int?= null
}