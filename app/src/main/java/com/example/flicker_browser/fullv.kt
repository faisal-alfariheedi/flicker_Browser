package com.example.flicker_browser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.flicker_browser.db.imageDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class fullv : Fragment() {
    lateinit var im: ImageView
    lateinit var tv: TextView
    lateinit var bk: Button
    lateinit var fb: ImageButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v=inflater.inflate(R.layout.fragment_fullv, container, false)

        var db= imageDB.getInstance(v.context).imageDao()
        var favlist: List<String>
        var favo=false
        var pos:Int = image.pocket[1]
        im =v.findViewById(R.id.imageView)
        tv=v.findViewById(R.id.tvtitle)
        bk=v.findViewById(R.id.back)
        fb=v.findViewById(R.id.imageButton)
        CoroutineScope(Dispatchers.IO).launch {
            favlist=db.getfavidlist()
            if (favlist.contains(image.imgarr[pos].id)) {
                activity?.runOnUiThread{fb.setImageResource(R.drawable.heartred)}
                favo = true
            }
        }
        fb.setOnClickListener{
            if(favo){
                CoroutineScope(Dispatchers.IO).launch {
                    db.deleteImage(image.imgarr[pos])}
                fb.setImageResource(R.drawable.heardblk)
                favo=false
            }else{
                CoroutineScope(Dispatchers.IO).launch {
                    db.addeditIMage(image.imgarr[pos])}
                fb.setImageResource(R.drawable.heartred)
                favo=true
            }

        }
        Glide.with(im.getContext())
            .load(image.imgarr[pos].link)
            .into(im)
        tv.text=image.imgarr[pos].title
        bk.setOnClickListener{
            //switch back to caller
            when(image.pocket[0]){
                0->{
                    Navigation.findNavController(requireView()).navigate(R.id.action_fullv_to_main)
                }
                1->{
                    Navigation.findNavController(requireView()).navigate(R.id.action_fullv_to_favv)
                }
            }



        }

        return v
    }

}