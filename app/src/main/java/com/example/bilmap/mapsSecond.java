package com.example.bilmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.bilmap.maps_floors.BasementFloor;
import com.example.bilmap.maps_floors.EnteranceFloor;
import com.example.bilmap.maps_floors.FirstFloor;
import com.example.bilmap.maps_floors.SecondFloor;
import com.example.bilmap.maps_floors.ThirdFloor;

import java.util.ArrayList;

/**
 * @author Ufuk Palpas
 * @version 10.05.2019
 */
public class mapsSecond extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_second);
        Spinner spin = (Spinner) findViewById(R.id.spinner2);
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Please Select a Floor");
        list2.add("Basement Floor");
        list2.add("Ground Floor");
        list2.add("First Floor");
        list2.add("Second Floor");
        list2.add("Third Floor");

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(mapsSecond.this,
                android.R.layout.simple_list_item_1, list2);

        // myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setOnItemSelectedListener(this);

        spin.setAdapter(myAdapter2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if ( position == 1){
            basementFloorViewer(view);
        }
        if ( position == 2){
            groundFloorViewer(view);
        }
        if ( position == 3){
            firstFloorViewer(view);
        }
        if ( position == 4){
            secondFloorViewer(view);
        }
        if ( position == 5){
            thirdFloorViewer(view);
        }
    }

    public void basementFloorViewer ( View view ){
        Intent intent = new Intent(getApplicationContext(), BasementFloor.class);
        startActivity(intent);
    }
    public void groundFloorViewer ( View view ){
        Intent intent = new Intent(getApplicationContext(), EnteranceFloor.class);
        startActivity(intent);
    }
    public void firstFloorViewer ( View view ){
        Intent intent = new Intent(getApplicationContext(), FirstFloor.class);
        startActivity(intent);
    }
    public void secondFloorViewer ( View view ){
        Intent intent = new Intent(getApplicationContext(), SecondFloor.class);
        startActivity(intent);
    }
    public void thirdFloorViewer ( View view ){
        Intent intent = new Intent(getApplicationContext(), ThirdFloor.class);
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}