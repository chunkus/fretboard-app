package com.example.fretboard

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.annotation.RawRes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonList = mutableListOf<String>()
        val resourceList = mutableListOf<Int>()
        val noteList = mutableListOf<String>()
        val sresourceList = mutableListOf<Int>()

        for (i in 1 until 4){
            val buttonID: String = "button$i"
            buttonList.add(buttonID)

            val noteID: String = "note$i"
            noteList.add(noteID)

            val resourceID: Int = this.resources.getIdentifier(buttonList[i-1], "id", this.packageName)
            resourceList.add(resourceID)
            val sresourceID: Int = this.resources.getIdentifier(noteList[i-1], "id", this.packageName)
            sresourceList.add(sresourceID)


            val noteButton: Button = findViewById(resourceList[i-1])

            setListen(noteButton,sresourceID, i)
        }

    }
    fun setListen(nButton: Button, sRaw: Int, n: Int){
        nButton.setOnClickListener {
            val toast = Toast.makeText(this, "You played the $n note", Toast.LENGTH_SHORT)
            toast.show()
            val cSound : MediaPlayer = MediaPlayer.create(this, sRaw)
            cSound.start()
        }
    }
}
