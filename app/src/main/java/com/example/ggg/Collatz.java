package com.example.ggg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Collatz extends Fragment {
    private EditText numberEditText;
    private Button submitButton;

    private LinearLayout final_answer;
    private TextView answerTextView, steps;
    static StringBuilder stepsString = new StringBuilder();
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.activity_collatz, container, false);


        // Find views by their IDs
        numberEditText = view.findViewById(R.id.number1);
        submitButton = view.findViewById(R.id.submit);
        answerTextView = view.findViewById(R.id.answer);
        steps = view.findViewById(R.id.steps);
        final_answer = view.findViewById(R.id.final_answer);

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
                    Toast.makeText(getContext(), "Invalid Output", Toast.LENGTH_SHORT).show();
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
                            stepsString.append(numberEditText.getText().toString()).append(" divided by 2 = ").append(number).append("\n");
                        } else {
                            number = 3 * number + 1;
                            stepsString.append(numberEditText.getText().toString()).append(" * 3 + 1 = ").append(number).append("\n");
                            sequenceString.append(number).append(", ");
                        }


                        final_answer.setVisibility(View.VISIBLE);
                        String answers = sequenceString.toString();
                        String stepsStringConvert = stepsString.toString();
                        answerTextView.setText(answers.substring(0, answers.length() - 2));
                        steps.setText(stepsStringConvert);
                    }
                }
            }
        });
        return view;
    }




}