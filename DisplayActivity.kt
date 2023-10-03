package edu.temple.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // TODO Step 3: Extract transferred value and use for lyricsDisplayView text size
        with (findViewById<TextView>(R.id.lyricsDisplayTextView)) {
            // Retrieve the transferred value from the Intent extras
            val selectedValue = intent.getIntExtra("selectedValue", 0)

            // Set the text size of lyricsDisplayTextView using the selectedValue
            textSize = selectedValue.toFloat() // Convert the value to a float for text size
        }


    }
}