// GenericActivity.kt
package com.kawther.school

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kawther.school.databinding.ActivityGenericBinding

class GenericActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGenericBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        binding.tvTitle.text = intent.getStringExtra("TITLE")
        binding.tvContent.text = intent.getStringExtra("CONTENT")
    }
    override fun onSupportNavigateUp(): Boolean { finish(); return true }
}