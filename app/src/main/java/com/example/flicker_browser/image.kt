package com.example.flicker_browser

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="image")
class image(@ColumnInfo(name="title") var title:String? = null,
            @ColumnInfo(name="link") var link:String? = null,
            @ColumnInfo(name="tag") var tag:String?=null,
            @PrimaryKey @ColumnInfo(name = "id") var id: String? = null
)
