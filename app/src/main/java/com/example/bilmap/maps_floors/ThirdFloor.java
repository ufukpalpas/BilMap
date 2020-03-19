package com.example.bilmap.maps_floors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bilmap.R;
import com.github.chrisbanes.photoview.PhotoView;

/**
 * @author Ufuk Palpas
 * @version 10.05.2019
 */
public class ThirdFloor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_floor);

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view3);
        photoView.setImageResource(R.drawable.third);

    }
}
