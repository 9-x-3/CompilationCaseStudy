package com.example.ggg;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar main_toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    static String prompt = "Homepage";

    private ImageView info, developers;

     static String titleMath = "Collatz", descriptionMath = "The Collatz sequence is defined as follows:\n" +
             "\n" +
             "1. Start with any positive integer.\n" +
             "2. If the current number is even, divide it by 2.\n" +
             "3. If the current number is odd, multiply it by 3 and add 1.\n" +
             "4. Repeat steps 2 and 3 until the current number becomes 1.\n" +
             "In mathematical notation, the Collatz sequence can be represented by the following recursive function:\n" +
             "\n" +
             "f(n) = {\n" +
             "n/2 if n is even,\n" +
             "3n + 1 if n is odd.\n" +
             "}\n" +
             "\n" +
             "Where:\n" +
             "\n" +
             "f(n) represents the next number in the sequence.\n" +
             "n is the current number in the sequence.\n" +
             "The sequence terminates when the current number reaches 1.";

    BottomSheetDialog infosheet, developersheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of xml
        initXml();
        setSupportActionBar(main_toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, main_toolbar, R.string.open, R.string.close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.drawer_toggle); // Use the custom drawable here
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        //when click info
        info();
        //when click developers
        developers();

        Fragment selectedFragment = new Collatz();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedFragment).commit();

    }

    private void developers() {
        developers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                developersheet = new BottomSheetDialog(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.activity_developers,null,false);


                developersheet.setContentView(view);
                developersheet.show();
            }
        });
    }

    private void info() {
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infosheet = new BottomSheetDialog(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.bottom_sheet_layout,null,false);
                TextView text1 = view.findViewById(R.id.title);
                TextView text2 = view.findViewById(R.id.description);

                text1.setText(titleMath);
                text2.setText(descriptionMath);

                infosheet.setContentView(view);
                infosheet.show();
            }
        });
    }


    public void initXml() {
        main_toolbar = findViewById(R.id.main_toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        info = findViewById(R.id.info);
        developers = findViewById(R.id.developers);
    }



    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment selectedFragment = null;

        switch (item.getItemId()){
            case R.id.collatz:
                titleMath = "Collatz Sequence";
                descriptionMath = "The Collatz sequence is defined as follows:\n" +
                        "\n" +
                        "1. Start with any positive integer.\n" +
                        "2. If the current number is even, divide it by 2.\n" +
                        "3. If the current number is odd, multiply it by 3 and add 1.\n" +
                        "4. Repeat steps 2 and 3 until the current number becomes 1.\n" +
                        "In mathematical notation, the Collatz sequence can be represented by the following recursive function:\n" +
                        "\n" +
                        "f(n) = {\n" +
                        "n/2 if n is even,\n" +
                        "3n + 1 if n is odd.\n" +
                        "}\n" +
                        "\n" +
                        "Where:\n" +
                        "\n" +
                        "f(n) represents the next number in the sequence.\n" +
                        "n is the current number in the sequence.\n" +
                        "The sequence terminates when the current number reaches 1.";
                selectedFragment = new Collatz();
                break;
            case R.id.euclidean:
                selectedFragment = new Eucledian();
                titleMath = "Euclidean Algorithm";
                descriptionMath = "Euclidean numbers do not have a specific definition or formula in mathematics." + "\n" + "\n" +
                        "However, if you were referring to the Euclidean algorithm, it is a method for finding the greatest common divisor (GCD) of two numbers." + "\n" + "\n" +
                        "The algorithm repeatedly divides the larger number by the smaller number and takes the remainder until the remainder is zero.:" + "\n" + "\n" +
                        "The last non-zero remainder obtained is the GCD of the original numbers. The algorithm can be expressed as GCD(a, b) = GCD(b, a mod b).";

                break;
            case R.id.fibonacci:
                titleMath = "Fibonacci Numbers";
                descriptionMath = "Fibonacci numbers form a sequence where each number is the sum of the two preceding ones." + "\n" + "\n" +
                        "It starts with 0 and 1, and subsequent numbers are obtained by adding the previous two." + "\n" + "\n" +
                        "The sequence begins: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ..." + "\n" + "\n" +
                        "The formula is F(n) = F(n-1) + F(n-2), with F(0) = 0 and F(1) = 1." + "\n" + "\n" +
                        "The Fibonacci sequence appears in various fields and exhibits mathematical patterns, including the golden ratio.";

            selectedFragment = new Fibonacci();
            break;
            case R.id.lucas:
                titleMath = "Lucas";
                selectedFragment = new Lucas();
                descriptionMath = "Lucas numbers form a sequence where each number is the sum of the two preceding ones. " + "\n" + "\n" +
                        "It starts with 2 and 1, and subsequent numbers are obtained by adding the previous two." +
                        "The sequence begins: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ..." + "\n" + "\n" +
                        "The formula is L(n) = L(n-1) + L(n-2), with L(0) = 2 and L(1) = 1." + "\n" + "\n" +
                        "Lucas numbers share similarities with Fibonacci numbers and have their own distinct properties and applications in mathematics..";

                break;
            case R.id.tribonacci:
                titleMath = "Tribonacci";
                selectedFragment = new Tribonacci();
                descriptionMath = "Tribonacci numbers are a sequence where each number is the sum of the three preceding ones." + "\n" + "\n" +
                        "It starts with 0, 1, 1, and subsequent numbers are obtained by adding the previous three." +
                        "It starts with 0, 1, 1, and subsequent numbers are obtained by adding the previous three." + "\n" + "\n" +
                        "It starts with 0, 1, 1, and subsequent numbers are obtained by adding the previous three." + "\n" + "\n" +
                        "Tribonacci numbers have their own properties and applications in mathematics.";

                break;

            case R.id.pascual:
                titleMath = "Pascal Triangle";
                selectedFragment = new PascalTriangle();
                descriptionMath = "Pascal's Triangle is a triangular arrangement of numbers, where each number is the sum of the two numbers above it." + "\n" + "\n" +
                "It starts with a row containing 1, and each subsequent row is formed by adding adjacent numbers from the row above." + "\n" + "\n" +
                "The formula is C(n, k) = n! / (k! * (n - k)!), where C(n, k) represents the value at the nth row and kth column." + "\n" + "\n" +
                "Pascal's Triangle has applications in combinatorics, probability, algebra, and number theory.";

                break;

        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}