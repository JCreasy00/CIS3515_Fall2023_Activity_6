package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create array of integers that are multiples of 5
        // Verify correctness by examining array values.
        val textSizes = Array(20){(it + 1) * 5}

        Log.d("Array values", textSizes.contentToString())

        with (findViewById(R.id.textSizeSelectorRecyclerView) as RecyclerView) {

            // TODO Step2: Implement lambda body to launch new activity and pass value
            adapter = TextSizeAdapter(textSizes){selectedValue ->
                // Create an Intent to launch a new activity (you should replace NewActivity::class.java with your actual destination activity)
                val launchIntent = Intent(this@MainActivity, DisplayActivity::class.java)

                // Pass the selected value to the new activity using Intent extras
                launchIntent.putExtra("selectedValue", selectedValue)

                // Start the new activity
                context.startActivity(launchIntent)
            }
            layoutManager = LinearLayoutManager(this@MainActivity)
        }



    }
}


/* Convert to RecyclerView.Adapter */
class TextSizeAdapter (private val textSizes: Array<Int>, callback: (Int)->Unit) : RecyclerView.Adapter<TextSizeAdapter.TextSizeViewHolder>() {

    // TODO Step 1: Complete onClickListener to return selected number
    inner class TextSizeViewHolder(val textView: TextView) : RecyclerView.ViewHolder (textView) {
        inner class TextSizeViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {
            init {
                textView.setOnClickListener {
                    val selectedValue = textSizes[adapterPosition] // Get the selected number from the array
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextSizeViewHolder {
        return TextSizeViewHolder(TextView(parent.context).apply { setPadding(5, 20, 0, 20) })
    }

    override fun onBindViewHolder(holder: TextSizeViewHolder, position: Int) {
        holder.textView.apply {
            text = textSizes[position].toString()
            textSize = textSizes[position].toFloat()
        }
    }

    override fun getItemCount(): Int {
        return textSizes.size
    }

}








