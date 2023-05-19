package com.example.ggg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Fibonacci extends AppCompatActivity {
    private EditText numberEditText;
    private Button submitButton;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        numberEditText = findViewById(R.id.number1);
        submitButton = findViewById(R.id.submit);
        answerTextView = findViewById(R.id.answer);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFibonacci();
            }
        });
    }

    private void calculateFibonacci() {
        String input = numberEditText.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        int count = Integer.parseInt(input);

        if (count <= 0) {
            Toast.makeText(this, "Invalid input. Please enter a positive number", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder sequenceString = new StringBuilder();
        sequenceString.append("The Fibonacci sequence of fn for 0 <= n <= ").append(count).append("\n");

        int a = 0;
        int b = 1;
        sequenceString.append(a).append(",  ");
        if (count > 1) {
            sequenceString.append(b).append(", ");
        }

        for (int i = 1; i < count; i++) {
            int c = a + b;
            sequenceString.append(c).append(", ");
            a = b;
            b = c;
        }

        String sequence = removeComma(sequenceString.toString());
        answerTextView.setText(sequence);
    }

    private String removeComma(String sequence) {
        if (sequence.endsWith(", ")) {
            return sequence.substring(0, sequence.length() - 2);
        } else {
            return sequence;
        }
    }
}
