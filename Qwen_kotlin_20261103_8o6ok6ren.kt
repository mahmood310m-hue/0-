// TopStudentsActivity.kt
package com.kawther.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kawther.school.databinding.ActivityTopStudentsBinding

data class Student(val name: String, val grade: String, val percentage: Double)

class TopStudentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopStudentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopStudentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "الطلاب المتفوقون"

        val students = listOf(
            Student("أحمد محمد العلي", "الصف العاشر", 98.5),
            Student("فاطمة خالد السعيد", "الصف التاسع", 97.8),
            Student("عمر يوسف الحسن", "الصف الحادي عشر", 96.5),
            Student("مريم عبدالله الكريم", "الصف العاشر", 95.9)
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = StudentAdapter(students)
    }

    override fun onSupportNavigateUp(): Boolean { finish(); return true }

    inner class StudentAdapter(private val list: List<Student>) : RecyclerView.Adapter<StudentAdapter.VH>() {
        inner class VH(view: View) : RecyclerView.ViewHolder(view) {
            val name: TextView = view.findViewById(R.id.tvName)
            val grade: TextView = view.findViewById(R.id.tvGrade)
            val perc: TextView = view.findViewById(R.id.tvPerc)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
            return VH(view)
        }
        override fun onBindViewHolder(holder: VH, position: Int) {
            val s = list[position]
            holder.name.text = s.name
            holder.grade.text = s.grade
            holder.perc.text = "${s.percentage}%"
        }
        override fun getItemCount() = list.size
    }
}