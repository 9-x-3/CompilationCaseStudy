package com.example.ggg;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Eucledian extends AppCompatActivity {

    private EditText number1EditText;
    private EditText number2EditText;
    private LinearLayout solutionLayout;
    private TextView gcdTextView;
    private TextView lcmSolutionTextView;
    private TextView lcmAnswerTextView;
    private TextView solution;
    public static ArrayList<String> solutionList = new ArrayList<>();
    String number1String;
    String number2String;
    private StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eucledian);

        number1EditText = findViewById(R.id.number1);
        number2EditText = findViewById(R.id.number2);
        solutionLayout = findViewById(R.id.solutionLayout);
        gcdTextView = findViewById(R.id.GCD);
        lcmSolutionTextView = findViewById(R.id.LCMSOLUTION);
        lcmAnswerTextView = findViewById(R.id.LCMANSWER);
        solution= findViewById(R.id.solution);
        number1String = number1EditText.getText().toString();
        number2String = number2EditText.getText().toString();
        stringBuilder = new StringBuilder();
    }

    public void onSubmitClick(View view) {
        number1String = number1EditText.getText().toString();
        number2String = number2EditText.getText().toString();
        if (number1String.isEmpty() || number2String.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }else if (number1String.equals("0") && number2String.equals("0")) {
            Toast.makeText(this, "GCD(0,0) is undefined", Toast.LENGTH_SHORT).show();
            return;
        }else{
            int number1 = Integer.parseInt(number1String);
            int number2 = Integer.parseInt(number2String);

            solution.setText("");
            // Perform your Euclidean calculation here
            int gcd = calculateGCD(number1, number2);
            int lcm = calculateLCM(number1, number2);


            solution.setText(generateSolutionSteps(number1, number2));
            //stringBuilder.setLength(0);


            // Display the result
            gcdTextView.setText("GCD: " + gcd);
            lcmSolutionTextView.setText("LCM Solution: ( " + number1 + " x " + number2 + " )     / " + gcd);
            lcmAnswerTextView.setText("LCM Answer: " + lcm);
            solutionList.clear();

            solutionLayout.setVisibility(View.VISIBLE);
        }


    }

    private int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculateGCD(b, a % b);
        }
    }

    private String generateSolutionSteps(int a, int b) {
        StringBuilder steps = new StringBuilder();
        int q, r;
        do {
            q = a / b;
            r = a % b;
            steps.append(a).append(" = ").append(b).append("(").append(q).append(") + ").append(r).append("\n");
            a = b;
            b = r;
        } while (r != 0);

        return steps.toString();
    }

    private int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }
}
