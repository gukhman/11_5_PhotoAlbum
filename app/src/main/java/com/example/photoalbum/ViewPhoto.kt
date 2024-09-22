package com.example.photoalbum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewPhoto : AppCompatActivity() {

    private lateinit var imageViewPhoto: ImageView
    private lateinit var buttonNext: Button
    private val photos = listOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4,
        R.drawable.photo5
    )
    private var currentPhotoIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageViewPhoto = findViewById(R.id.imageViewPhoto)
        buttonNext = findViewById(R.id.buttonNext)

        imageViewPhoto.setImageResource(photos[currentPhotoIndex])

        buttonNext.setOnClickListener {
            currentPhotoIndex++
            if (currentPhotoIndex < photos.size) {
                imageViewPhoto.setImageResource(photos[currentPhotoIndex])
            } else {
                val intent = Intent(this, ActivityEnd::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}