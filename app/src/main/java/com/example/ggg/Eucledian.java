package com.example.ggg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Eucledian extends Fragment {

    private EditText number1EditText;
    private EditText number2EditText;
    private LinearLayout solutionLayout, solutionCrad;
    private TextView gcdTextView;
    private TextView lcmSolutionTextView;
    private TextView lcmAnswerTextView;
    private TextView solution;
    private Button submit;

    public static ArrayList<String> solutionList = new ArrayList<>();
    String number1String;
    String number2String;
    View view;


    private StringBuilder stringBuilder;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.activity_eucledian, container, false);

        number1EditText = view.findViewById(R.id.number1);
        number2EditText = view.findViewById(R.id.number2);
        solutionLayout = view.findViewById(R.id.solutionLayout);
        gcdTextView = view.findViewById(R.id.GCD);
        lcmSolutionTextView = view.findViewById(R.id.LCMSOLUTION);
        lcmAnswerTextView = view.findViewById(R.id.LCMANSWER);
        solution= view.findViewById(R.id.solution);
        solutionCrad = view.findViewById(R.id.solutionCrad);
        submit  = view.findViewById(R.id.submit);
        number1String = number1EditText.getText().toString();
        number2String = number2EditText.getText().toString();
        stringBuilder = new StringBuilder();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitClick();
            }
        });


        return view;
    }

    public void onSubmitClick() {
        number1String = number1EditText.getText().toString();
        number2String = number2EditText.getText().toString();
        if (number1String.isEmpty() || number2String.isEmpty()) {
            Toast.makeText(getContext(), "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }else if (number1String.equals("0") && number2String.equals("0")) {
            Toast.makeText(getContext(), "GCD(0,0) is undefined", Toast.LENGTH_SHORT).show();
            return;
        }else {
            int number1 = Integer.parseInt(number1String);
            int number2 = Integer.parseInt(number2String);
            int store = 0;

            if (number2 > number1){
                store = number1;
                number1 =number2;
                number2 = store;
            }



            solution.setText("");
            // Perform your Euclidean calculation here
            int gcd = calculateGCD(number2, number1);
            int lcm = calculateLCM(number1, number2);


            solution.setText(generateSolutionSteps(number1, number2));
            //stringBuilder.setLength(0);


            // Display the result
            gcdTextView.setText("GCD: " + gcd);
            lcmSolutionTextView.setText("LCM Solution: ( " + number1 + " x " + number2 + " )     / " + gcd);
            lcmAnswerTextView.setText("LCM Answer: " + lcm);
            solutionList.clear();

            solutionCrad.setVisibility(View.VISIBLE);
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
