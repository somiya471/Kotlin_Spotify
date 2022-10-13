package com.example.kotlin_spotify

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SongPlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_play)

        val intent = intent
        val title = intent.getStringExtra("title")
        val artist = intent.getStringExtra("artist")
        val image = intent.getIntExtra("imageid",0)

        val title_set = findViewById<TextView>(R.id.title_set)
        val artist_set = findViewById<TextView>(R.id.artist_set)
        val image_set = findViewById<ImageView>(R.id.albumimage)

        title_set.text = title
        artist_set.text = title
        image_set.setImageResource(image)

        val mediaPlayer = MediaPlayer()
        val path = "android.resource://"+getPackageName()+"/raw/"+title
        val uri = Uri.parse(path)
        mediaPlayer.setDataSource(this,uri)
        mediaPlayer.prepare()



        val playbtn = findViewById<Button>(R.id.play)
        playbtn.setOnClickListener{
            //Toast.makeText(this,"Music playing",Toast.LENGTH_LONG).show()
            mediaPlayer.start()
        }
        val pausebtn = findViewById<Button>(R.id.pause)
        pausebtn.setOnClickListener{
            mediaPlayer.pause()
        }
        val stopbtn = findViewById<Button>(R.id.songstop)
        stopbtn.setOnClickListener{
            mediaPlayer.stop()
        }

        }



    }
