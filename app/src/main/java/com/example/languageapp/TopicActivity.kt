package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class TopicActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView
    private lateinit var sendMessageButton: ImageView
    private lateinit var messageInput: EditText
    private lateinit var recyclerChatMessages: RecyclerView

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var messagesList: MutableList<ChatMessage>

    private var topicId: String? = null
    private var topicTitle: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic)

        backButton = findViewById(R.id.backButton)
        sendMessageButton = findViewById(R.id.sendMessageButton)
        messageInput = findViewById(R.id.messageInput)
        recyclerChatMessages = findViewById(R.id.recyclerChatMessages)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/").reference

        topicId = intent.getStringExtra("TOPIC_ID")
        topicTitle = intent.getStringExtra("TOPIC_TITLE")

        findViewById<android.widget.TextView>(R.id.topicTitle).text = topicTitle

        messagesList = mutableListOf()
        chatAdapter = ChatAdapter(messagesList)
        recyclerChatMessages.layoutManager = LinearLayoutManager(this)
        recyclerChatMessages.adapter = chatAdapter

        loadMessages()

        sendMessageButton.setOnClickListener {
            sendMessage()
        }

        backButton.setOnClickListener {
            finish()
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

    private fun loadMessages() {
        topicId?.let { id ->
            database.child("forumMessages").child(id)
                .orderByChild("timestamp")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        messagesList.clear()
                        for (messageSnapshot in snapshot.children) {
                            val message = messageSnapshot.getValue(ChatMessage::class.java)
                            message?.let { messagesList.add(it) }
                        }
                        chatAdapter.notifyDataSetChanged()
                        recyclerChatMessages.scrollToPosition(messagesList.size - 1)
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(this@TopicActivity, "Помилка завантаження чату", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    private fun sendMessage() {
        val text = messageInput.text.toString().trim()
        if (text.isEmpty()) {
            Toast.makeText(this, "Введіть повідомлення", Toast.LENGTH_SHORT).show()
            return
        }

        val user = auth.currentUser ?: return
        val userId = user.uid
        val userName = user.displayName ?: "Анонімний користувач"

        val messageId = database.child("forumMessages").child(topicId!!).push().key ?: return
        val timestamp = System.currentTimeMillis()

        val message = ChatMessage(
            id = messageId,
            topicId = topicId!!,
            userId = userId,
            userName = userName,
            message = text,
            timestamp = timestamp
        )

        database.child("forumMessages").child(topicId!!).child(messageId).setValue(message)
            .addOnSuccessListener {
                messageInput.setText("")
                recyclerChatMessages.scrollToPosition(messagesList.size - 1)
            }
            .addOnFailureListener {
                Toast.makeText(this, "Помилка надсилання повідомлення", Toast.LENGTH_SHORT).show()
            }
    }
}