import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.state_quiz_app.R


class MainActivity : AppCompatActivity() {
    private val correctAnswer = "usa-washington+"
    private var totalGuesses = 0
    private var correctAnswers = 0

    // Define a Map to store state-capital pairs
    private val stateCapitalMap = mapOf(
        "washington" to "Olympia"
        // Add more state-capital pairs here
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessButton: Button = findViewById(R.id.submitAnswerButton)
        guessButton.setOnClickListener(guessButtonListener)
    }

    private fun getCountryName(name: String): String {
        return name.substring(name.indexOf('-') + 1, name.indexOf('+')).replace('_', ' ')
    }

    private fun getCapName(name: String): String {
        // Retrieve capital name based on state name from the map
        return stateCapitalMap[name.substring(name.indexOf('-') + 1, name.indexOf('+'))]
            ?: "Unknown" // Default to "Unknown" if capital not found
    }

    private val guessButtonListener =
        View.OnClickListener { v ->
            val guessButton = v as Button
            val guess = guessButton.text.toString()
            val answer = getCountryName(correctAnswer)
            val cap = getCapName(correctAnswer)
            ++totalGuesses

            if (guess.equals(answer, ignoreCase = true)) {
                ++correctAnswers
                val message = "$answer ($cap)!"
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            }
        }
}
