package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ForumActivity : AppCompatActivity() {

    private lateinit var recyclerForumTopics: RecyclerView
    private lateinit var btnCreateTopic: ImageView
    private lateinit var forumAdapter: ForumAdapter
    private lateinit var topicsList: MutableList<ForumTopic>

    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)

        recyclerForumTopics = findViewById(R.id.recyclerForumTopics)
        btnCreateTopic = findViewById(R.id.btnCreateTopic)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference.child("forumTopics")

        topicsList = mutableListOf()
        forumAdapter = ForumAdapter(
            context = this,
            topics = topicsList,
            onTopicClick = { openTopic(it) },
            onDeleteClick = { deleteTopic(it) }
        )

        recyclerForumTopics.layoutManager = LinearLayoutManager(this)
        recyclerForumTopics.adapter = forumAdapter

        btnCreateTopic.setOnClickListener {
            startActivity(Intent(this, CreateTopicActivity::class.java))
        }

        loadTopics()

        setupBottomNavigation()
    }

    private fun loadTopics() {
        database.orderByChild("timestamp").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                topicsList.clear()
                for (topicSnapshot in snapshot.children) {
                    val topic = topicSnapshot.getValue(ForumTopic::class.java)
                    if (topic != null) {
                        topicsList.add(topic)
                    }
                }
                topicsList.reverse() // Найновіші теми відображаються зверху
                forumAdapter.updateTopics(topicsList)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ForumActivity", "Помилка завантаження тем: ${error.message}")
                Toast.makeText(this@ForumActivity, "Помилка завантаження тем", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun openTopic(topic: ForumTopic) {
        val intent = Intent(this, TopicActivity::class.java)
        intent.putExtra("TOPIC_ID", topic.id)
        intent.putExtra("TOPIC_TITLE", topic.title)
        startActivity(intent)
    }

    private fun deleteTopic(topic: ForumTopic) {
        val currentUserId = auth.currentUser?.uid
        if (topic.userId != currentUserId) {
            Toast.makeText(this, "Ви можете видалити тільки власні теми", Toast.LENGTH_SHORT).show()
            return
        }

        AlertDialog.Builder(this)
            .setTitle("Видалити тему?")
            .setMessage("Ця дія не може бути скасована.")
            .setPositiveButton("Так") { _, _ ->
                database.child(topic.id).removeValue()
                    .addOnSuccessListener {
                        Toast.makeText(this, "Тема видалена", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Помилка при видаленні теми", Toast.LENGTH_SHORT).show()
                    }
            }
            .setNegativeButton("Скасувати", null)
            .show()
    }

    private fun setupBottomNavigation() {
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navLearn = findViewById<LinearLayout>(R.id.navLearn)
        val navForum = findViewById<LinearLayout>(R.id.navForum)
        val navSettings = findViewById<LinearLayout>(R.id.navSettings)

        val iconHome = findViewById<ImageView>(R.id.iconHome)
        val iconLearn = findViewById<ImageView>(R.id.iconLearn)
        val iconForum = findViewById<ImageView>(R.id.iconForum)
        val iconSettings = findViewById<ImageView>(R.id.iconSettings)

        navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        navLearn.setOnClickListener {
            startActivity(Intent(this, LearnActivity::class.java))
            finish()
        }

        navSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
        }

        updateBottomBarColors(iconHome, iconLearn, iconForum, iconSettings)
    }

    private fun updateBottomBarColors(iconHome: ImageView, iconLearn: ImageView, iconForum: ImageView, iconSettings: ImageView) {
        iconHome.setColorFilter(resources.getColor(R.color.white))
        iconLearn.setColorFilter(resources.getColor(R.color.white))
        iconForum.setColorFilter(resources.getColor(R.color.button_yellow)) // Виділяємо активну вкладку
        iconSettings.setColorFilter(resources.getColor(R.color.white))
    }
}