package com.example.lifehackapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val reviewText = findViewById<TextView>(R.id.reviewText)

        val questions = arrayOf(
            "Can Eren Yeager transform into a Titan?",
            "Mikasa Ackerman is Eren's biological sister",
            "Do Titans eat humans?",
            "The Beast Titan is Reiner",
            "The Colossal Titan is extremely small",
            "Levi Ackerman is Eren's uncle",
            "Is Sasha a vegetarian?",
            "Ymir is the Founding Titan",
            "Levi Ackerman is known as humanity's strongest soldier",
            "Is Eren Yeager the villain in the series?"
        )

        val explanations = arrayOf(
            "True: Yes, he can transform into a Titan.",
            "False: She is Eren's close friend, not his biological sister.",
            "True: Yes, they do eat humans.",
            "False: The Beast Titan is Zeke Yeager.",
            "False: The Colossal Titan is massive, not small.",
            "False: No, he is not related to Eren.",
            "False: No, Sasha loves meat.",
            "True: Yes, she was the original Founding Titan.",
            "True: Yes, he is known as humanity's strongest soldier.",
            "True: Yes, he is considered a tragic villain."
        )

        val sb = StringBuilder()
        for (i in questions.indices) {
            sb.append("${i + 1}. ${questions[i]}\n")
            sb.append("${explanations[i]}\n\n")
        }
        reviewText.text = sb.toString()
    }
}
