package com.example.flicker_browser.db

import androidx.room.*
import com.example.flicker_browser.image


@Dao
interface imageDao {

    @Query("SELECT * from image")
    fun getall():List<image>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun addeditIMage(img: image)

    @Delete
    fun deleteImage(img: image)

}