package com.example.bilmap;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Ufuk Palpas
 * @version 10.05.2019
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rings(View view) {
        Intent intent = new Intent(getApplicationContext(), Rings.class);
        startActivity(intent);
    }

    public void cafes(View view) {
        Intent intent = new Intent(getApplicationContext(), cafes.class);
        startActivity(intent);
    }

    public void smokingAllowed(View view) {
        Intent intent = new Intent(getApplicationContext(), smokingallowed.class);
        startActivity(intent);
    }

    public void vendingmachine_Spinner(View view) {
        Intent intent = new Intent(getApplicationContext(), vendingmachine_spinner.class);
        startActivity(intent);
    }

    public void maps(View view) {
        Intent intent = new Intent(getApplicationContext(), mapsmain.class);
        startActivity(intent);
    }

    public void navigator(View view) {
        Intent intent = new Intent(getApplicationContext(), navigation_main.class);
        startActivity(intent);
    }

}
