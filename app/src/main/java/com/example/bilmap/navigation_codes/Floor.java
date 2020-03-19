package com.example.bilmap.navigation_codes;

//import android.graphics.Bitmap;
//import android.media.Image;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.widget.ImageView;

import com.example.bilmap.R;
import com.example.bilmap.TestingVertex;

//import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
//import java.awt.image.*;
//import javax.imageio.*;
//import java.io.*;
//import java.awt.*;
import android.graphics.BitmapFactory;

/**
 * @author Ufuk Palpas, Melisa Taspinar
 * @version 19.03.2020
 */
public class Floor
{
    private int                 floorNumber;
    private Building            building;
    ArrayList<UpstairsVertex>   upstairs;
    ArrayList<DownstairsVertex> downstairs;
    Bitmap image;// = TestingVertex.imgview;
    ArrayList<Vertex>           vertices;
    Context context;

    public Floor( int floorNumber, Building building, String imagePath ) // NEVER USED IF YOU USE PLEASE CALL setImage() IN CONSTRUCTOR
    {
        vertices = new ArrayList<Vertex>();
        this.floorNumber = floorNumber;
        this.building = building;
        upstairs = new ArrayList<UpstairsVertex>();
        downstairs = new ArrayList<DownstairsVertex>();
    }

    public Floor(Context context, int floorNumber, Building building )
    {
        vertices = new ArrayList<Vertex>();
        this.floorNumber = floorNumber;
        this.building = building;
        upstairs = new ArrayList<UpstairsVertex>();
        downstairs = new ArrayList<DownstairsVertex>();
        this.context = context;
    }

//    /**
//     *
//     */
//    public static BufferedImage resize(BufferedImage img, int newW, int newH)
//    {
//        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
//        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
//
//        Graphics2D g2d = dimg.createGraphics();
//        g2d.drawImage(tmp, 0, 0, null);
//        g2d.dispose();
//
//        return dimg;
//    }

    /**
     *
     */
    public void setImage( int floor ) // THIS PART CODED FOR ONLY B BUILDING. YOU MUST CHANGE THE CODE COMPLETELY, IF YOU WANT TO ADD NEW BUILDINGS, (Commented parts was for desktop version.)
    {
            if(floor == 0) {
                image = (Bitmap) BitmapFactory.decodeResource(context.getResources(), R.drawable.b_floor_0);//image.setImageResource(R.drawable.b_floor_0);
                image = Bitmap.createScaledBitmap(image, 1141, 600, true);
            }
            if(floor == 1) {
                image = (Bitmap) BitmapFactory.decodeResource(context.getResources(), R.drawable.b_floor_1);//image.setImageResource(R.drawable.b_floor_1);
                image = Bitmap.createScaledBitmap(image, 1148, 600, true);
            }
            if(floor == 2) {
                image = (Bitmap) BitmapFactory.decodeResource(context.getResources(), R.drawable.b_floor_2);//image.setImageResource(R.drawable.b_floor_2);
                image = Bitmap.createScaledBitmap(image, 1150, 600, true);
            }
            if(floor == 3) {
                image = (Bitmap) BitmapFactory.decodeResource(context.getResources(), R.drawable.b_floor_3);//image.setImageResource(R.drawable.b_floor_3);
                image = Bitmap.createScaledBitmap(image, 1152, 600, true);
            }
            if(floor == -1) {
                image = (Bitmap) BitmapFactory.decodeResource(context.getResources(), R.drawable.b_floor__1);//image.setImageResource(R.drawable.b_floor__1);
                image = Bitmap.createScaledBitmap(image, 1054, 600, true);
            }
        //  image = Floor.resize( image, IMAGE_WIDTH, IMAGE_HEIGHT );
    }

    public Bitmap resizeImage(Bitmap image) { // I DECIDED TO CODE THIS METHOD FOR ONLY B BUILDING SO THIS METHOD IS NOT USED ANY MORE.
        //IF YOU WANT TO ADD NEW BUILDINGS PLEASE CHANGE THIS METHOD AND THE METHOD setImage() BECAUSE THAT METHOD MAKES THE THINGS OF THIS METHOD (Normally should be)
       // image = Bitmap.createScaledBitmap(image, 1100, 800, true);
        return image;
    }


    /**
     *
     */
    public int getFloorNumber()
    {
        return floorNumber;
    }

    /**
     *
     */
    public Bitmap getImage()//ImageView getImage()
    {
        return image;
    }

    /**
     *
     */
    public void addUpstairsVertex( UpstairsVertex usv)
    {
        upstairs.add( usv);
    }

    /**
     *
     */
    public void addDownstairsVertex( DownstairsVertex dsv)
    {
        downstairs.add( dsv);
    }

    /**
     *
     */
    public String toString()
    {
        return "Floor " + floorNumber;
    }

    /**
     *
     */
    public Building getBuilding()
    {
        return building;
    }

    /**
     *
     */
    public boolean equals( Floor other )
    {
        if ( this.getFloorNumber() == other.getFloorNumber()
                && this.getBuilding().equals( other.getBuilding() ) )
            return true;
        else
            return false;
    }


    public void addVertex( Vertex v)
    {
        vertices.add( v);
    }

//   public void addVertex( int x, int y)
//   {
//      vertices.add( new Vertex( x, y) );
//   }

//   public void addRoom( Room r)
//   {
//      rooms.add( r);
//   }

}