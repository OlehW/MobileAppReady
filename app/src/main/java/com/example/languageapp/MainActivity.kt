package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.work.*
import java.util.concurrent.TimeUnit
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerCourses: RecyclerView
    private lateinit var continueLearningRecyclerView: RecyclerView
    private lateinit var courseAdapter: CourseAdapter
    private lateinit var continueLearningAdapter: ContinueLearningAdapter
    private lateinit var userAvatar: ShapeableImageView
    private lateinit var userGreeting: TextView
    private lateinit var notificationsIcon: ImageView
    private lateinit var continueLearningTitle: TextView

    private lateinit var auth: FirebaseAuth
    private val database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/").reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        val userId = auth.currentUser?.uid ?: return

        recyclerCourses = findViewById(R.id.recyclerCourses)
        continueLearningRecyclerView = findViewById(R.id.continueLearningRecyclerView)
        userAvatar = findViewById(R.id.userAvatar)
        userGreeting = findViewById(R.id.userGreeting)
        notificationsIcon = findViewById(R.id.notificationsIcon)
        continueLearningTitle = findViewById(R.id.continueLearningTitle)

        recyclerCourses.layoutManager = LinearLayoutManager(this)
        continueLearningRecyclerView.layoutManager = LinearLayoutManager(this)

        courseAdapter = CourseAdapter(CourseData.courses) { selectedCourse ->
            openCourse(selectedCourse.id)
        }
        recyclerCourses.adapter = courseAdapter

        continueLearningAdapter = ContinueLearningAdapter(null) { selectedCourse ->
            openCourse(selectedCourse.id)
        }
        continueLearningRecyclerView.adapter = continueLearningAdapter

        continueLearningRecyclerView.visibility = View.GONE
        continueLearningTitle.visibility = View.GONE

        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navLearn = findViewById<LinearLayout>(R.id.navLearn)
        val navForum = findViewById<LinearLayout>(R.id.navForum)
        val navSettings = findViewById<LinearLayout>(R.id.navSettings)

        val iconHome = findViewById<ImageView>(R.id.iconHome)
        val iconLearn = findViewById<ImageView>(R.id.iconLearn)
        val iconForum = findViewById<ImageView>(R.id.iconForum)
        val iconSettings = findViewById<ImageView>(R.id.iconSettings)

        updateBottomBarColors(iconHome, iconLearn, iconForum, iconSettings)

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

        notificationsIcon.setOnClickListener {
            startActivity(Intent(this, NotificationsActivity::class.java))
        }

        loadUserData(userId)
        loadLastActiveCourse(userId)
        loadAllCoursesProgress(userId)

        scheduleNotifications()
    }

    private fun scheduleNotifications() {
        val workManager = WorkManager.getInstance(this)

        val notificationWork1 = PeriodicWorkRequestBuilder<ReminderWorker>(3, TimeUnit.HOURS)
            .setInputData(workDataOf("notification_type" to 1))
            .build()

        val notificationWork2 = PeriodicWorkRequestBuilder<ReminderWorker>(6, TimeUnit.HOURS)
            .setInputData(workDataOf("notification_type" to 2))
            .build()

        val notificationWork3 = PeriodicWorkRequestBuilder<ReminderWorker>(24, TimeUnit.HOURS)
            .setInputData(workDataOf("notification_type" to 3))
            .build()

        workManager.enqueueUniquePeriodicWork("motivation", ExistingPeriodicWorkPolicy.KEEP, notificationWork1)
        workManager.enqueueUniquePeriodicWork("new_lesson", ExistingPeriodicWorkPolicy.KEEP, notificationWork2)
        workManager.enqueueUniquePeriodicWork("missed_training", ExistingPeriodicWorkPolicy.KEEP, notificationWork3)
    }

    override fun onResume() {
        super.onResume()
        val userId = auth.currentUser?.uid ?: return
        loadUserData(userId)
        loadLastActiveCourse(userId)
        loadAllCoursesProgress(userId)
    }

    private fun updateBottomBarColors(iconHome: ImageView, iconLearn: ImageView, iconForum: ImageView, iconSettings: ImageView) {
        iconHome.setColorFilter(resources.getColor(R.color.button_yellow))
        iconLearn.setColorFilter(resources.getColor(R.color.white))
        iconForum.setColorFilter(resources.getColor(R.color.white))
        iconSettings.setColorFilter(resources.getColor(R.color.white))
    }

    private fun openCourse(courseId: Int) {
        val intent = Intent(this, CourseActivity::class.java)
        intent.putExtra("COURSE_ID", courseId)
        startActivity(intent)
    }

    private fun loadUserData(userId: String) {
        val user = auth.currentUser
        var displayName = user?.displayName

        database.child("users").child(userId).get()
            .addOnSuccessListener { dataSnapshot ->
                val dbDisplayName = dataSnapshot.child("name").getValue(String::class.java)
                val avatarBase64 = dataSnapshot.child("avatar").getValue(String::class.java)

                if (!dbDisplayName.isNullOrEmpty()) {
                    displayName = dbDisplayName
                }

                userGreeting.text = if (!displayName.isNullOrEmpty()) "Вітаємо, $displayName" else "Вітаємо, User"

                if (!avatarBase64.isNullOrEmpty()) {
                    val imageBytes = Base64.decode(avatarBase64, Base64.DEFAULT)
                    Glide.with(this)
                        .load(imageBytes)
                        .circleCrop()
                        .placeholder(R.drawable.ic_user_avatar)
                        .into(userAvatar)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Не вдалося завантажити дані користувача", Toast.LENGTH_SHORT).show()
                userGreeting.text = "Вітаємо, User"
            }
    }

    private fun loadLastActiveCourse(userId: String) {
        database.child("users").child(userId).child("lastActiveCourse").get()
            .addOnSuccessListener { dataSnapshot ->
                val courseId = dataSnapshot.getValue(Int::class.java)
                if (courseId != null) {
                    val course = CourseData.courses.find { it.id == courseId }
                    if (course != null) {
                        continueLearningAdapter.updateCourse(course)
                        // Показуємо блок "Continue Learning"
                        continueLearningRecyclerView.visibility = View.VISIBLE
                        continueLearningTitle.visibility = View.VISIBLE
                        // Завантажуємо прогрес для останнього активного курсу
                        loadContinueLearningProgress(userId, course.id)
                    }
                } else {
                    // Ховаємо блок, якщо немає активного курсу
                    continueLearningRecyclerView.visibility = View.GONE
                    continueLearningTitle.visibility = View.GONE
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Не вдалося завантажити останній активний курс", Toast.LENGTH_SHORT).show()
            }
    }

    private fun loadAllCoursesProgress(userId: String) {
        database.child("users").child(userId)
            .child("coursesProgress")
            .get()
            .addOnSuccessListener { dataSnapshot ->
                val progressMap = mutableMapOf<Int, Pair<Int, Int>>()
                for (course in CourseData.courses) {
                    val courseSnapshot = dataSnapshot.child(course.id.toString())
                    val completedLessonsCount = courseSnapshot.child("completedLessons").childrenCount.toInt()
                    progressMap[course.id] = Pair(completedLessonsCount, course.lessons.size)
                }
                courseAdapter.updateProgressMap(progressMap)
            }
            .addOnFailureListener {
                Log.e("MainActivity", "Не вдалося завантажити прогрес курсів")
            }
    }

    private fun loadContinueLearningProgress(userId: String, courseId: Int) {
        database.child("users").child(userId)
            .child("coursesProgress")
            .child(courseId.toString())
            .child("completedLessons")
            .get()
            .addOnSuccessListener { dataSnapshot ->
                val completedCount = dataSnapshot.childrenCount.toInt()
                val totalLessons = CourseData.courses.find { it.id == courseId }?.lessons?.size ?: 0
                continueLearningAdapter.updateProgress(completedCount, totalLessons)
            }
            .addOnFailureListener {
                Log.e("MainActivity", "Не вдалося завантажити прогрес для курсу Продовження навчання")
            }
    }
}