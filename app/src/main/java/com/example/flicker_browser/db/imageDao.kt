package com.example.flicker_browser.db

import androidx.room.*
import com.example.flicker_browser.image


@Dao
interface imageDao {

    @Query("SELECT * from image")
    fun getall():List<image>
    
    @Query("SELECT * from image WHERE id=:id")
    fun getImage(id:Int):image

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun addeditIMage(img: image)

    @Delete
    fun deleteImage(img: image)

}