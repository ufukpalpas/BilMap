package com.example.bilmap;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.chrisbanes.photoview.PhotoView;

/**
 * @author Ufuk Palpas
 * @version 02.05.2019
 */
public class smokingallowed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smokingallowed);

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.smokingbanned);
    }
    public void back(View view) {
        finish();
    }



}
