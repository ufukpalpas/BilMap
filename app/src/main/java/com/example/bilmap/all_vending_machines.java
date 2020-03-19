package com.example.bilmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

/**
 * @author Ufuk Palpas
 * @version 05.05.2019
 */
public class all_vending_machines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_vending_machines);
    }

    public void back(View view) {
        finish();
    }
}
