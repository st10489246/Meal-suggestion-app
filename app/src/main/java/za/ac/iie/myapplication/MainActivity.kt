package za.ac.iie.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnOptions = findViewById<Button>(R.id.btnOptions)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val txtResults = findViewById<TextView>(R.id.txtResults)
        val edtTime = findViewById<EditText>(R.id.edtTime)

        //change button's colours from purple to black
        btnOptions.setBackgroundColor(Color.BLACK)
        btnClear.setBackgroundColor(Color.BLACK)

        //give user's meal suggestions
        btnOptions.setOnClickListener {
            val timeOfDay = edtTime.text.toString().trim()

            if (timeOfDay == "morning") {
                txtResults.text = "Breakfast: Pancakes"
            } else if (timeOfDay == "mid-morning") {
                txtResults.text = "Snack: Orange"
            } else if (timeOfDay == "afternoon") {
                txtResults.text = "Lunch: Sandwich"
            } else if (timeOfDay == "mid-afternoon") {
                txtResults.text = "Snack: Apple"
            } else if (timeOfDay == "dinner") {
                txtResults.text = "Dinner: spaghetti"
            } else if (timeOfDay == "after dinner") {
                txtResults.text = "Dessert: Ice Cream"
            } else {
                txtResults.text = "invalid! try entering morning, mid-morning and so on"
            }
        }

        //the reset has to clear the input info the user gives and output results
        btnClear.setOnClickListener {
            edtTime.text.clear()
            txtResults.text = ""
        }













        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}