package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class NotificationsActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var notificationsContainer: LinearLayout
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("notifications")

        notificationsContainer = findViewById(R.id.notificationsContainer)
        backButton = findViewById(R.id.backButton)

        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navLearn = findViewById<LinearLayout>(R.id.navLearn)
        val navForum = findViewById<LinearLayout>(R.id.navForum)
        val navSettings = findViewById<LinearLayout>(R.id.navSettings)

        loadNotifications()

        backButton.setOnClickListener {
            finish()
        }

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

    private fun loadNotifications() {
        val userId = auth.currentUser?.uid ?: return

        database.child(userId).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                notificationsContainer.removeAllViews()
                for (notificationSnapshot in snapshot.children) {
                    val message = notificationSnapshot.child("message").getValue(String::class.java) ?: ""
                    val timestamp = notificationSnapshot.child("timestamp").getValue(String::class.java) ?: ""
                    val notificationKey = notificationSnapshot.key ?: ""

                    addNotificationToView(message, timestamp, notificationKey)
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    private fun addNotificationToView(message: String, timestamp: String, notificationKey: String) {
        val inflater = LayoutInflater.from(this)
        val notificationView = inflater.inflate(R.layout.item_notification, notificationsContainer, false)

        val appNameTextView = notificationView.findViewById<TextView>(R.id.appNameTextView)
        val messageTextView = notificationView.findViewById<TextView>(R.id.messageTextView)
        val timeTextView = notificationView.findViewById<TextView>(R.id.timeTextView)
        val deleteButton = notificationView.findViewById<TextView>(R.id.deleteNotification)

        appNameTextView.text = "LanguageApp"
        messageTextView.text = message
        timeTextView.text = timestamp

        deleteButton.setOnClickListener {
            showDeleteDialog(notificationKey)
        }

        notificationsContainer.addView(notificationView, 0)
    }

    private fun showDeleteDialog(notificationKey: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Видалити сповіщення")
        builder.setMessage("Ви впевнені, що хочете видалити це сповіщення?")
        builder.setPositiveButton("Так") { _, _ ->
            deleteNotification(notificationKey)
        }
        builder.setNegativeButton("Ні", null)
        builder.show()
    }

    private fun deleteNotification(notificationKey: String) {
        val userId = auth.currentUser?.uid ?: return
        database.child(userId).child(notificationKey).removeValue()
            .addOnSuccessListener {
                Toast.makeText(this, "Сповіщення видалено", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Не вдалося видалити сповіщення", Toast.LENGTH_SHORT).show()
            }
    }
}