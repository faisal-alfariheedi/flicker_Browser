package com.example.flicker_browser

import com.google.gson.annotations.SerializedName

class feed {

    @SerializedName("photos")
    var photos: PHOTOS? = null


    class PHOTOS {

        @SerializedName("photo")
        var photo: Array<photos>? = null

        class photos {
            @SerializedName("title")
            var title: String? = null

            @SerializedName("id")
            var id: String? = null

            @SerializedName("secret")
            var secret: String? = null

            @SerializedName("server")
            var server: String? = null

            @SerializedName("farm")
            var farm: String? = null
        }
    }

}