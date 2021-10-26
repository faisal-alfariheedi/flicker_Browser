package com.example.flicker_browser.network

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class feed {

    @SerializedName("photos")
    var photos: PHOTOS? = null


    class PHOTOS {

        @SerializedName("photo")
        var photo: Array<photos>? = null

        @Entity(tableName="photo")
        class photos {

            @ColumnInfo(name="title")
            @SerializedName("title")
            var title: String? = null

            @PrimaryKey
            @ColumnInfo(name = "id")
            @SerializedName("id")
            var id: String? = null

            @ColumnInfo(name = "secret")
            @SerializedName("secret")
            var secret: String? = null

            @ColumnInfo(name = "server")
            @SerializedName("server")
            var server: String? = null

            @ColumnInfo(name = "farm")
            @SerializedName("farm")
            var farm: String? = null
        }
    }

}