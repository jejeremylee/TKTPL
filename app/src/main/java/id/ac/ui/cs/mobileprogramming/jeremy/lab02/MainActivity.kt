package id.ac.ui.cs.mobileprogramming.jeremy.lab02

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        value.setText("" + counter)

        plusBtn.setOnClickListener {
            value.setText("" + ++counter)
        }

        minusBtn.setOnClickListener {
            value.setText("" + --counter)
        }

        if (counter == 10){
            onTen()
        }
    }

    private fun onTen(){
        val counterText: TextView = findViewById(R.id.counterText)
        counterText.text = counterTextMessage()
    }
    fun counterTextMessage(): String{
        return "You made it to 10!"
    }

}