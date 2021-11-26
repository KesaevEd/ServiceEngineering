package com.example.servisengineering

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sosh59: LinearLayout = findViewById(R.id.sosh59)
        val sosh93: LinearLayout = findViewById(R.id.sosh93)
        val ursha: LinearLayout= findViewById(R.id.ursha)
        val priut: LinearLayout = findViewById(R.id.priut)
        val detSad: LinearLayout = findViewById(R.id.detSad)

        sosh59.setOnClickListener {
            val intent = Intent(this, School59::class.java)
            startActivity(intent)
        }

        sosh93.setOnClickListener {
            val intent = Intent(this, School93::class.java)
            startActivity(intent)
        }

        priut.setOnClickListener {
            val intent = Intent(this, Priyt::class.java)
            startActivity(intent)
        }

        ursha.setOnClickListener {
            val intent = Intent(this, Ursha::class.java)
            startActivity(intent)
        }

        detSad.setOnClickListener {
            val intent = Intent(this, DetSadKalyaeva::class.java)
            startActivity(intent)
        }
    }
}