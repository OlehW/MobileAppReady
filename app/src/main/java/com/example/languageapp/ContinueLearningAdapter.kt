package com.example.languageapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ContinueLearningAdapter(
    private var course: Course?,
    private val onContinueClick: (Course) -> Unit
) : RecyclerView.Adapter<ContinueLearningAdapter.ViewHolder>() {

    // Змінні для збереження прогресу
    private var completedLessons: Int = 0
    private var totalLessons: Int = course?.lessons?.size ?: 0

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val courseIcon: ShapeableImageView = view.findViewById(R.id.courseIcon)
        val courseTitle: TextView = view.findViewById(R.id.courseTitle)
        val courseLevel: TextView = view.findViewById(R.id.courseLevel)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
        val progressText: TextView = view.findViewById(R.id.courseProgressText)
        val progressPercentage: TextView = view.findViewById(R.id.coursePercentage)
        val continueButton: Button = view.findViewById(R.id.continueButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_continue_learning, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = course ?: return

        holder.courseTitle.text = course.title
        holder.courseLevel.text = course.level
        holder.courseIcon.setImageResource(course.imageResId)

        val progressPercentageValue = if (totalLessons > 0) (completedLessons * 100) / totalLessons else 0

        holder.progressBar.progress = progressPercentageValue
        holder.progressText.text = "$completedLessons із $totalLessons розділів"
        holder.progressPercentage.text = "$progressPercentageValue% виконано"

        holder.continueButton.text = "Продовжити"

        holder.continueButton.setOnClickListener {
            onContinueClick(course)
        }
    }

    override fun getItemCount(): Int = if (course == null) 0 else 1

    fun updateCourse(newCourse: Course?) {
        course = newCourse
        totalLessons = course?.lessons?.size ?: 0
        notifyDataSetChanged()
    }

    fun updateProgress(completed: Int, total: Int) {
        completedLessons = completed
        totalLessons = total
        notifyDataSetChanged()
    }
}