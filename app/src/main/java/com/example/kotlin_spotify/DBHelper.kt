package com.example.kotlin_spotify

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):
    SQLiteOpenHelper(context,"PlaylistDB",null,1){
    override fun onCreate(db: SQLiteDatabase) {
        //val query = ("create Table PlaylistSong(title TEXT primary key,artist TEXT,imageid int,song TEXT)")
        db.execSQL("create Table PlaylistSong(title TEXT primary key,artist TEXT,imageid int,song TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists PlaylistSong")
        onCreate(db)
    }

    fun insertuserdata(title:String,artist:String,imageid:Int,song:String){
        val db = this.writableDatabase
        val values = ContentValues()

        values.put("title",title)
        values.put("artist",artist)
        values.put("imageid",imageid)
        values.put("song",song)

        db.insert("PlaylistSong",null,values)
        db.close()
    }

    fun getdata(): Cursor{
        val db = this.readableDatabase
        return db.rawQuery("Select * from PlaylistSong",null)
    }

}