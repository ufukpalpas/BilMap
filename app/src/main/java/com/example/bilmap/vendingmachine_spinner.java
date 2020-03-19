package com.example.bilmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bilmap.vending_buildings.ah_vending;
import com.example.bilmap.vending_buildings.b_vending;
import com.example.bilmap.vending_buildings.fc_vending;
import com.example.bilmap.vending_buildings.ff_vending;
import com.example.bilmap.vending_buildings.g_vending;
import com.example.bilmap.vending_buildings.lab_vending;
import com.example.bilmap.vending_buildings.library_vending;
import com.example.bilmap.vending_buildings.sab_vending;
import com.example.bilmap.vending_buildings.v_vending;

import java.util.ArrayList;


/**
 * @author Ufuk Palpas
 * @version 03.05.2019
 */
public class vendingmachine_spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendingmachine_spinner);

        Spinner spin = (Spinner) findViewById(R.id.spinner_main);

        list = new ArrayList<String>();
        list.add("Please Select a Building");
        list.add("B Building");
        list.add("SA/SB Building");
        list.add("LA/LB Building");
        list.add("G Building");
        list.add("A/H Building");
        list.add("FC, FA or FD Building");
        list.add("FF Building");
        list.add("V Building");
        list.add("Library");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(vendingmachine_spinner.this,
                android.R.layout.simple_list_item_1, list);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setOnItemSelectedListener(this);

        spin.setAdapter(myAdapter);
    }

    public void onClickButton(View view) {
        Intent intent = new Intent(getApplicationContext(), all_vending_machines.class);
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position == 1) {
            //String item = parent.getItemAtPosition(position).toString();
            //Toast.makeText(parent.getContext(), "Selected: " + item + " Positon: " + position, Toast.LENGTH_LONG).show();
            bBuilding(view);
        }
        if(position == 2)
            sabBuilding(view);
        if(position == 4)
            labBuilding(view);
        if(position == 3)
            gBuilding(view);
        if(position == 5)
            ahBuilding(view);
        if(position == 6)
            fcBuilding(view);
        if(position == 7)
            ffBuilding(view);
        if(position == 8 )
            vBuilding(view);
        if(position == 9)
            libraryBuilding(view);
    }

    public void bBuilding(View view) {
    Intent intent = new Intent(getApplicationContext(), b_vending.class);
    startActivity(intent);
    }

    public void sabBuilding(View view) {
    Intent intent = new Intent(getApplicationContext(), sab_vending.class);
    startActivity(intent);
    }

    public void labBuilding(View view) {
        Intent intent = new Intent(getApplicationContext(), g_vending.class);
        startActivity(intent);
    }

    public void gBuilding(View view) {
        Intent intent = new Intent(getApplicationContext(), lab_vending.class);
        startActivity(intent);
    }

    public void ahBuilding(View view) {
        Intent intent = new Intent(getApplicationContext(), ah_vending.class);
        startActivity(intent);
    }

    public void fcBuilding(View view) {
        Intent intent = new Intent(getApplicationContext(), fc_vending.class);
        startActivity(intent);
    }

    public void ffBuilding(View view) {
        Intent intent = new Intent(getApplicationContext(), ff_vending.class);
        startActivity(intent);
    }

    public void vBuilding(View view) {
        Intent intent = new Intent(getApplicationContext(), v_vending.class);
        startActivity(intent);
    }

    public void libraryBuilding(View view) {
        Intent intent = new Intent(getApplicationContext(), library_vending.class);
        startActivity(intent);
    }





    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
