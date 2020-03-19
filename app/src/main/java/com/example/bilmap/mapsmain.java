package com.example.bilmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * @author Ufuk Palpas
 * @version 10.05.2019
 */
public class mapsmain extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapsmain);
        Spinner spin = (Spinner) findViewById(R.id.spinner);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Please Select a Building");
         list.add("B Building");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(mapsmain.this,
                android.R.layout.simple_list_item_1, list);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setOnItemSelectedListener(this);

        spin.setAdapter(myAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 1)
            onClickButton(view);
    }
    public void onClickButton(View view) {
        Intent intent = new Intent(getApplicationContext(), mapsSecond.class);
        startActivity(intent);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}