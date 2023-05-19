package com.example.ggg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent intent = new Intent(MainActivity.this, Eucledian.class);
                intent.putExtra("buttonName", "Euclidean");
                startActivity(intent);
            }
        });

        Button collatzButton = findViewById(R.id.collatzButton);
        collatzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Collatz.class);
                intent.putExtra("buttonName", "Collatz Sequence");
                startActivity(intent);
            }
        });

        Button fibonacciButton = findViewById(R.id.fibonacciButton);
        fibonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Fibonacci.class);
                intent.putExtra("buttonName", "Fibonacci Numbers");
                startActivity(intent);
            }
        });

        Button lucasButton = findViewById(R.id.lucasButton);
        lucasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lucas.class);
                intent.putExtra("buttonName", "Lucas Numbers");
                startActivity(intent);
            }
        });

        Button tribonacciButton = findViewById(R.id.tribonacciButton);
        tribonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tribonacci.class);
                intent.putExtra("buttonName", "Tribonacci Numbers");
                startActivity(intent);
            }
        });
    }

    // Methods for button clicks (optional)
    public void onEuclideanButtonClick(View view) {
        Toast.makeText(this, "Euclidean button clicked", Toast.LENGTH_SHORT).show();
    }

    public void onCollatzButtonClick(View view) {
        Toast.makeText(this, "Collatz Sequence button clicked", Toast.LENGTH_SHORT).show();
    }

    public void onFibonacciButtonClick(View view) {
        Toast.makeText(this, "Fibonacci Numbers button clicked", Toast.LENGTH_SHORT).show();
    }

    public void onLucasButtonClick(View view) {
        Toast.makeText(this, "Lucas Numbers button clicked", Toast.LENGTH_SHORT).show();
    }

    public void onTribonacciButtonClick(View view) {
        Toast.makeText(this, "Tribonacci Numbers button clicked", Toast.LENGTH_SHORT).show();
    }
}
