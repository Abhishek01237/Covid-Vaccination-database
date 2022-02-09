package com.example.coronavaccinemanagementsystem

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[VaccineItems::class],version = 1)
abstract class VaccineDatabase: RoomDatabase() {
    abstract fun getVaccineDAO():VaccineDAO
    companion object{

        @Volatile
        private var INSTANCE:VaccineDatabase?=null

        fun getDatabase(context: Context):VaccineDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VaccineDatabase::class.java,
                    "vaccine_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}