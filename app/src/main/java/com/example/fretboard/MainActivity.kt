package com.example.fretboard

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonList = mutableListOf<String>()
        val resourceList = mutableListOf<Int>()

//        val g : GridLayout = findViewById(R.id.GridLayout1)
//
//        for (j in 4 until 78){
//            val newNoteButton: Button = Button(this)
//            newNoteButton.text="button$j"
//            g.addView(newNoteButton)
//            println("button $j made")
//        }

        for (i in 1 until 72){
            val buttonID: String = "button$i"
            buttonList.add(buttonID)

            val resourceID: Int = this.resources.getIdentifier(buttonList[i-1], "id", this.packageName)
            resourceList.add(resourceID)
            println("resourceID pointer $i made")

            val noteButton: Button = findViewById(resourceList[i-1])
            println("resourceID pointer $i made")
            setListen(noteButton, i)
        }

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
