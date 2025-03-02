package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SettingsActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/").reference

    private lateinit var userAvatar: ImageView
    private lateinit var userName: TextView
    private lateinit var userEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        auth = FirebaseAuth.getInstance()
        val userId = auth.currentUser?.uid ?: return

        userAvatar = findViewById(R.id.userAvatar)
        userName = findViewById(R.id.userName)
        userEmail = findViewById(R.id.userEmail)
        val profileSettings = findViewById<LinearLayout>(R.id.profileSettings)
        val notifications = findViewById<LinearLayout>(R.id.notifications)
        val faq = findViewById<LinearLayout>(R.id.faq)
        val logOut = findViewById<LinearLayout>(R.id.logOut)

        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navLearn = findViewById<LinearLayout>(R.id.navLearn)
        val navForum = findViewById<LinearLayout>(R.id.navForum)
        val navSettings = findViewById<LinearLayout>(R.id.navSettings)

        val iconHome = findViewById<ImageView>(R.id.iconHome)
        val iconLearn = findViewById<ImageView>(R.id.iconLearn)
        val iconForum = findViewById<ImageView>(R.id.iconForum)
        val iconSettings = findViewById<ImageView>(R.id.iconSettings)

        val user = auth.currentUser
        if (user != null) {
            val displayName = user.displayName ?: "User"
            val email = user.email ?: "No email"

            userName.text = displayName
            userEmail.text = email
        }

        loadUserAvatar(userId)
        updateBottomBarColors(iconHome, iconLearn, iconForum, iconSettings)

        profileSettings.setOnClickListener {
            startActivity(Intent(this, ProfileSettingsActivity::class.java))
        }

        notifications.setOnClickListener {
            startActivity(Intent(this, NotificationsActivity::class.java))
        }

        faq.setOnClickListener {
            startActivity(Intent(this, FAQActivity::class.java))
        }

        logOut.setOnClickListener {
            val builder = android.app.AlertDialog.Builder(this)
            builder.setTitle("Вийти з акаунту?")
            builder.setMessage("Ви впевнені, що хочете вийти?")

            builder.setPositiveButton("Так") { _, _ ->
                auth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }

            builder.setNegativeButton("Ні") { dialog, _ ->
                dialog.dismiss()
            }

            builder.show()
        }

        navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        navForum.setOnClickListener {
            startActivity(Intent(this, ForumActivity::class.java))
            finish()
        }

        navLearn.setOnClickListener {
            startActivity(Intent(this, LearnActivity::class.java))
            finish()
        }

        navSettings.setOnClickListener {

        }
    }

    override fun onResume() {
        super.onResume()
        val userId = auth.currentUser?.uid ?: return
        loadUserAvatar(userId)
    }

    private fun loadUserAvatar(userId: String) {
        database.child("users").child(userId).child("avatar").get()
            .addOnSuccessListener { dataSnapshot ->
                val avatarBase64 = dataSnapshot.getValue(String::class.java)
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
                Toast.makeText(this, "Не вдалося завантажити аватар", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateBottomBarColors(iconHome: ImageView, iconLearn: ImageView, iconForum: ImageView, iconSettings: ImageView) {
        iconHome.setColorFilter(resources.getColor(R.color.white))
        iconLearn.setColorFilter(resources.getColor(R.color.white))
        iconForum.setColorFilter(resources.getColor(R.color.white))
        iconSettings.setColorFilter(resources.getColor(R.color.button_yellow))
    }
}