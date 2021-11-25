package com.example.fretboard

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonList = mutableListOf<String>()
        val resourceList = mutableListOf<Int>()

        for (i in 1 until 3){
            val buttonID: String = "button$i"
            buttonList.add(buttonID)

            val resourceID: Int = this.resources.getIdentifier(buttonList[i-1], "id", this.packageName)
            resourceList.add(resourceID)

            val noteButton: Button = findViewById(resourceList[i-1])
            setListen(noteButton, i)
        }
//        for (j in 1 until 3){
//            val noteButton: Button = findViewById(resourceList[0])
//            setListen(noteButton, j)
//        }



//        noteButton.setOnClickListener {
//            val toast = Toast.makeText(this, "You played the C note", Toast.LENGTH_SHORT)
//            toast.show()
//            val cSound : MediaPlayer = MediaPlayer.create(this, R.raw.soundbite2)
//            cSound.start()
//        }

//        val superButton: Button = findViewById(R.id.button2)
//        superButton.setOnClickListener {
//            val toast = Toast.makeText(this, "You played the super note", Toast.LENGTH_SHORT)
//            toast.show()
//            val sSound : MediaPlayer = MediaPlayer.create(this, R.raw.soundbite3)
//            sSound.start()
//
//        }
    }
    fun setListen(nButton: Button, n: Int){
        nButton.setOnClickListener {
            val toast = Toast.makeText(this, "You played the $n note", Toast.LENGTH_SHORT)
            toast.show()
            val cSound : MediaPlayer = MediaPlayer.create(this, R.raw.soundbite)
            cSound.start()
        }
    }
}
