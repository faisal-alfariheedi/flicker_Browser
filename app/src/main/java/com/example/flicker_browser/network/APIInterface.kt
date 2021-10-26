package com.example.flicker_browser.network



import com.example.flicker_browser.feed
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {


    @GET("rest/?nojsoncallback=1")
    fun getdat(@Query("method")method: String,@Query("api_key")apiKey: String ,@Query("tags")tags: String ,@Query("per_page")perPage: String,@Query("format")format: String ): Call<feed>


//    @POST("?method=flickr.photos.search&per_page={page}&api_key=33a9d39f0edb9d9c75cdf2a50fa983cd&tags={tag}format=json&nojsoncallback=1")
//    fun adddat(@Body data: feed): Call<feed>


//    @PUT("?method=flickr.photos.search&per_page={page}&api_key=33a9d39f0edb9d9c75cdf2a50fa983cd&tags={tag}format=json&nojsoncallback=1")
//    fun updatedat(@Path("id")id:Int, @Body data: feed): Call<feed>


//    @DELETE("?method=flickr.photos.search&per_page={page}&api_key=33a9d39f0edb9d9c75cdf2a50fa983cd&tags={tag}format=json&nojsoncallback=1/{id}")
//    fun deldat(@Path("id")id:Int): Call<feed>


}