package com.example.flicker_browser

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView


class RVAdapter(var s:ArrayList<image>,var cont: Fragment): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ItemViewHolder {
        return RVAdapter.ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rvlist, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val rv = s[position]
        holder.itemView.apply {
            var im = findViewById<ImageView>(R.id.im)
            GlideApp.with(im.getContext())
                .load(rv.link)
                .placeholder(R.drawable.ic_baseline_downloading_24)
                .dontAnimate()
                .into(im)
            im.setOnClickListener {
                image.pocket[1]=position
                if(cont is main) {
                    image.pocket[0] = 0
                    Navigation.findNavController(cont.requireView()).navigate(R.id.action_main_to_fullv)
                }
                if(cont is favv) {
                    image.pocket[0] = 1
                    Navigation.findNavController(cont.requireView()).navigate(R.id.action_favv_to_fullv)
                }
            }
        }
    }


    override fun getItemCount() = s.size
}