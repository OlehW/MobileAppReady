package com.example.languageapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class CourseAdapter(
    private val courses: List<Course>,
    private val onCourseClick: (Course) -> Unit
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private val progressMap = mutableMapOf<Int, Pair<Int, Int>>()

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseIcon: ShapeableImageView = itemView.findViewById(R.id.courseIcon)
        val courseTitle: TextView = itemView.findViewById(R.id.courseTitle)
        val courseLevel: TextView = itemView.findViewById(R.id.courseLevel)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val courseProgressText: TextView = itemView.findViewById(R.id.courseProgressText)
        val coursePercentage: TextView = itemView.findViewById(R.id.coursePercentage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]

        holder.courseTitle.text = course.title
        holder.courseLevel.text = course.level

        val imageResId = getCourseImage(course.id)
        holder.courseIcon.setImageResource(imageResId)

        val (completedLessons, totalLessons) = progressMap[course.id] ?: Pair(0, course.lessons.size)
        val percentage = if (totalLessons > 0) (completedLessons * 100) / totalLessons else 0

        holder.progressBar.progress = percentage
        holder.courseProgressText.text = "$completedLessons із $totalLessons розділів"
        holder.coursePercentage.text = "$percentage% виконано"

    }

    override fun getItemCount(): Int = courses.size

    private fun getCourseImage(courseId: Int): Int {
        return when (courseId) {
            1 -> R.drawable.ic_grammar_a1
            2 -> R.drawable.ic_grammar_a2
            3 -> R.drawable.ic_vocabulary_a1
            4 -> R.drawable.ic_vocabulary_a2
            5 -> R.drawable.ic_words_a1
            6 -> R.drawable.ic_words_a2
            else -> R.drawable.ic_user_avatar
        }
    }

    fun updateProgressMap(newProgressMap: Map<Int, Pair<Int, Int>>) {
        progressMap.clear()
        progressMap.putAll(newProgressMap)
        notifyDataSetChanged()
    }
}