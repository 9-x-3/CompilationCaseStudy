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
                selectedFragment = new Collatz();
                break;
            case R.id.euclidean:
                selectedFragment = new Eucledian();
                titleMath = "Euclidean Algorithm";

                break;
            case R.id.fibonacci:
                titleMath = "Fibonacci Numbers";

                selectedFragment = new Fibonacci();
                break;
            case R.id.lucas:
                titleMath = "Lucas";
                selectedFragment = new Lucas();
                break;
            case R.id.tribonacci:
                titleMath = "Tribonacci";
                selectedFragment = new Tribonacci();
                break;

            case R.id.pascual:
                titleMath = "Pascal Triangle";
                selectedFragment = new PascalTriangle();
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