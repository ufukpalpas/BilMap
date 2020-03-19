package com.example.bilmap;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.chrisbanes.photoview.PhotoView;

/**
 * @author Ufuk Palpas
 * @version 02.05.2019
 */
public class Rings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rings);

        PhotoView photoView = (PhotoView) findViewById(R.id.imageView3);
        photoView.setImageResource(R.drawable.rings);

    }
    public void back(View view) {
        finish();
    }
}
