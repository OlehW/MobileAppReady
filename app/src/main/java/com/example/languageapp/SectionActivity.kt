package com.example.languageapp

import android.app.AlertDialog
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SectionActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView
    private lateinit var lessonTitle: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var contentContainer: FrameLayout
    private lateinit var actionButton: Button

    private var courseId: Int = -1
    private var lessonId: Int = -1
    private var currentStageIndex = 0
    private lateinit var lesson: Lesson

    private var selectedAnswerIndex: Int? = null
    private lateinit var optionsContainer: LinearLayout

    private var multipleSelectedAnswers: MutableList<Int?> = mutableListOf()
    private var multipleOptionsTextViews: MutableList<List<TextView>> = mutableListOf()

    private var answerChecked: Boolean = false

    private lateinit var auth: FirebaseAuth
    private val database = FirebaseDatabase.getInstance("https://languageapp-5a65e-default-rtdb.europe-west1.firebasedatabase.app/").reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section)

        backButton = findViewById(R.id.backButton)
        lessonTitle = findViewById(R.id.lessonTitle)
        progressBar = findViewById(R.id.progressBar)
        contentContainer = findViewById(R.id.contentContainer)
        actionButton = findViewById(R.id.actionButton)

        auth = FirebaseAuth.getInstance()

        courseId = intent.getIntExtra("COURSE_ID", -1)
        lessonId = intent.getIntExtra("LESSON_ID", -1)

        Log.d("SectionActivity", "Отримано COURSE_ID: $courseId, LESSON_ID: $lessonId")

        val selectedCourse = CourseData.courses.find { it.id == courseId }
        lesson = selectedCourse?.lessons?.find { it.id == lessonId } ?: return

        lessonTitle.text = lesson.topic

        progressBar.isIndeterminate = false
        progressBar.max = 100
        progressBar.progress = 0
        progressBar.progressTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.orange))
        progressBar.progressBackgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.white))

        showStage()

        actionButton.setOnClickListener {
            val currentStage = lesson.stages[currentStageIndex]
            when (currentStage) {
                is LessonStage.Quiz -> {
                    if (!answerChecked) {
                        if (selectedAnswerIndex != null) {
                            checkAnswer()
                            answerChecked = true
                            actionButton.text = if (currentStageIndex == lesson.stages.size - 1)
                                "Розділ завершено" else "Перейти"
                        } else {
                            Toast.makeText(this, "Спочатку оберіть відповідь", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        if (currentStageIndex == lesson.stages.size - 1) {
                            showCompletionDialog()
                        } else {
                            nextStage()
                        }
                        answerChecked = false
                    }
                }
                is LessonStage.MultipleQuiz -> {
                    if (!answerChecked) {
                        if (multipleSelectedAnswers.all { it != null }) {
                            checkAnswer()
                            answerChecked = true
                            actionButton.text = if (currentStageIndex == lesson.stages.size - 1)
                                "Розділ завершено" else "Перейти"
                        } else {
                            Toast.makeText(this, "Спочатку оберіть всі відповіді", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        if (currentStageIndex == lesson.stages.size - 1) {
                            showCompletionDialog()
                        } else {
                            nextStage()
                        }
                        answerChecked = false
                    }
                }
                else -> {
                    nextStage()
                }
            }
        }

        backButton.setOnClickListener {
            if (currentStageIndex > 0) {
                currentStageIndex--
                showStage()
            } else {
                showExitConfirmationDialog()
            }
        }

        setupBottomNavigation()
    }

    private fun showStage() {
        contentContainer.removeAllViews()
        val progressPercentage = (currentStageIndex * 100) / lesson.stages.size
        progressBar.setProgress(progressPercentage, true)

        selectedAnswerIndex = null
        answerChecked = false

        when (val stage = lesson.stages[currentStageIndex]) {
            is LessonStage.Content -> {
                val textView = TextView(this)
                textView.text = HtmlCompat.fromHtml(stage.text, HtmlCompat.FROM_HTML_MODE_LEGACY)
                textView.textSize = 16f
                textView.setTextColor(resources.getColor(R.color.white, theme))
                textView.setPadding(16, 16, 16, 16)
                contentContainer.addView(textView)

                actionButton.text = "Перейти"
                actionButton.isEnabled = true
            }
            is LessonStage.Quiz -> {
                val quizContainer = LinearLayout(this)
                quizContainer.orientation = LinearLayout.VERTICAL
                quizContainer.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                quizContainer.setPadding(0, 16, 0, 16)

                val questionView = TextView(this)
                questionView.text = stage.question
                questionView.textSize = 18f
                questionView.setTextColor(resources.getColor(R.color.white, theme))
                questionView.setPadding(0, 0, 0, 24)

                optionsContainer = LinearLayout(this)
                optionsContainer.orientation = LinearLayout.VERTICAL
                optionsContainer.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                stage.options.forEachIndexed { index, option ->
                    val optionView = TextView(this)
                    optionView.text = option
                    optionView.textSize = 16f
                    optionView.setPadding(16, 16, 16, 16)
                    optionView.setBackgroundResource(R.drawable.option_background)
                    optionView.setTextColor(ContextCompat.getColor(this, R.color.black))
                    optionView.setOnClickListener { selectAnswer(index, optionView) }

                    val layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    layoutParams.setMargins(0, 8, 0, 8)
                    optionView.layoutParams = layoutParams

                    optionsContainer.addView(optionView)
                }

                quizContainer.addView(questionView)
                quizContainer.addView(optionsContainer)
                contentContainer.addView(quizContainer)

                actionButton.text = "Перевірити"
                actionButton.isEnabled = true
            }
            is LessonStage.MultipleQuiz -> {
                multipleSelectedAnswers = MutableList(stage.quizzes.size) { null }
                multipleOptionsTextViews = mutableListOf()

                val multiQuizContainer = LinearLayout(this)
                multiQuizContainer.orientation = LinearLayout.VERTICAL
                multiQuizContainer.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                multiQuizContainer.setPadding(0, 16, 0, 16)

                stage.quizzes.forEachIndexed { index, quizBlock ->
                    val quizBlockContainer = LinearLayout(this)
                    quizBlockContainer.orientation = LinearLayout.VERTICAL
                    quizBlockContainer.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    quizBlockContainer.setPadding(0, 16, 0, 16)

                    val questionView = TextView(this)
                    questionView.text = quizBlock.question
                    questionView.textSize = 18f
                    questionView.setTextColor(resources.getColor(R.color.white, theme))
                    questionView.setPadding(0, 0, 0, 8)

                    val optionsLayout = LinearLayout(this)
                    optionsLayout.orientation = LinearLayout.VERTICAL
                    optionsLayout.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                    val optionTextViews = mutableListOf<TextView>()

                    quizBlock.options.forEachIndexed { optionIndex, optionText ->
                        val optionView = TextView(this)
                        optionView.text = optionText
                        optionView.textSize = 16f
                        optionView.setPadding(16, 16, 16, 16)
                        optionView.setBackgroundResource(R.drawable.option_background)
                        optionView.setTextColor(ContextCompat.getColor(this, R.color.black))
                        val lp = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        lp.setMargins(0, 8, 0, 8)
                        optionView.layoutParams = lp

                        optionView.setOnClickListener {
                            optionTextViews.forEach { it.setBackgroundResource(R.drawable.option_background) }
                            multipleSelectedAnswers[index] = optionIndex
                            optionView.setBackgroundResource(R.drawable.option_selected)
                        }

                        optionTextViews.add(optionView)
                        optionsLayout.addView(optionView)
                    }

                    multipleOptionsTextViews.add(optionTextViews)
                    quizBlockContainer.addView(questionView)
                    quizBlockContainer.addView(optionsLayout)
                    multiQuizContainer.addView(quizBlockContainer)
                }

                contentContainer.addView(multiQuizContainer)
                actionButton.text = "Перевірити"
                actionButton.isEnabled = true
            }
        }
    }

    private fun setupBottomNavigation() {
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navLearn = findViewById<LinearLayout>(R.id.navLearn)
        val navForum = findViewById<LinearLayout>(R.id.navForum)
        val navSettings = findViewById<LinearLayout>(R.id.navSettings)

        navHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        navLearn.setOnClickListener {
            val intent = Intent(this, LearnActivity::class.java)
            startActivity(intent)
            finish()
        }

        navForum.setOnClickListener {
            val intent = Intent(this, ForumActivity::class.java)
            startActivity(intent)
            finish()
        }

        navSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun selectAnswer(index: Int, optionView: TextView) {
        for (i in 0 until optionsContainer.childCount) {
            val child = optionsContainer.getChildAt(i) as? TextView
            child?.setBackgroundResource(R.drawable.option_background)
        }
        selectedAnswerIndex = index
        optionView.setBackgroundResource(R.drawable.option_selected)
        actionButton.isEnabled = true
    }

    private fun checkAnswer() {
        when (val stage = lesson.stages[currentStageIndex]) {
            is LessonStage.Quiz -> {
                val correctIndex = stage.correctAnswerIndex
                for (i in 0 until optionsContainer.childCount) {
                    val child = optionsContainer.getChildAt(i) as? TextView
                    if (child != null) {
                        when {
                            i == correctIndex -> child.setBackgroundResource(R.drawable.option_correct)
                            i == selectedAnswerIndex && selectedAnswerIndex != correctIndex -> child.setBackgroundResource(R.drawable.option_wrong)
                        }
                    }
                }
                if (currentStageIndex == lesson.stages.size - 1) {
                    progressBar.setProgress(100, true)
                }
            }
            is LessonStage.MultipleQuiz -> {
                stage.quizzes.forEachIndexed { index, quizBlock ->
                    val correctIndex = quizBlock.correctAnswerIndex
                    val selected = multipleSelectedAnswers[index]
                    multipleOptionsTextViews[index].forEachIndexed { optionIndex, textView ->
                        when {
                            optionIndex == correctIndex -> textView.setBackgroundResource(R.drawable.option_correct)
                            optionIndex == selected && selected != correctIndex -> textView.setBackgroundResource(R.drawable.option_wrong)
                        }
                    }
                }
                if (currentStageIndex == lesson.stages.size - 1) {
                    progressBar.setProgress(100, true)
                }
            }
            else -> {}
        }
    }

    private fun nextStage() {
        if (currentStageIndex < lesson.stages.size - 1) {
            currentStageIndex++
            showStage()
        } else {
            showCompletionDialog()
        }
    }

    private fun showCompletionDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Розділ завершено")
        dialogBuilder.setMessage("Перейти на сторінку розділів курсу?")
        dialogBuilder.setPositiveButton("Так") { _, _ ->
            markLessonCompleted()
        }
        dialogBuilder.setCancelable(false)
        dialogBuilder.show()
    }

    private fun showExitConfirmationDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Залишити розділ?")
        dialogBuilder.setMessage("Ваш прогрес буде втрачено!")
        dialogBuilder.setPositiveButton("Так") { _, _ ->
            finish()
        }
        dialogBuilder.setNegativeButton("Ні") { dialog, _ ->
            dialog.dismiss()
        }
        dialogBuilder.setCancelable(false)
        dialogBuilder.show()
    }

    private fun markLessonCompleted() {
        val userId = auth.currentUser?.uid ?: return
        database.child("users").child(userId)
            .child("coursesProgress")
            .child(courseId.toString())
            .child("completedLessons")
            .child(lessonId.toString())
            .setValue(true)
            .addOnSuccessListener {
                val intent = Intent()
                intent.putExtra("LESSON_ID", lessonId)
                setResult(RESULT_OK, intent)
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Помилка збереження прогресу", Toast.LENGTH_SHORT).show()
            }
    }
}