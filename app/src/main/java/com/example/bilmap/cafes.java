package com.example.bilmap;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Ufuk Palpas
 * @version 10.05.2019
 */
public class cafes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafes2);
    }
    public void back(View view) {
        finish();
    }
}
