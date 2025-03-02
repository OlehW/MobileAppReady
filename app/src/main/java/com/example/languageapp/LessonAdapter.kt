package com.example.languageapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonAdapter(
    private val lessons: List<Lesson>,
    private val onLessonClick: (Lesson) -> Unit
) : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private val completedLessons = mutableSetOf<Int>()

    inner class LessonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lessonTitle: TextView = view.findViewById(R.id.lessonTitle)
        val lessonTopic: TextView = view.findViewById(R.id.lessonTopic)
        val lessonStatusIcon: ImageView = view.findViewById(R.id.lessonStatusIcon)
        val startLessonButton: Button = view.findViewById(R.id.startLesson)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = lessons[position]
        holder.lessonTitle.text = lesson.title
        holder.lessonTopic.text = lesson.topic

        if (completedLessons.contains(lesson.id)) {
            holder.lessonStatusIcon.setImageResource(R.drawable.ic_check)
        } else {
            holder.lessonStatusIcon.setImageResource(R.drawable.ic_statusmain)
        }

        holder.startLessonButton.setOnClickListener {
            onLessonClick(lesson)
        }
    }

    override fun getItemCount(): Int = lessons.size

    fun markLessonAsCompleted(lessonId: Int) {
        completedLessons.add(lessonId)
        notifyDataSetChanged()
    }

    fun setCompletedLessons(newCompletedLessons: Set<Int>) {
        completedLessons.clear()
        completedLessons.addAll(newCompletedLessons)
        notifyDataSetChanged()
    }
}