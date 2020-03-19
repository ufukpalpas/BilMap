package com.example.bilmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.bilmap.navigation_codes.Building;
import com.example.bilmap.navigation_codes.Dijkstra;
import com.example.bilmap.navigation_codes.DownstairsVertex;
import com.example.bilmap.navigation_codes.Edge;
import com.example.bilmap.navigation_codes.Floor;
import com.example.bilmap.navigation_codes.Navigation;
import com.example.bilmap.navigation_codes.Room;
import com.example.bilmap.navigation_codes.UpstairsVertex;
import com.example.bilmap.navigation_codes.Vertex;
import com.example.bilmap.navigation_codes.showNavigation;

import java.util.List;
import java.util.Scanner;
public class naviApp extends AppCompatActivity { // UNNECESSARY CLAS

//    showNavigation showNav;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_navi_app);
//
//        Scanner scan = new Scanner(System.in);
//        int i = 3;
//
//        Building b = new Building( "B", -1, 5 );
//
//        Floor b3 = b.getFloor( 3 );
//        Floor b2 = b.getFloor( 2 );
//        Floor b1 = b.getFloor( 1 );
//        Floor b0 = b.getFloor( 0 );
//        Floor b_1 = b.getFloor( -1 );
//
//        for( Floor f : b.getFloors() )
//        {
//            f.setImage(i);// you can change this path
//            i--;
//        }
//
//        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//
//
//
//
//
//
//
//
//        // ############################ B BUILDING ##############################
//
//        // - 1st floor *********************************************************
//
//        // defining vertices
//        Vertex v_b_1_1 = new UpstairsVertex("B-1 Upstairs", b_1, 300, 230);
//        b_1.addUpstairsVertex( (UpstairsVertex) v_b_1_1 );
//        Vertex v_b_1_2 = new Vertex("B-1 Elevator", b_1, 360, 220);
//        Vertex v_b_1_3 = new Vertex("-", b_1, 315, 200);
//        Vertex v_b_1_4 = new Vertex("BB10 Lab (2)", b_1, 345, 170);
//        Vertex v_b_1_5 = new Vertex("-", b_1, 270, 180);
//        Vertex v_b_1_6 = new Vertex("BB10 Lab (1)", b_1, 190, 170);
//        Vertex v_b_1_7 = new Vertex("Mozart Cafe", b_1, 188, 190);
//        Vertex v_b_1_8 = new UpstairsVertex("B-1 Backtairs", b_1, 1000, 320);
//        b_1.addUpstairsVertex( (UpstairsVertex) v_b_1_8 );
//        Vertex v_b_1_9 = new Vertex("Back Aisle", b_1, 1000, 365);
//        Vertex v_b_1_10 = new Vertex("Back Aisle", b_1, 455, 365);
//        Vertex v_b_1_11 = new Vertex("-", b_1, 455, 185);
//
//        // setting the edges and their weights
//        v_b_1_1.addAdjacency( new Edge( v_b_1_3, 10));
//        v_b_1_1.addAdjacency( new Edge( v_b_1_5, 15));
//        v_b_1_3.addAdjacency( new Edge( v_b_1_2, 15));
//        v_b_1_3.addAdjacency( new Edge( v_b_1_4, 13));
//        v_b_1_3.addAdjacency( new Edge( v_b_1_5, 15));
//        v_b_1_2.addAdjacency( new Edge( v_b_1_4, 15));
//        v_b_1_4.addAdjacency( new Edge( v_b_1_5, 20));
//        v_b_1_5.addAdjacency( new Edge( v_b_1_6, 23));
//        v_b_1_6.addAdjacency( new Edge( v_b_1_7, 8));
//        v_b_1_8.addAdjacency( new Edge( v_b_1_9, 20));
//        v_b_1_9.addAdjacency( new Edge( v_b_1_10, 120));
//        v_b_1_10.addAdjacency( new Edge( v_b_1_11, 50));
//        v_b_1_11.addAdjacency( new Edge( v_b_1_4, 30));
//
//        // defining rooms
//        Room bb10 = new Room( "BB10 Lab", b1, v_b_1_4);
//        Room mozart = new Room( "Mozart Cafe", b1, v_b_1_7);
//
//
//        // 0th floor ***********************************************************
//
//        // defining vertices
//        Vertex v_b0_1 = new UpstairsVertex("B0 Backstairs", b0, 1085, 350);
//        Vertex v_b0_2 = new DownstairsVertex("B0 Backstairs", b0, 1085, 350);
//        Vertex v_b0_3 = new Vertex("-", b0, 1085, 400);
//        Vertex v_b0_4 = new Vertex("BZ03-BZ04 (2)", b0, 1025, 400);
//        Vertex v_b0_5 = new Vertex("BZ03-BZ04 (1)", b0, 900, 400);
//        Vertex v_b0_6 = new Vertex("BZ02-BZ05 (2)", b0, 855, 400);
//        Vertex v_b0_7 = new Vertex("BZ02-BZ05 (1)", b0, 735, 400);
//        Vertex v_b0_8 = new Vertex("BZ01 (2)", b0, 685, 400);
//        Vertex v_b0_9 = new Vertex("B0 WC", b0, 620, 400);
//        Vertex v_b0_10 = new Vertex("BZ01 (1)", b0, 560, 400);
//        Vertex v_b0_11 = new Vertex("-", b0, 500, 450);
//        Vertex v_b0_12 = new Vertex("BZ Centre", b0, 500, 395);
//        Vertex v_b0_13 = new DownstairsVertex("BZ Downstairs", b0, 450, 375);
//        b0.addDownstairsVertex( (DownstairsVertex) v_b0_13 );
//        Vertex v_b0_14 = new Vertex("BZ Centre", b0, 500, 330);
//        Vertex v_b0_15 = new Vertex("BZ Centre", b0, 500, 215);
//        Vertex v_b0_16 = new Vertex("BZ07 (2)", b0, 525, 195);
//        Vertex v_b0_17 = new Vertex("BZ06", b0, 580, 195);
//        Vertex v_b0_18 = new Vertex("BZ Centre", b0, 415, 302);
//        Vertex v_b0_19 = new Vertex("BZ Elevator", b0, 390, 245);
//        Vertex v_b0_20 = new Vertex("BZ07 (1)", b0, 405, 200);
//        Vertex v_b0_21 = new UpstairsVertex("BZ Upstairs", b0, 320, 245);
//        b0.addUpstairsVertex( (UpstairsVertex) v_b0_21 );
//        Vertex v_b0_22 = new Vertex("BZ Entrance", b0, 295, 195);
//        Vertex v_b0_23 = new Vertex("BZ Entrance", b0, 295, 90);
//        Vertex v_b0_24 = new Vertex("BZ08", b0, 190, 195);
//
//        b0.addUpstairsVertex( (UpstairsVertex) v_b0_1 );
//        b0.addDownstairsVertex( (DownstairsVertex) v_b0_2 );
//
//        // setting the edges and their weights
//        v_b0_1.addAdjacency( new Edge( v_b0_3, 15));
//        v_b0_2.addAdjacency( new Edge( v_b0_3, 15));
//        v_b0_2.addAdjacency( new Edge( v_b0_1, 0));
//        v_b0_3.addAdjacency( new Edge( v_b0_4, 15));
//        v_b0_4.addAdjacency( new Edge( v_b0_5, 28));
//        v_b0_5.addAdjacency( new Edge( v_b0_6, 15));
//        v_b0_6.addAdjacency( new Edge( v_b0_7, 30));
//        v_b0_7.addAdjacency( new Edge( v_b0_8, 15));
//        v_b0_8.addAdjacency( new Edge( v_b0_9, 17));
//        v_b0_9.addAdjacency( new Edge( v_b0_10, 15));
//        v_b0_10.addAdjacency( new Edge( v_b0_12, 20));
//        v_b0_11.addAdjacency( new Edge( v_b0_12, 15));
//        v_b0_12.addAdjacency( new Edge( v_b0_13, 10));
//        v_b0_12.addAdjacency( new Edge( v_b0_14, 14));
//        v_b0_13.addAdjacency( new Edge( v_b0_14, 10));
//        v_b0_14.addAdjacency( new Edge( v_b0_15, 23));
//        v_b0_15.addAdjacency( new Edge( v_b0_16, 10));
//        v_b0_16.addAdjacency( new Edge( v_b0_17, 10));
//        v_b0_15.addAdjacency( new Edge( v_b0_20, 18));
//        v_b0_14.addAdjacency( new Edge( v_b0_18, 15));
//        v_b0_18.addAdjacency( new Edge( v_b0_19, 10));
//        v_b0_19.addAdjacency( new Edge( v_b0_20, 10));
//        v_b0_19.addAdjacency( new Edge( v_b0_21, 15));
//        v_b0_19.addAdjacency( new Edge( v_b0_22, 20));
//        v_b0_21.addAdjacency( new Edge( v_b0_22, 10));
//        v_b0_20.addAdjacency( new Edge( v_b0_22, 20));
//        v_b0_22.addAdjacency( new Edge( v_b0_23, 20));
//        v_b0_22.addAdjacency( new Edge( v_b0_24, 20));
//        v_b0_21.addAdjacency( new Edge( v_b0_24, 25));
//
//        // defining rooms
//        Room bzwc = new Room( "BZ WC", b0, v_b0_9);
//        Room bz01 = new Room( "BZ01", b0, v_b0_10);
//        Room bz02 = new Room( "BZ02", b0, v_b0_7);
//        Room bz03 = new Room( "BZ03", b0, v_b0_5);
//        Room bz04 = new Room( "BZ04", b0, v_b0_5);
//        Room bz05 = new Room( "BZ05", b0, v_b0_7);
//        Room bz06 = new Room( "BZ06", b0, v_b0_17);
//        Room bz07 = new Room( "BZ07", b0, v_b0_20);
//        Room bz08 = new Room( "BZ08", b0, v_b0_24);
//
//
//        // 1st floor ***********************************************************
//
//        // defining vertices
//        Vertex v_b1_1 = new UpstairsVertex("B1 Backstairs", b1, 1090, 350);
//        Vertex v_b1_2 = new DownstairsVertex("B1 Backstairs", b1, 1090, 350);
//        Vertex v_b1_3 = new Vertex("B1 Table", b1, 1090, 400);
//        Vertex v_b1_4 = new Vertex("B 106-107", b1, 1030, 400);
//        Vertex v_b1_5 = new Vertex("B 105-108", b1, 915, 400);
//        Vertex v_b1_6 = new Vertex("B 104-109", b1, 855, 400);
//        Vertex v_b1_7 = new Vertex("B 103-110", b1, 745, 400);
//        Vertex v_b1_8 = new Vertex("B 102", b1, 680, 400);
//        Vertex v_b1_9 = new Vertex("B1 WC", b1, 625, 400);
//        Vertex v_b1_10 = new Vertex("B1 Centre", b1, 500, 390);
//        Vertex v_b1_11 = new DownstairsVertex("B1 Downstairs", b1, 460, 380);
//        b1.addDownstairsVertex( (DownstairsVertex) v_b1_11 );
//        Vertex v_b1_12 = new Vertex("B1 Centre", b1, 500, 326);
//        Vertex v_b1_13 = new Vertex("B1 Centre", b1, 500, 230);
//        Vertex v_b1_14 = new Vertex("B112 (2)", b1, 525, 200);
//        Vertex v_b1_15 = new Vertex("B111", b1, 580, 200);
//        Vertex v_b1_16 = new Vertex("B1 Centre", b1, 420, 310);
//        Vertex v_b1_17 = new Vertex("B1 Elevator", b1, 385, 240);
//        Vertex v_b1_18 = new Vertex("B112 (1)", b1, 415, 195);
//        Vertex v_b1_19 = new Vertex("B113 (2)", b1, 340, 200);
//        Vertex v_b1_20 = new UpstairsVertex("B1 Upstairs", b1, 315, 230);
//        b1.addUpstairsVertex( (UpstairsVertex) v_b1_20 );
//        Vertex v_b1_21 = new Vertex("B113 (1)", b1, 235, 200);
//        Vertex v_b1_22 = new Vertex("B114", b1, 180, 200);
//
//        b1.addUpstairsVertex( (UpstairsVertex) v_b1_1 );
//        b1.addDownstairsVertex( (DownstairsVertex) v_b1_2 );
//
//        // setting the edges and their weights
//        v_b1_1.addAdjacency( new Edge( v_b1_3, 15));
//        v_b1_2.addAdjacency( new Edge( v_b1_3, 15));
//        v_b1_2.addAdjacency( new Edge( v_b1_1, 0));
//        v_b1_3.addAdjacency( new Edge( v_b1_4, 18));
//        v_b1_4.addAdjacency( new Edge( v_b1_5, 28));
//        v_b1_5.addAdjacency( new Edge( v_b1_6, 15));
//        v_b1_6.addAdjacency( new Edge( v_b1_7, 28));
//        v_b1_7.addAdjacency( new Edge( v_b1_8, 15));
//        v_b1_8.addAdjacency( new Edge( v_b1_9, 15));
//        v_b1_9.addAdjacency( new Edge( v_b1_10, 30));
//        v_b1_10.addAdjacency( new Edge( v_b1_11, 15));
//        v_b1_10.addAdjacency( new Edge( v_b1_12, 18));
//        v_b1_12.addAdjacency( new Edge( v_b1_16, 18));
//        v_b1_12.addAdjacency( new Edge( v_b1_13, 25));
//        v_b1_13.addAdjacency( new Edge( v_b1_18, 20));
//        v_b1_13.addAdjacency( new Edge( v_b1_14, 10));
//        v_b1_14.addAdjacency( new Edge( v_b1_18, 25));
//        v_b1_14.addAdjacency( new Edge( v_b1_15, 15));
//        v_b1_16.addAdjacency( new Edge( v_b1_17, 18));
//        v_b1_17.addAdjacency( new Edge( v_b1_18, 15));
//        v_b1_17.addAdjacency( new Edge( v_b1_19, 15));
//        v_b1_18.addAdjacency( new Edge( v_b1_19, 17));
//        v_b1_19.addAdjacency( new Edge( v_b1_20, 10));
//        v_b1_19.addAdjacency( new Edge( v_b1_21, 25));
//        v_b1_20.addAdjacency( new Edge( v_b1_21, 20));
//        v_b1_21.addAdjacency( new Edge( v_b1_22, 15));
//
//        // defining rooms
//        Room b1wc = new Room( "B1 WC", b1, v_b1_9);
//        Room b102 = new Room( "B 102", b1, v_b1_8);
//        Room b103 = new Room( "B 103", b1, v_b1_7);
//        Room b104 = new Room( "B 104", b1, v_b1_6);
//        Room b105 = new Room( "B 105", b1, v_b1_5);
//        Room b106 = new Room( "B 106", b1, v_b1_4);
//        Room b107 = new Room( "B 107", b1, v_b1_4);
//        Room b108 = new Room( "B 108", b1, v_b1_5);
//        Room b109 = new Room( "B 109", b1, v_b1_6);
//        Room b110 = new Room( "B 110", b1, v_b1_7);
//        Room b111 = new Room( "B 111", b1, v_b1_15);
//        Room b112 = new Room( "B 112", b1, v_b1_18);
//        Room b113 = new Room( "B 113", b1, v_b1_21);
//        Room b114 = new Room( "B 114", b1, v_b1_22);
//
//        // 2nd floor ***********************************************************
//
//        // defining vertices
//        Vertex v_b2_1 = new DownstairsVertex("B2 Backstairs", b2, 1090, 350);
//        Vertex v_b2_2 = new UpstairsVertex("B2 Backstairs", b2, 1090, 350);
//        Vertex v_b2_3 = new Vertex("B2 Table ", b2, 1090, 400);
//        Vertex v_b2_4 = new Vertex("B 203-204 (2)", b2, 1030, 400);
//        Vertex v_b2_5 = new Vertex("B 203-204 (1)", b2, 910, 400);
//        Vertex v_b2_6 = new Vertex("B 202-205 (2)", b2, 860, 400);
//        Vertex v_b2_7 = new Vertex("B 202-205 (1)", b2, 735, 400);
//        Vertex v_b2_8 = new Vertex("B201 (2)", b2, 680, 400);
//        Vertex v_b2_9 = new Vertex("B2 WC ", b2, 620, 400);
//        Vertex v_b2_10 = new Vertex("B201 (1) ", b2, 560, 400);
//        Vertex v_b2_11 = new Vertex("B2 Centre", b2, 500, 450);
//        Vertex v_b2_12 = new Vertex("-", b2, 500, 390);
//        Vertex v_b2_13 = new DownstairsVertex("B2 Downstairs", b2, 450, 380);
//        b2.addDownstairsVertex( (DownstairsVertex) v_b2_13 );
//        Vertex v_b2_14 = new Vertex("B2 Centre", b2, 500, 330);
//        Vertex v_b2_15 = new Vertex("B2 Centre", b2, 500, 220);
//        Vertex v_b2_16 = new Vertex("B207", b2, 525, 200);
//        Vertex v_b2_17 = new Vertex("B206", b2, 580, 200);
//        Vertex v_b2_18 = new Vertex("B2 Centre", b2, 410, 300);
//        Vertex v_b2_19 = new Vertex("B2 Elevator", b2, 385, 245);
//        Vertex v_b2_20 = new Vertex("-", b2, 380, 200);
//        Vertex v_b2_21 = new UpstairsVertex("B2 Upstairs ", b2, 315, 230);
//        b2.addUpstairsVertex( (UpstairsVertex) v_b2_21 );
//        Vertex v_b2_22 = new Vertex("-", b2, 200, 200);
//
//        b2.addUpstairsVertex( (UpstairsVertex) v_b2_2 );
//        b2.addDownstairsVertex( (DownstairsVertex) v_b2_1 );
//
//        // setting the edges and their weights
//        v_b2_1.addAdjacency( new Edge( v_b2_3, 10));
//        v_b2_2.addAdjacency( new Edge( v_b2_3, 10));
//        v_b2_2.addAdjacency( new Edge( v_b2_1, 0));
//        v_b2_3.addAdjacency( new Edge( v_b2_4, 15));
//        v_b2_4.addAdjacency( new Edge( v_b2_5, 30));
//        v_b2_5.addAdjacency( new Edge( v_b2_6, 15));
//        v_b2_6.addAdjacency( new Edge( v_b2_7, 30));
//        v_b2_7.addAdjacency( new Edge( v_b2_8, 15));
//        v_b2_8.addAdjacency( new Edge( v_b2_9, 10));
//        v_b2_9.addAdjacency( new Edge( v_b2_10, 15));
//        v_b2_10.addAdjacency( new Edge( v_b2_12, 15));
//        v_b2_11.addAdjacency( new Edge( v_b2_12, 18));
//        v_b2_13.addAdjacency( new Edge( v_b2_12, 10));
//        v_b2_12.addAdjacency( new Edge( v_b2_14, 15));
//        v_b2_14.addAdjacency( new Edge( v_b2_15, 30));
//        v_b2_15.addAdjacency( new Edge( v_b2_16, 10));
//        v_b2_16.addAdjacency( new Edge( v_b2_17, 15));
//        v_b2_15.addAdjacency( new Edge( v_b2_20, 30));
//        v_b2_14.addAdjacency( new Edge( v_b2_18, 20));
//        v_b2_18.addAdjacency( new Edge( v_b2_19, 15));
//        v_b2_19.addAdjacency( new Edge( v_b2_20, 10));
//        v_b2_20.addAdjacency( new Edge( v_b2_21, 17));
//        v_b2_21.addAdjacency( new Edge( v_b2_22, 30));
//
//        // defining rooms
//        Room b201 = new Room( "B 201", b2, v_b2_10);
//        Room b202 = new Room( "B 202", b2, v_b2_7);
//        Room b203 = new Room( "B 203", b2, v_b2_5);
//        Room b204 = new Room( "B 204", b2, v_b2_5);
//        Room b205 = new Room( "B 205", b2, v_b2_7);
//        Room b206 = new Room( "B 206", b2, v_b2_17);
//        Room b207 = new Room( "B 207", b2, v_b2_16);
//        Room b2wc = new Room( "B2 WC", b2, v_b2_9);
//
//        // 3rd floor ***********************************************************
//
//        // defining vertices
//        Vertex v_b3_25 = new DownstairsVertex("B3 Backstairs", b3, 1092, 350);
//        Vertex v_b3_2 = new Vertex("B3 Table", b3, 1092, 400);
//        Vertex v_b3_3 = new Vertex("B 303-304 (2)", b3, 1028, 400);
//        Vertex v_b3_4 = new Vertex("B 303-304 (1)", b3, 918, 400);
//        Vertex v_b3_5 = new Vertex("B 302-305 (2)", b3, 856, 400);
//        Vertex v_b3_6 = new Vertex("B 302-305 (1)", b3, 742, 400);
//        Vertex v_b3_7 = new Vertex("B 301 (2)", b3, 686, 400);
//        Vertex v_b3_8 = new Vertex("B3 WC", b3, 625, 400);
//        Vertex v_b3_9 = new Vertex("B 301 (1)", b3, 565, 400);
//        Vertex v_b3_10 = new Vertex("B3 Centre", b3, 500, 400);
//        Vertex v_b3_11 = new Vertex("-", b3, 500, 450);
//        Vertex v_b3_12 = new DownstairsVertex("B3 Downstairs", b3, 460, 380);
//        b3.addDownstairsVertex( (DownstairsVertex) v_b3_12 );
//        Vertex v_b3_13 = new Vertex("B3 Centre", b3, 500, 320);
//        Vertex v_b3_14 = new Vertex("B3 Centre", b3, 500, 215);
//        Vertex v_b3_15 = new Vertex("B 307 (2)", b3, 520, 195);
//        Vertex v_b3_16 = new Vertex("B 306", b3, 585, 195);
//        Vertex v_b3_17 = new Vertex("B3 Centre", b3, 465, 315);
//        Vertex v_b3_18 = new Vertex("B3 Centre", b3, 405, 295);
//        Vertex v_b3_19 = new Vertex("B3 Elevator", b3, 385, 240);
//        Vertex v_b3_20 = new Vertex("B 307 (1)", b3, 410, 200);
//        Vertex v_b3_21 = new Vertex("-", b3, 350, 200);
//        Vertex v_b3_23 = new Vertex("-", b3, 240, 195);
//        Vertex v_b3_24 = new Vertex("-", b3, 185, 185);
//
//        b3.addDownstairsVertex( (DownstairsVertex) v_b3_25 );
//
//        // setting the edges and their weights
//        v_b3_25.addAdjacency( new Edge( v_b3_2, 10));
//        v_b3_2.addAdjacency( new Edge( v_b3_3, 17));
//        v_b3_3.addAdjacency( new Edge( v_b3_4, 28));
//        v_b3_4.addAdjacency( new Edge( v_b3_5, 15));
//        v_b3_5.addAdjacency( new Edge( v_b3_6, 30));
//        v_b3_6.addAdjacency( new Edge( v_b3_7, 15));
//        v_b3_7.addAdjacency( new Edge( v_b3_8, 15));
//        v_b3_8.addAdjacency( new Edge( v_b3_9, 15));
//        v_b3_9.addAdjacency( new Edge( v_b3_10, 18));
//        v_b3_10.addAdjacency( new Edge( v_b3_11, 13));
//        v_b3_10.addAdjacency( new Edge( v_b3_12, 10));
//        v_b3_10.addAdjacency( new Edge( v_b3_13, 20));
//        v_b3_12.addAdjacency( new Edge( v_b3_13, 18));
//        v_b3_13.addAdjacency( new Edge( v_b3_14, 25));
//        v_b3_14.addAdjacency( new Edge( v_b3_15, 10));
//        v_b3_14.addAdjacency( new Edge( v_b3_20, 20));
//        v_b3_15.addAdjacency( new Edge( v_b3_16, 15));
//        v_b3_13.addAdjacency( new Edge( v_b3_17, 8));
//        v_b3_17.addAdjacency( new Edge( v_b3_18, 15));
//        v_b3_18.addAdjacency( new Edge( v_b3_19, 15));
//        v_b3_19.addAdjacency( new Edge( v_b3_20, 15));
//        v_b3_20.addAdjacency( new Edge( v_b3_14, 23));
//        v_b3_19.addAdjacency( new Edge( v_b3_21, 15));
//        v_b3_20.addAdjacency( new Edge( v_b3_21, 15));
//        v_b3_23.addAdjacency( new Edge( v_b3_24, 12));
//
//        // defining rooms
//        Room b301 = new Room( "B 301", b3, v_b3_9);
//        Room b302 = new Room( "B 302", b3, v_b3_6);
//        Room b303 = new Room( "B 303", b3, v_b3_4);
//        Room b304 = new Room( "B 304", b3, v_b3_4);
//        Room b305 = new Room( "B 305", b3, v_b3_6);
//        Room b306 = new Room( "B 306", b3, v_b3_16);
//        Room b307 = new Room( "B 307", b3, v_b3_20);
//        Room b3wc = new Room( "B3 WC", b3, v_b3_8);
//
//        List<Vertex> path;
//        Vertex startPoint = v_b1_1;
//        Vertex endPoint = v_b1_11;
//        Dijkstra.computePaths( startPoint);
//        path = Dijkstra.getShortestPathTo( endPoint);
//
//
//        showNav = new showNavigation( this);
//        showNav.setPath( path); // burada hesapladığımız bir path'i koyalım buraya
//        showNav.setBackgroundColor(Color.WHITE);
//        setContentView(showNav);
//
//        // ######################### END OF B BUILDING ##########################
//
//
//        View view = this.findViewById(android.R.id.content);
//
//        Context context = view.getContext();
//
//
//
//        // -------------------+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//
//        Navigation.navigate(context, b205, mozart, scan);
//        // Navigation.navigate( v_b3_18, v_b1_21, scan);
//        System.out.println(v_b3_4.computeDistance(v_b3_21) );
//        System.out.println(v_b3_4.findClosestVertex() );
//
//
//
//    }
}
