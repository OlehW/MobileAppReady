package com.example.languageapp

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ForumAdapter(
    private val context: Context,
    private var topics: List<ForumTopic>,
    private val onTopicClick: (ForumTopic) -> Unit,
    private val onDeleteClick: (ForumTopic) -> Unit
) : RecyclerView.Adapter<ForumAdapter.TopicViewHolder>() {

    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/").reference

    class TopicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userAvatar: ImageView = view.findViewById(R.id.userAvatar)
        val userName: TextView = view.findViewById(R.id.userName)
        val topicTitle: TextView = view.findViewById(R.id.topicTitle)
        val topicTime: TextView = view.findViewById(R.id.topicTime)
        val btnDeleteTopic: TextView = view.findViewById(R.id.btnDeleteTopic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_forum_topic, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topics[position]

        holder.userName.text = topic.userName
        holder.topicTitle.text = topic.title
        holder.topicTime.text = formatTime(topic.timestamp)

        database.child("users").child(topic.userId).child("avatar").get()
            .addOnSuccessListener { snapshot ->
                val avatarBase64 = snapshot.getValue(String::class.java)
                if (!avatarBase64.isNullOrEmpty()) {
                    val imageBytes = Base64.decode(avatarBase64, Base64.DEFAULT)
                    Glide.with(context)
                        .load(imageBytes)
                        .circleCrop()
                        .placeholder(R.drawable.ic_user_avatar)
                        .into(holder.userAvatar)
                } else {
                    holder.userAvatar.setImageResource(R.drawable.ic_user_avatar)
                }
            }
            .addOnFailureListener {
                holder.userAvatar.setImageResource(R.drawable.ic_user_avatar)
            }

        val currentUser = auth.currentUser
        if (currentUser != null && currentUser.uid == topic.userId) {
            holder.btnDeleteTopic.visibility = View.VISIBLE
        } else {
            holder.btnDeleteTopic.visibility = View.GONE
        }

        holder.btnDeleteTopic.setOnClickListener {
            showDeleteConfirmationDialog(topic)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, TopicActivity::class.java)
            intent.putExtra("TOPIC_ID", topic.id)
            intent.putExtra("TOPIC_TITLE", topic.title)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = topics.size

    private fun showDeleteConfirmationDialog(topic: ForumTopic) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Видалити тему?")
        builder.setMessage("Ви впевнені, що хочете видалити цю тему? Ця дія неможливо скасувати.")
        builder.setPositiveButton("Так") { _, _ ->
            deleteTopic(topic)
        }
        builder.setNegativeButton("Ні", null)
        builder.show()
    }

    private fun deleteTopic(topic: ForumTopic) {
        database.child("forumTopics").child(topic.id).removeValue()
            .addOnSuccessListener {
                database.child("forumMessages").child(topic.id).removeValue()
                    .addOnSuccessListener {
                        Toast.makeText(context, "Тему видалено", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(context, "Помилка видалення повідомлень", Toast.LENGTH_SHORT).show()
                    }
            }
            .addOnFailureListener {
                Toast.makeText(context, "Помилка видалення теми", Toast.LENGTH_SHORT).show()
            }
    }

    private fun formatTime(timestamp: Long): String {
        val timeDiff = System.currentTimeMillis() - timestamp
        val minutes = timeDiff / (1000 * 60)

        return when {
            minutes < 60 -> "$minutes хв назад"
            minutes < 1440 -> "${minutes / 60} год назад" // Менше 24 годин
            minutes < 43200 -> "${minutes / 1440} дн назад" // Менше 30 днів
            minutes < 525600 -> "${minutes / 43200} міс назад" // Менше року
            else -> "${minutes / 525600} рік назад" // Більше року
        }
    }

    fun updateTopics(newTopics: List<ForumTopic>) {
        topics = newTopics
        notifyDataSetChanged()
    }
}