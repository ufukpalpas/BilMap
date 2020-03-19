package com.example.bilmap.maps_floors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bilmap.R;
import com.github.chrisbanes.photoview.PhotoView;

// License for zoom option  
/*
Copyright 2019 Chris Banes

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License
*/

/**
 * @author Ufuk Palpas
 * @version 10.05.2019
 */
public class SecondFloor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_floor);

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view4);
        photoView.setImageResource(R.drawable.kat2);
    }
}
