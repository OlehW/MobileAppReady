package com.example.languageapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.InputType
import android.util.Base64
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.io.ByteArrayOutputStream

class ProfileSettingsActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/").reference
    private val PICK_IMAGE_REQUEST = 1

    private lateinit var userAvatar: ImageView
    private lateinit var changeAvatarIcon: ImageView
    private lateinit var userName: TextView
    private lateinit var userEmail: TextView
    private lateinit var changePassword: LinearLayout
    private lateinit var deleteAccount: LinearLayout
    private lateinit var logOut: LinearLayout
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)

        auth = FirebaseAuth.getInstance()
        val userId = auth.currentUser?.uid ?: return

        userAvatar = findViewById(R.id.userAvatar)
        changeAvatarIcon = findViewById(R.id.changeAvatarIcon)
        userName = findViewById(R.id.userName)
        userEmail = findViewById(R.id.userEmail)
        changePassword = findViewById(R.id.changePassword)
        deleteAccount = findViewById(R.id.deleteAccount)
        logOut = findViewById(R.id.logOut)
        backButton = findViewById(R.id.backButton)

        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navLearn = findViewById<LinearLayout>(R.id.navLearn)
        val navForum = findViewById<LinearLayout>(R.id.navForum)
        val navSettings = findViewById<LinearLayout>(R.id.navSettings)

        val user = auth.currentUser
        if (user != null) {
            val displayName = user.displayName ?: "User"
            val email = user.email ?: "No email"
            userName.text = displayName
            userEmail.text = email
        }

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

        changeAvatarIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        changePassword.setOnClickListener {
            showChangePasswordDialog()
        }

        deleteAccount.setOnClickListener {
            showDeleteAccountDialog()
        }

        logOut.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri = data.data
            val inputStream = contentResolver.openInputStream(imageUri!!)
            val bitmap = BitmapFactory.decodeStream(inputStream)

            userAvatar.setImageBitmap(bitmap)
            saveAvatarToFirebase(bitmap)
            setResult(RESULT_OK)
        }
    }

    private fun saveAvatarToFirebase(bitmap: Bitmap) {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        val imageBytes = outputStream.toByteArray()
        val base64String = Base64.encodeToString(imageBytes, Base64.DEFAULT)

        val userId = auth.currentUser?.uid ?: return
        database.child("users").child(userId).child("avatar").setValue(base64String)
            .addOnSuccessListener {
                Toast.makeText(this, "Аватар успішно оновлено", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Не вдалося оновити аватар", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showChangePasswordDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Змінити пароль")
        builder.setMessage("Надіслати код відновлення пароля на вашу електронну пошту?")
        builder.setPositiveButton("Yes") { _, _ ->
            val user = auth.currentUser
            user?.email?.let { email ->
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Лист надісно для відновлення паролю $email", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Не вдалося надіслати лист: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            } ?: run {
                Toast.makeText(this, "З цим акаунтом не пов'язано жодної електронної пошти", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setNegativeButton("No", null)
        builder.show()
    }

    private fun showDeleteAccountDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Видалити аккаунт")
        builder.setMessage("Ви впевнені, що хочете видалити свій обліковий запис? Ця дія не може бути скасована.")
        builder.setPositiveButton("Yes") { _, _ ->
            reauthenticateAndDeleteAccount()
        }
        builder.setNegativeButton("No", null)
        builder.show()
    }

    private fun reauthenticateAndDeleteAccount() {
        val user = auth.currentUser
        if (user == null) {
            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
            return
        }

        val passwordEditText = EditText(this)
        passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        AlertDialog.Builder(this)
            .setTitle("Повторно пройдіть автентифікацію")
            .setMessage("Введіть пароль для підтвердження видалення облікового запису:")
            .setView(passwordEditText)
            .setPositiveButton("Підтвердити") { _, _ ->
                val password = passwordEditText.text.toString()
                if (user.email.isNullOrEmpty()) {
                    Toast.makeText(this, "Email не знайдено для повторної автентифікації", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }

                val credential = EmailAuthProvider.getCredential(user.email!!, password)
                user.reauthenticate(credential)
                    .addOnCompleteListener { authTask ->
                        if (authTask.isSuccessful) {
                            user.delete()
                                .addOnCompleteListener { deleteTask ->
                                    if (deleteTask.isSuccessful) {
                                        Toast.makeText(this, "Обліковий запис успішно видалено", Toast.LENGTH_SHORT).show()
                                        startActivity(Intent(this, LoginActivity::class.java))
                                        finish()
                                    } else {
                                        Toast.makeText(this, "Не вдалося видалити обліковий запис: ${deleteTask.exception?.message}", Toast.LENGTH_SHORT).show()
                                    }
                                }
                        } else {
                            Toast.makeText(this, "Повторна автентифікація не вдалася: ${authTask.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            .setNegativeButton("Скасувати", null)
            .show()
    }
}