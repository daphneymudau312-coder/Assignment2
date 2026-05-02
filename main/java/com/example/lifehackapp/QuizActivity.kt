package com.example.lifehackapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    var index = 0
    var score = 0

    lateinit var questionText: TextView
    lateinit var feedbackText: TextView

    val questions = arrayOf(
        "can Eren yeager transform into a  Titan?",
        "Mikasa Ackerman is Eren's biological sister",
        "do titans eat humans?",
        "the Beast Titan is Reiner",
        "the colossal Titan is extremely small",
        "levi Ackerman is Eren's uncle",
        "is sasha a vegetarian?",
        "ymir is the finding titan",
        "levi Ackerman is known as humanity' strongest soldier",
        "is eren yeager the villain in the series?"
    )

    // Fixed: The answers array now correctly matches the truth of the questions
    val answers = arrayOf(true, false, true, false, false, false, false, true, true, true)

    val explanations = arrayOf(
        "true: yes he can transform into a titan.",
        "false: she is Eren's close friend.",
        "true: yes they do eat humans.",
        "false: the beast Titan is Zeke Yeager",
        "false: the colossal titan is big.",
        "false: no hes not",
        "false: no she is not",
        "true: yes she is the founding titan",
        "true: yes he is known as the humanity strongest soldier",
        "true: yes he is considered as a tragic villain"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)

        val hackButton = findViewById<Button>(R.id.hackButton)
        val mythButton = findViewById<Button>(R.id.mythButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        loadQuestion()

        hackButton.setOnClickListener { checkAnswer(true) }
        mythButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            index++

            if (index < questions.size) {
                loadQuestion()
                feedbackText.text = ""
            } else {
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    fun loadQuestion() {
        questionText.text = questions[index]
    }

    fun checkAnswer(userAnswer: Boolean) {
        // Fixed: Corrected the feedback text logic to match the score increment
        if (userAnswer == answers[index]) {
            feedbackText.text = "Correct! 🎉\n${explanations[index]}"
            score++
        } else {
            feedbackText.text = "Wrong! ❌\n${explanations[index]}"
        }
    }
}
