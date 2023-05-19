package com.example.ggg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Collatz extends AppCompatActivity {
    private EditText numberEditText;
    private Button submitButton;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collatz);

        // Find views by their IDs
        numberEditText = findViewById(R.id.number1);
        submitButton = findViewById(R.id.submit);
        answerTextView = findViewById(R.id.answer);

        // Set the submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle submit button click event
                String input = numberEditText.getText().toString();

                if(!input.isEmpty()){
                    onSubmitClick();
                }
            }

            private void onSubmitClick() {
                answerTextView.setText("");
                int number = Integer.parseInt(numberEditText.getText().toString());
                if (number % 2 == 0 || number < 0) {
                    Toast.makeText(Collatz.this, "Invalid Output", Toast.LENGTH_SHORT).show();
                }
                else{
                    StringBuilder sequenceString = new StringBuilder();
                    answerTextView.setText("");

                    sequenceString.append("The Collatz sequence starting from ").append(number).append(" is:\n\n");
                    sequenceString.append(number).append(", ");
                    while (number != 1) {
                        if (number % 2 == 0) {
                            number /= 2;
                            sequenceString.append(number).append(", ");
                        } else {
                            number = 3 * number + 1;
                            sequenceString.append(number).append(", ");
                        }

                        String answers = sequenceString.toString();
                        answerTextView.setText(answers.substring(0, answers.length() - 1));
                    }
                }

            }
        });
    }

}