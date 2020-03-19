package com.example.bilmap.navigation_codes;


import android.content.Context;

/**
 * Subclass of Vertex, for stairs on a floor that lead to the floor beneath
 * @author Melisa Taspinar
 * @version 10.05.2019
 */
public class DownstairsVertex extends Vertex implements Comparable<Vertex>
{
    Context context;
    public DownstairsVertex( Context context, String name, Floor floor, int x, int y )
    {
        super(context, name, floor, x, y);
        this.context = context;
    }
}