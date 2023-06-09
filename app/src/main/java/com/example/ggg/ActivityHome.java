package com.example.ggg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ActivityHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // You can find the views by their IDs
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView groupTextView = findViewById(R.id.groupTextView);
        TextView member1TextView = findViewById(R.id.member1TextView);
        TextView member2TextView = findViewById(R.id.member2TextView);
        TextView member3TextView = findViewById(R.id.member3TextView);

        // Set onClickListener for each button
        Button euclideanButton = findViewById(R.id.euclideanButton);
        euclideanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ChangeMe activity with the appropriate data
                Intent intent = new Intent(ActivityHome.this, Eucledian.class);
                intent.putExtra("buttonName", "Euclidean");
                startActivity(intent);
            }
        });

        Button collatzButton = findViewById(R.id.collatzButton);
        collatzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHome.this, Collatz.class);
                intent.putExtra("buttonName", "Collatz Sequence");
                startActivity(intent);
            }
        });

        Button fibonacciButton = findViewById(R.id.fibonacciButton);
        fibonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHome.this, Fibonacci.class);
                intent.putExtra("buttonName", "Fibonacci Numbers");
                startActivity(intent);
            }
        });

        Button lucasButton = findViewById(R.id.lucasButton);
        lucasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHome.this, Lucas.class);
                intent.putExtra("buttonName", "Lucas Numbers");
                startActivity(intent);
            }
        });

        Button tribonacciButton = findViewById(R.id.tribonacciButton);
        tribonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHome.this, Tribonacci.class);
                intent.putExtra("buttonName", "Tribonacci Numbers");
                startActivity(intent);
            }
        });
    }

}
