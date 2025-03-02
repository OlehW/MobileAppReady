package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class CourseActivity : AppCompatActivity() {

    private lateinit var courseTitle: TextView
    private lateinit var backButton: ImageView
    private lateinit var recyclerLessons: RecyclerView
    private lateinit var lessonAdapter: LessonAdapter
    private var courseId: Int = -1

    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/").reference

    companion object {
        const val REQUEST_CODE_LESSON = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        courseTitle = findViewById(R.id.courseTitle)
        backButton = findViewById(R.id.backButton)
        recyclerLessons = findViewById(R.id.recyclerLessons)

        courseId = intent.getIntExtra("COURSE_ID", -1)
        Log.d("CourseActivity", "Отримано COURSE_ID: $courseId")

        val selectedCourse = CourseData.courses.find { it.id == courseId }

        if (selectedCourse != null) {
            courseTitle.text = selectedCourse.title
            setupRecyclerView(selectedCourse)
            saveLastActiveCourse(courseId)
            loadCourseProgress(courseId)
        } else {
            Log.e("CourseActivity", "Курс з ID $courseId не знайдено!")
            courseTitle.text = "Курс не знайдено"
        }

        backButton.setOnClickListener {
            finish()
        }

        setupBottomNavigation()
    }

    private fun setupRecyclerView(course: Course) {
        recyclerLessons.layoutManager = LinearLayoutManager(this)
        lessonAdapter = LessonAdapter(course.lessons) { lesson ->
            Log.d("CourseActivity", "Натиснуто урок: ${lesson.title}, ID: ${lesson.id}")
            openLesson(lesson)
        }
        recyclerLessons.adapter = lessonAdapter
    }

    private fun openLesson(lesson: Lesson) {
        val intent = Intent(this, SectionActivity::class.java)
        intent.putExtra("COURSE_ID", courseId)
        intent.putExtra("LESSON_ID", lesson.id)
        startActivityForResult(intent, REQUEST_CODE_LESSON)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_LESSON && resultCode == RESULT_OK) {
            val completedLessonId = data?.getIntExtra("LESSON_ID", -1)
            if (completedLessonId != null && completedLessonId != -1) {
                lessonAdapter.markLessonAsCompleted(completedLessonId)
            }
        }
    }

    private fun setupBottomNavigation() {
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navLearn = findViewById<LinearLayout>(R.id.navLearn)
        val navForum = findViewById<LinearLayout>(R.id.navForum)
        val navSettings = findViewById<LinearLayout>(R.id.navSettings)

        navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        navLearn.setOnClickListener {
            startActivity(Intent(this, LearnActivity::class.java))
            finish()
        }

        navForum.setOnClickListener {
            startActivity(Intent(this, ForumActivity::class.java))
            finish()
        }

        navSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
        }
    }

    private fun saveLastActiveCourse(courseId: Int) {
        val userId = auth.currentUser?.uid ?: return
        database.child("users").child(userId).child("lastActiveCourse").setValue(courseId)
            .addOnSuccessListener {
                Log.d("CourseActivity", "Останній активний курс збережено: $courseId")
            }
            .addOnFailureListener {
                Log.e("CourseActivity", "Помилка збереження останнього активного курсу")
                Toast.makeText(this, "Помилка збереження прогресу", Toast.LENGTH_SHORT).show()
            }
    }

    private fun loadCourseProgress(courseId: Int) {
        val userId = auth.currentUser?.uid ?: return
        database.child("users").child(userId)
            .child("coursesProgress")
            .child(courseId.toString())
            .child("completedLessons")
            .get()
            .addOnSuccessListener { dataSnapshot ->
                val completedLessons = mutableSetOf<Int>()
                for (child in dataSnapshot.children) {
                    val lessonId = child.key?.toIntOrNull()
                    if (lessonId != null) {
                        completedLessons.add(lessonId)
                    }
                }
                lessonAdapter.setCompletedLessons(completedLessons)
            }
            .addOnFailureListener {
                Log.e("CourseActivity", "Не вдалося завантажити прогрес курсу")
            }
    }
}