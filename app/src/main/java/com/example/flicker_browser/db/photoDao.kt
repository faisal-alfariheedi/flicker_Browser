package com.example.flicker_browser.db

import androidx.room.*
import com.example.flicker_browser.network.feed


@Dao
interface photoDao {
    @Query("SELECT * from photo")
    fun getall():List<feed.PHOTOS.photos>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun addeditPhoto(celeb: feed.PHOTOS.photos)

    @Delete
    fun deletePhoto(celeb: feed.PHOTOS.photos)
}