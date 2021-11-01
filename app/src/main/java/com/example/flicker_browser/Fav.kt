package com.example.flicker_browser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flicker_browser.db.imageDB
import com.example.flicker_browser.db.imageDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Fav : AppCompatActivity() {
//    lateinit var rv: RecyclerView
//    lateinit var db:imageDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav)
//        init()
    }
//    fun init() {
//        db=imageDB.getInstance(this).imageDao()
//        image.imgarr.clear()
//        rv=findViewById(R.id.rvm)
//        rv.layoutManager= GridLayoutManager(this,2)
//        CoroutineScope(Dispatchers.IO).launch {
//            image.imgarr = db.getall() as ArrayList<image>
////            runOnUiThread{rv.adapter = RVAdapter(image.imgarr, this@Fav)}
//        }
//        rv.layoutManager= LinearLayoutManager(this)
//    }
    /////////////////////menu////////////////////////////


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu, menu)
//        return true
//    }
//
//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//
//        val item1 = menu!!.getItem(0)
//        item1.setTitle("switch to Main search")
//
//
//        return super.onPrepareOptionsMenu(menu)
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.m1 -> {
//                intent= Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }


}

