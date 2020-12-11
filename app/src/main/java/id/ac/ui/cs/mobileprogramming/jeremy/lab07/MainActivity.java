package id.ac.ui.cs.mobileprogramming.jeremy.lab07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button increaseButton = findViewById(R.id.button);
        TextView counter = findViewById(R.id.counter);

        increaseButton.setOnClickListener(v ->{
            count+=1;
            counter.setText(Integer.toString(count));
        });
    }
}