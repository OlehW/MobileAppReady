package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FAQActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqactivity)

        val backButton = findViewById<ImageView>(R.id.backButton)
        val faqContainer = findViewById<LinearLayout>(R.id.faqContainer)

        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navLearn = findViewById<LinearLayout>(R.id.navLearn)
        val navForum = findViewById<LinearLayout>(R.id.navForum)
        val navSettings = findViewById<LinearLayout>(R.id.navSettings)

        val faqList = listOf(
            "Як почати навчання?" to "Виберіть потрібний урок на сторінці навчання у списку модулів або натисніть кнопку 'Продовжити навчання' на головному екрані.",
            "Як змінити свій профіль?" to "Перейдіть у налаштування та оберіть 'Редагувати профіль'. Тут ви можете змінити фото поміняти пароль або видалити аккаунт.",
            "Що робити, якщо я забув пароль?" to "Натисніть 'Забули пароль?' на екрані входу або в налаштуваннях профілю та дотримуйтеся інструкцій.",
            "Як відстежити свій прогрес у навчанні?" to "На головному екрані відображається статистика вивчених уроків, кількість, виконаних розділів шкала прогресу, тощо.",
            "Чи можу я використовувати додаток офлайн?" to "Так, у додатку є можливість завантажувати уроки для офлайн-доступу. Зверніть увагу, щоб зберігався ваш прогрес пройдених розділів чи курсів потрібний доступ до інтернету."
        )

        for ((question, answer) in faqList) {
            addFaqItem(faqContainer, question, answer)
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

    private fun addFaqItem(container: LinearLayout, question: String, answer: String) {
        val inflater = LayoutInflater.from(this)
        val faqItemView = inflater.inflate(R.layout.item_faq, container, false)

        val questionTextView = faqItemView.findViewById<TextView>(R.id.questionText)
        val answerTextView = faqItemView.findViewById<TextView>(R.id.answerText)
        val expandIcon = faqItemView.findViewById<ImageView>(R.id.expandIcon)

        questionTextView.text = question
        answerTextView.text = answer
        answerTextView.visibility = View.GONE

        faqItemView.setOnClickListener {
            if (answerTextView.visibility == View.GONE) {
                answerTextView.visibility = View.VISIBLE
                expandIcon.setImageResource(R.drawable.ic_arrow_up)
            } else {
                answerTextView.visibility = View.GONE
                expandIcon.setImageResource(R.drawable.ic_arrow_down)
            }
        }

        container.addView(faqItemView)
    }
}