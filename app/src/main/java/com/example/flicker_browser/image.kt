package com.example.flicker_browser

class image {
    var title:String? = null
    var link:String? = null
    companion object{
        var imgarr= arrayListOf<image>()
    }

    constructor(title: String?, link: String?) {
        this.title = title
        this.link = link
    }
}