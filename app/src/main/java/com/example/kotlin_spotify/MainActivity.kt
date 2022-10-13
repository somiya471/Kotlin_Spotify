package com.example.kotlin_spotify

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val title = ArrayList<String>()
    val artist = ArrayList<String>()
    val imageid = ArrayList<Int>()
    val song = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val db = DBHelper(this)
        db.insertuserdata("beginning_middle_end","Olivia Rodrigo",R.drawable.beginning_middle_end,"beginning_middle_end");
        db.insertuserdata("enna_sona","Ok Jaanu",R.drawable.enna_sona,"enna_sona");
        db.insertuserdata("night_changes","One Direction",R.drawable.night_changes,"night_changes");
        db.insertuserdata("rare","Selena Gomez",R.drawable.rare,"rare");
        db.insertuserdata("sun_sathiya","ABCD2",R.drawable.sun_sathiya,"sun_sathiya");
        db.insertuserdata("willow","Taylor Swift",R.drawable.willow,"willow");


        val adapter = RecyclerAdaper(this,title,artist,imageid)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this,4)
        displaydata()

    }
    fun displaydata(){
        val db = DBHelper(this)
        val cursor = db.getdata()
        if(cursor.count == 0){
            Toast.makeText(this,"No entry exist",Toast.LENGTH_LONG).show()
            return
        }
        else{
            while (cursor.moveToNext()){
                title.add(cursor.getString(0))
                artist.add(cursor.getString(1))
                imageid.add(cursor.getInt(2))
            }
        }

    }
}