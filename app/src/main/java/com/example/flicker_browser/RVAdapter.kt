package com.example.flicker_browser

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class RVAdapter(var s:ArrayList<image>,var cont: Context): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
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
                val intent = Intent(cont, fullview::class.java)
                intent.putExtra("pos",position)
                context.startActivity(intent)
            }
        }
    }


    override fun getItemCount() = s.size
}