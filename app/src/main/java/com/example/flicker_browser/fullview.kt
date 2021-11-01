package com.example.flicker_browser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.flicker_browser.db.imageDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class fullview : AppCompatActivity() {
//    lateinit var im: ImageView
//    lateinit var tv: TextView
//    lateinit var bk: Button
//    lateinit var fb:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullview)
//        var db=imageDB.getInstance(this).imageDao()
//        var favlist: List<String>
//        var favo=false
//        var pos=intent.getIntExtra("pos",0)
//        im = findViewById(R.id.imageView)
//        tv=findViewById(R.id.tvtitle)
//        bk=findViewById(R.id.back)
//        fb=findViewById(R.id.imageButton)
//        CoroutineScope(Dispatchers.IO).launch {
//            favlist=db.getfavidlist()
//            if (favlist.contains(image.imgarr[pos].id)) {
//                runOnUiThread{fb.setImageResource(R.drawable.heartred)}
//                favo = true
//            }
//        }
//        fb.setOnClickListener{
//            if(favo){
//                CoroutineScope(Dispatchers.IO).launch {
//                db.deleteImage(image.imgarr[pos])}
//                fb.setImageResource(R.drawable.heardblk)
//                favo=false
//            }else{
//                CoroutineScope(Dispatchers.IO).launch {
//                db.addeditIMage(image.imgarr[pos])}
//                fb.setImageResource(R.drawable.heartred)
//                favo=true
//            }
//
//        }
//        Glide.with(im.getContext())
//            .load(image.imgarr[pos].link)
//            .into(im)
//        tv.text=image.imgarr[pos].title
//        bk.setOnClickListener{
//             onBackPressed()
//        //            when(intent.getStringExtra("bk")){
////                "main"->{
////                    val intent = Intent(this,MainActivity::class.java)
////                    startActivity(intent)
////                }
////                "fav"->{
////                    val intent = Intent(this,Fav::class.java)
////                    startActivity(intent)
////                }
////            }
//
//        }

    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.getItemId()) {
//            android.R.id.closeButton -> {
//
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
}