package com.example.state_quiz_app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val correctAnswer = "usa-washington+"
    private var totalGuesses = 0
    private var correctAnswers = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val guessButton: Button = findViewById(R.id.submitAnswerButton)
        guessButton.setOnClickListener(guessButtonListener)
    }

    private fun getCountryName(name: String): String {
        return name.substring(name.indexOf('-') + 1, name.indexOf('+')).replace('_', ' ')
    }

    private fun getCapName(name: String): String {
        // Your code for getting capital name here
        return "" // Placeholder return, replace with actual implementation
    }

    private val guessButtonListener =
        View.OnClickListener { v ->
            val guessButton = v as Button
            val guess = guessButton.getText().toString()
            val answer = getCountryName(correctAnswer)
            val cap = getCapName(correctAnswer)
            ++totalGuesses // increment number of guesses the user has made
            if (guess == answer) { // if the guess is correct
                ++correctAnswers // increment the number of correct answers
                // Display correct answer with the capital name in green text
                val message = "$answer ($cap)!"
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            }
        }
}
