package com.example.flicker_browser.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flicker_browser.image


@Database(entities = [image::class],version = 1,exportSchema = false)
abstract class imageDB: RoomDatabase() {

    companion object {
        @Volatile
        var instance: imageDB?=null
        fun getInstance(cont: Context): imageDB {
            return instance ?:synchronized(this){
                instance ?: buildDatabase(cont).also{ instance =it}
            }
        }
        fun buildDatabase(cont: Context): imageDB {
            return Room.databaseBuilder(cont, imageDB::class.java,"favimg").build()
        }
    }
    abstract fun imageDao(): imageDao
}