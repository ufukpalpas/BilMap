package com.example.bilmap.navigation_codes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.bilmap.MainActivity;
import com.example.bilmap.R;
import com.example.bilmap.mapsSecond;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;

import android.app.Activity;
import android.graphics.Color;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Ufuk Palpas, Melisa Taspinar
 * @version 19.03.2020
 */
public class Navigation extends AppCompatActivity{

    public static Bitmap image;
    private String answer = "empty";
    private boolean which = false;
    private Floor newFloor;
    private Vertex endPoint1;
    private Vertex startPoint1;
    private Building b;
    private Context context1;
    private TextView tv2;
    private TextView tv;
    private List<Vertex> path;
    private showNavigation showNav;
    private String completePath;
    private RelativeLayout layout;
    private Activity a;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }


    public Navigation(Context context, Room startingRoom, Room endingRoom, Scanner scan) {
        startPoint1 = startingRoom.getVertex();
        endPoint1 = endingRoom.getVertex();
        navigate(context, startPoint1, endPoint1, scan);
    }

    /**
     * draws the shortest possible path on the floor map,
     * given a VERTEX to start from and a VERTEX to end on
     *
     * @param startPoint the starting point of the route
     * @param endPoint   the destination
     * @param scan       the Scanner object for input
     */
    public void navigate(Context context, Vertex startPoint, Vertex endPoint, Scanner scan) {
        context1 = context;
        a = (Activity) context;
        layout = new RelativeLayout(context);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tv = new TextView(context);
        tv2  = new TextView(context);
        btn = new Button(context);
        Button btn2 =new Button(context);
        int closestStairs;
        double minDistance;
        int stairsIndex;
        android.view.ViewGroup.LayoutParams lp = new android.view.ViewGroup.LayoutParams(0xffffffff,150);

        // View things
        tv.setId(R.id.tv1);
        tv2.setId(R.id.tv2);
        btn.setId(R.id.btncont);
        btn2.setId(R.id.btnexit);
        tv.setTextSize(24);
        tv.setTextColor(Color.RED);
        tv2.setTextSize(20);
        tv2.setTextColor(Color.GREEN);
        btn.setText("YES");
        btn2.setText("EXIT");
        RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lparams2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lparams3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lparams4 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lparams.addRule(RelativeLayout.CENTER_IN_PARENT);
        lparams2.addRule(RelativeLayout.CENTER_IN_PARENT);
        lparams3.addRule(RelativeLayout.CENTER_IN_PARENT);
        lparams4.addRule(RelativeLayout.CENTER_IN_PARENT);
        lparams2.addRule(RelativeLayout.BELOW, R.id.tv1);
        lparams3.addRule(RelativeLayout.BELOW, R.id.tv2);
        lparams4.addRule(RelativeLayout.BELOW, R.id.btncont);
        tv.setLayoutParams(lparams);
        tv2.setLayoutParams(lparams2);
        btn.setLayoutParams(lparams3);
        btn2.setLayoutParams(lparams4);
        layout.addView(tv);
        layout.addView(tv2);
        layout.addView(btn);
        layout.addView(btn2);
        a.setContentView(layout, rlp);


        //navigation things
        b = startPoint.getFloor().getBuilding();
        completePath = "";
        Dijkstra.computePaths(startPoint);
        path = Dijkstra.getShortestPathTo(startPoint);
        image = startPoint.getFloor().getImage();
        showNav = new showNavigation(context);//, image);
        showNav.setPath(path);
        layout.addView(showNav);
        a.setContentView(layout, rlp);
        closestStairs = 0;

        //find first location
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
                a.finish(); // Go back to the room selection page
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(which) { // first part
                    newFloor = b.getFloor(startPoint1.getFloor().getFloorNumber() - 1);
                    startPoint1 = newFloor.upstairs.get(0);
                    System.out.println("bastın");
                    recreateAll();
                } else { // else part
                    newFloor = b.getFloor(startPoint1.getFloor().getFloorNumber() + 1);
                    startPoint1 = newFloor.downstairs.get(0);
                    recreateAll();
                }
            }
        });

        // if destination is on another floor (than the current floor)
        if(!startPoint.getFloor().equals(endPoint.getFloor())){
            Dijkstra.computePaths(startPoint);
            // going down
            if (startPoint.getFloor().getFloorNumber() > endPoint.getFloor().getFloorNumber()) {
                which = true;
                path = Dijkstra.getShortestPathTo(startPoint.getFloor().downstairs.get(0)); // only using the main stairs
                completePath = completePath + startPoint.getFloor() + ": " + path + "\n";
                image = startPoint.getFloor().getImage();
                showNav = new showNavigation(context);
                showNav.setPath(path);
                layout.addView(showNav);
                tv.setText("Go downstairs!\n");//System.out.println("Go downstairs"); // input from console to validate floor change
                tv2.setText("Have you gone?\n");
            } // end of if (going down)
            // going up
            else {
                which = false;
                path = Dijkstra.getShortestPathTo(startPoint.getFloor().upstairs.get(0));
                completePath = completePath + startPoint.getFloor() + ": " + path + "\n";
                image = startPoint.getFloor().getImage();
                showNav = new showNavigation(context);
                showNav.setPath(path);
                layout.addView(showNav);
                tv.setText("Go upstrairs!\n");//System.out.println("Go upstairs");
                tv2.setText("Have you Gone?\n");
            } // end of else (going up)
        }

        if (startPoint.getFloor().equals(endPoint.getFloor())) {
            Dijkstra.computePaths(startPoint);
            path = Dijkstra.getShortestPathTo(endPoint);
            completePath = completePath + startPoint.getFloor() + ": " + path + "\n";
            image = startPoint.getFloor().getImage();
            showNav = new showNavigation(context);//, image);
            showNav.setPath(path);
            layout.addView(showNav);
            tv.setText("YOU ARRIVED!!!");
            tv2.setText("");
            btn.setVisibility(View.GONE); // makes the button invisible
        }
        // Distance in mm
        // System.out.println("Distance to " + v_b2_15 + ": " + v_b2_15.minDistance);
    }



    public void recreateAll() {
        if(!startPoint1.getFloor().equals(endPoint1.getFloor())){
            Dijkstra.computePaths(startPoint1);
            // going down
            if (startPoint1.getFloor().getFloorNumber() > endPoint1.getFloor().getFloorNumber()) {
                which = true;
                path = Dijkstra.getShortestPathTo(startPoint1.getFloor().downstairs.get(0)); // only using the main stairs
                completePath = completePath + startPoint1.getFloor() + ": " + path + "\n";

                image = startPoint1.getFloor().getImage();
                showNav = new showNavigation(context1);//, image);
                showNav.setPath(path);
                layout.addView(showNav);
                System.out.println("methoddayım");
                tv.setText("Go downstairs!\n");//System.out.println("Go downstairs"); // input from console to validate floor change
                tv2.setText("Have you gone?\n");
            } // end of if (going down)
            // going up
            else {
                which = false;
                path = Dijkstra.getShortestPathTo(startPoint1.getFloor().upstairs.get(0));
                completePath = completePath + startPoint1.getFloor() + ": " + path + "\n";
                System.out.println("elsedeyim");
                image = startPoint1.getFloor().getImage();
                showNav = new showNavigation(context1);//, image);
                showNav.setPath(path);
                layout.addView(showNav);

                tv.setText("Go upstrairs!\n");//System.out.println("Go upstairs");
                tv2.setText("Have you Gone?\n");
            } // end of else (going up)
        }

        if (startPoint1.getFloor().equals(endPoint1.getFloor())) {
            Dijkstra.computePaths(startPoint1);
            path = Dijkstra.getShortestPathTo(endPoint1);
            completePath = completePath + startPoint1.getFloor() + ": " + path + "\n";
            image = startPoint1.getFloor().getImage();
            showNav = new showNavigation(context1);//, image);
            showNav.setPath(path);
            layout.addView(showNav);
            System.out.println("Complete Path:\n" + completePath); // Vertices need names for this!
            tv.setText("YOU ARRIVED!!!");
            tv2.setText("");
            btn.setVisibility(View.GONE); // makes the button invisible
        }
    }

//    @Override
//    public void onBackPressed() {
//        // Do Here what ever you want do on back press;
//        System.exit(0);
//        a.finish();
//    }
}
