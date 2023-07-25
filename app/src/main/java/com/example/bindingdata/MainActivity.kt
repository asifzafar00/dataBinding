package com.example.bindingdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bindingdata.data.Post
import com.example.bindingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val post = Post(
            title = "Julius Robert Oppenheimer", description = " American theoretical physicist and director of the Los Alamos Laboratory during World War II",
            URL = "https://imgnew.outlookindia.com/uploadimage/library/16_9/16_9_5/IMAGE_1689747434.webp"
        )
        binding.post = post
    }
}