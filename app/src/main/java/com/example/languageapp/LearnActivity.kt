package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LearnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)

        findViewById<TextView>(R.id.startCourse1).setOnClickListener { openCourse(1) }
        findViewById<TextView>(R.id.startCourse2).setOnClickListener { openCourse(2) }
        findViewById<TextView>(R.id.startCourse3).setOnClickListener { openCourse(3) }
        findViewById<TextView>(R.id.startCourse4).setOnClickListener { openCourse(4) }
        findViewById<TextView>(R.id.startCourse5).setOnClickListener { openCourse(5) }
        findViewById<TextView>(R.id.startCourse6).setOnClickListener { openCourse(6) }

        findViewById<TextView>(R.id.startCourse1_rec).setOnClickListener { openCourse(1) }
        findViewById<TextView>(R.id.startCourse3_rec).setOnClickListener { openCourse(3) }
        findViewById<TextView>(R.id.startCourse5_rec).setOnClickListener { openCourse(5) }

        setupBottomNavigation()
    }

    private fun openCourse(courseId: Int) {
        val intent = Intent(this, CourseActivity::class.java)
        intent.putExtra("COURSE_ID", courseId)
        startActivity(intent)
    }

    private fun setupBottomNavigation() {
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navLearn = findViewById<LinearLayout>(R.id.navLearn)
        val navForum = findViewById<LinearLayout>(R.id.navForum)
        val navSettings = findViewById<LinearLayout>(R.id.navSettings)

        navHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        navForum.setOnClickListener {
            val intent = Intent(this, ForumActivity::class.java)
            startActivity(intent)
            finish()
        }

        navSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}