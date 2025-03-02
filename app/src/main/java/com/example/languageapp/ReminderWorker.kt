package com.example.languageapp

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class ReminderWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val notificationHelper = NotificationHelper(applicationContext)

        val notificationType = inputData.getInt("notification_type", 1)
        val (title, message) = when (notificationType) {
            1 -> "LanguageApp" to "Залишайся на хвилі успіху: один урок на день – і англійська підкориться тобі!"
            2 -> "LanguageApp" to "Новий урок вже чекає на тебе – поглиб свої знання англійської!"
            3 -> "LanguageApp" to "Ти пропустив учорашнє тренування. Повернемось і надолужимо?"
            else -> "LanguageApp" to "Час для нового уроку!"
        }

        notificationHelper.sendNotification(title, message, notificationType)
        saveNotificationToFirebase(message)
        return Result.success()
    }

    private fun saveNotificationToFirebase(message: String) {
        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return
        val database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("notifications")

        val timestamp = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

        val notificationData = mapOf(
            "message" to message,
            "timestamp" to timestamp
        )

        database.child(userId).push().setValue(notificationData)
    }
}