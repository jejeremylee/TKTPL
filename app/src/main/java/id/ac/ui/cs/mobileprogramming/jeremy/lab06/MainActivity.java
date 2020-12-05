package id.ac.ui.cs.mobileprogramming.jeremy.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("sum-values");
    }

    public native int sumValues(int v1, int v2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText value1 =  findViewById(R.id.value1);
        EditText value2 = findViewById(R.id.value2);

        TextView resultText = findViewById(R.id.result);

        Button addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(v -> {
            resultText.setText(String.valueOf(sumValues(Integer.parseInt(value1.getText().toString()), Integer.parseInt(value2.getText().toString()))));
        });
    }
}