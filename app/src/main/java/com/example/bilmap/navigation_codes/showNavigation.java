package com.example.bilmap.navigation_codes;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bilmap.R;
import com.example.bilmap.navigation_codes.Vertex;

import java.util.List;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * @author Ufuk Palpas, Melisa Taspinar
 * @version 19.03.2020
 */
public class showNavigation extends View {

        List<Vertex> path;
        Bitmap image = Navigation.image;
        Paint paint = new Paint();

    public showNavigation(Context context) {
                super(context);
                paint.setStrokeWidth(10);
                init(null);
        }

        public showNavigation(Context context, AttributeSet attrs) {
                super(context, attrs);
                paint.setStrokeWidth(10);
                init(attrs);
        }

        public showNavigation(Context context, AttributeSet attrs, int defStyle) {
                super(context, attrs, defStyle);
                paint.setStrokeWidth(10);
                init(attrs);
        }


    public void setPath( List<Vertex> newPath)
        {
                path = newPath;
        }

        private void init(@Nullable AttributeSet set) {
                paint.setColor(Color.BLUE);
        }

        @Override
        public void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            paint.setColor(Color.BLUE);
            canvas.drawBitmap(image, 0, 0, null);
//          canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.OVERLAY);
                //Drawable d = getResources().getDrawable(R.drawable.b_floor_0, null); // I added
                //d.draw(canvas); //I added
                //canvas.drawColor(Color.RED); // ADDED FOR TEST REASONS
                // drawing the route

            for (int i = 0; i < path.size() - 1; i++) {
                canvas.drawLine(path.get(i).getX(), path.get(i).getY()
                , path.get(i + 1).getX(), path.get(i + 1).getY(), paint);
            }
            // drawing the arrows
            for (int i = 0; i < path.size() - 1; i++) {
                 paint.setStrokeWidth(5);
                 paint.setColor(Color.GREEN);
                 Vertex tip = path.get(i + 1);
                 Vertex tail = path.get(i);
                 double phi = Math.toRadians(30);
                 int barb = 15;
                 double dy = tip.getY() - tail.getY();
                 double dx = tip.getX() - tail.getX();
                 double theta = Math.atan2(dy, dx);
                 double x, y, rho = theta + phi;

                 for (int j = 0; j < 2; j++) {
                     x = tip.getX() - barb * Math.cos(rho);
                     y = tip.getY() - barb * Math.sin(rho);
                     canvas.drawLine(tip.getX(), tip.getY(), (int) x, (int) y, paint);
                     rho = theta - phi;
                 }
            }
            // drawing start & end points
            paint.setStrokeWidth(10);
            paint.setColor(Color.RED);
            canvas.drawCircle(path.get(0).getX() - 5, path.get(0).getY() - 5, 10, paint);
            canvas.drawCircle(path.get(path.size() - 1).getX() - 5, path.get(path.size() - 1).getY() - 5, 10, paint);
        }
}