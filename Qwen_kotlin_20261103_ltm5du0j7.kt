// MainActivity.kt
package com.kawther.school

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.kawther.school.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMarquee()
        setupCards()
    }

    private fun setupMarquee() {
        binding.marqueeText.post {
            val screenWidth = resources.displayMetrics.widthPixels
            val animator = android.animation.ObjectAnimator.ofFloat(
                binding.marqueeText, "translationX", -binding.marqueeText.width.toFloat(), screenWidth.toFloat()
            )
            animator.duration = 15000 // 15 ثانية للحركة
            animator.repeatCount = android.animation.ValueAnimator.INFINITE
            animator.interpolator = LinearInterpolator()
            animator.start()
        }
    }

    private fun setupCards() {
        binding.cardTopStudents.setOnClickListener { startActivity(Intent(this, TopStudentsActivity::class.java)) }
        binding.cardNews.setOnClickListener { startActivity(Intent(this, GenericActivity::class.java).putExtra("TITLE", "الأخبار والفعاليات").putExtra("CONTENT", "• حفل تكريم المتفوقين قريباً\n• رحلة علمية للأسبوع القادم\n• يوم العائلة المفتوح")) }
        binding.cardSchedule.setOnClickListener { startActivity(Intent(this, GenericActivity::class.java).putExtra("TITLE", "الجدول المدرسي").putExtra("CONTENT", "الدوام من الأحد للخميس\n8:00 صباحاً حتى 2:30 ظهراً")) }
        binding.cardAbout.setOnClickListener { startActivity(Intent(this, GenericActivity::class.java).putExtra("TITLE", "عن المدرسة").putExtra("CONTENT", "مدرسة كوثر الأهلية المختلطة\nنحو جيل واعٍ ومبدع\nللتواصل: info@kawther.edu")) }
    }
}