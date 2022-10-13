package com.example.kotlin_spotify

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdaper(val context: Context,val title_id:ArrayList<String>,val artist_id:ArrayList<String>,val image_id:ArrayList<Int>):RecyclerView.Adapter<RecyclerAdaper.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ImageView>(R.id.img)
        val title = itemView.findViewById<TextView>(R.id.title_text)
        val artist = itemView.findViewById<TextView>(R.id.artist_text)




    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdaper.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.song_entry,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerAdaper.ViewHolder, position: Int) {
        holder.img.setImageResource(image_id[position])
        holder.title.text = title_id[position]
        holder.artist.text = artist_id[position]
        holder.itemView.setOnClickListener{
            val iNext = Intent(context,SongPlayActivity::class.java)
            iNext.putExtra("title", title_id[position].toString())
            iNext.putExtra("artist", artist_id[position].toString())
            iNext.putExtra("imageid", image_id[position].toString().toInt())
            context.startActivity(iNext)
        }

    }

    override fun getItemCount(): Int {
        return title_id.size

    }
}