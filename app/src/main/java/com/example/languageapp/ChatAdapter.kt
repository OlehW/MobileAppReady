package com.example.languageapp

import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.database.FirebaseDatabase

class ChatAdapter(
    private val messages: List<ChatMessage>
) : RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userAvatar: ImageView = view.findViewById(R.id.userAvatar)
        val userName: TextView = view.findViewById(R.id.userName)
        val messageText: TextView = view.findViewById(R.id.messageText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]

        holder.userName.text = message.userName
        holder.messageText.text = message.message

        val userDatabase = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference.child("users").child(message.userId).child("avatar")

        userDatabase.get().addOnSuccessListener { snapshot ->
            val avatarBase64 = snapshot.getValue(String::class.java)
            if (!avatarBase64.isNullOrEmpty()) {
                val imageBytes = Base64.decode(avatarBase64, Base64.DEFAULT)
                Glide.with(holder.itemView.context)
                    .load(imageBytes)
                    .circleCrop()
                    .placeholder(R.drawable.ic_user_avatar)
                    .into(holder.userAvatar)
            } else {
                holder.userAvatar.setImageResource(R.drawable.ic_user_avatar)
            }
        }.addOnFailureListener {
            holder.userAvatar.setImageResource(R.drawable.ic_user_avatar)
        }
    }

    override fun getItemCount(): Int = messages.size
}