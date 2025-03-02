package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class CreateTopicActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView
    private lateinit var userAvatar: ImageView
    private lateinit var userName: TextView
    private lateinit var topicTitle: EditText
    private lateinit var topicDescription: EditText
    private lateinit var btnCreateTopic: Button

    private lateinit var auth: FirebaseAuth
    private val database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/").reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_topic)

        backButton = findViewById(R.id.backButton)
        userAvatar = findViewById(R.id.userAvatar)
        userName = findViewById(R.id.userName)
        topicTitle = findViewById(R.id.topicTitle)
        topicDescription = findViewById(R.id.topicDescription)
        btnCreateTopic = findViewById(R.id.btnCreateTopic)

        auth = FirebaseAuth.getInstance()

        loadUserData()

        backButton.setOnClickListener {
            finish()
        }

        btnCreateTopic.setOnClickListener {
            createTopic()
        }

        setupBottomNavigation()
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

    private fun loadUserData() {
        val user = auth.currentUser
        if (user != null) {
            userName.text = user.displayName ?: "Анонімний користувач"

            val userId = user.uid
            database.child("users").child(userId).get()
                .addOnSuccessListener { dataSnapshot ->
                    val avatarBase64 = dataSnapshot.child("avatar").getValue(String::class.java)
                    if (!avatarBase64.isNullOrEmpty()) {
                        val imageBytes = Base64.decode(avatarBase64, Base64.DEFAULT)
                        Glide.with(this)
                            .load(imageBytes)
                            .circleCrop()
                            .placeholder(R.drawable.ic_user_avatar)
                            .into(userAvatar)
                    }
                }
        }
    }

    private fun createTopic() {
        val title = topicTitle.text.toString().trim()
        val description = topicDescription.text.toString().trim()
        val userId = auth.currentUser?.uid ?: return
        val userNameText = userName.text.toString()

        if (title.isEmpty()) {
            Toast.makeText(this, "Введіть назву теми", Toast.LENGTH_SHORT).show()
            return
        }
        if (description.isEmpty()) {
            Toast.makeText(this, "Введіть опис теми", Toast.LENGTH_SHORT).show()
            return
        }

        val topicId = database.child("forumTopics").push().key ?: return
        val timestamp = System.currentTimeMillis()

        val topic = ForumTopic(
            id = topicId,
            userId = userId,
            userName = userNameText,
            title = title,
            timestamp = timestamp
        )

        database.child("forumTopics").child(topicId).setValue(topic)
            .addOnSuccessListener {
                addFirstMessage(topicId, userId, userNameText, description)
            }
            .addOnFailureListener {
                Toast.makeText(this, "Помилка створення теми", Toast.LENGTH_SHORT).show()
            }
    }

    private fun addFirstMessage(topicId: String, userId: String, userName: String, messageText: String) {
        val messageId = database.child("forumMessages").child(topicId).push().key ?: return
        val timestamp = System.currentTimeMillis()

        val message = ChatMessage(
            id = messageId,
            topicId = topicId,
            userId = userId,
            userName = userName,
            message = messageText,
            timestamp = timestamp
        )

        database.child("forumMessages").child(topicId).child(messageId).setValue(message)
            .addOnSuccessListener {
                Toast.makeText(this, "Тема створена", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, TopicActivity::class.java)
                intent.putExtra("TOPIC_ID", topicId)
                intent.putExtra("TOPIC_TITLE", topicTitle.text.toString())
                startActivity(intent)
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Помилка при додаванні першого повідомлення", Toast.LENGTH_SHORT).show()
            }
    }
}