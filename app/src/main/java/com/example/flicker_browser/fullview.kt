package com.example.flicker_browser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class fullview : AppCompatActivity() {
    lateinit var im: ImageView
    lateinit var tv: TextView
    lateinit var bk: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullview)
        im = findViewById(R.id.imageView)
        tv=findViewById(R.id.tvtitle)
        bk=findViewById(R.id.back)
        Glide.with(im.getContext())
            .load(image.imgarr[intent.getIntExtra("pos",0)].link)
            .into(im)
        tv.text=image.imgarr[intent.getIntExtra("pos",0)].title
        bk.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}