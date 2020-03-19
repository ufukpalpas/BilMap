package com.example.bilmap.navigation_codes;

import android.content.Context;

import java.util.ArrayList;

/**
 * Byilding class with floors
 * @author Melisa Taspinar. Ufuk Palpas
 * @version 19.05.2019
 */
public class Building
{
    private ArrayList<Floor> floors;
    private String           name;
    Context context;
    // Location ?

    public Building( Context context, String name, int startingFloor, int finalFloor)
    {
        this.name = name;
        this.context = context;
        floors = new ArrayList<Floor>();
        // e.g. -1, 0, 1, 2, 3
        for( int i = startingFloor; i < finalFloor; i++ )
        {
            floors.add( new Floor(context, i, this ) );
        }
    }

    /**
     * gets the building's collection of floors
     * @return Floor objects as an ArrayList
     */
    public ArrayList<Floor> getFloors()
    {
        return floors;
    }

    /**
     * @return name of the building
     * e.g. "B" returns "B Building"
     */
    public String toString()
    {
        return name + " Building";
    }

    /**
     * gets the name of the building
     * @return name as a String
     */
    public String getName()
    {
        return name;
    }

    /**
     * gets the Floor with the given floor number
     * @param n floor number
     * @return corresponding Floor object
     */
    public Floor getFloor( int n)
    {
        for ( int i = 0; i < floors.size(); i++ )
        {
            if ( n == floors.get(i).getFloorNumber() )
                return floors.get(i);
        }
        return null;
    }

    /**
     * checks if two buildings are the same by checking their names
     */
    public boolean equals( Building other )
    {
        if ( this.getName().equals( other.getName() ) )
            return true;
        else
            return false;
    }

}