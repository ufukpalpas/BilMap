package com.example.bilmap.navigation_codes;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Integer;



/**
 * Vertex class to be used in Dijkstra's algorithm
 * and to determine the valid points to be used for paths
 * @author Melisa Taspinar, Ufuk Palpas
 * @version 19.03.2020
 */
public class Vertex implements Comparable<Vertex>
{
    public double minDistance = Double.POSITIVE_INFINITY;

    ArrayList<Edge> adjacencies;
    Vertex          previous;
    private int             x;
    private int             y;
    private String          name;
    private Floor           floor;
    private Context context;

    // sizes of the floor map images used while determining vertex coordinates
    private int[] originalImageWidths = {1054, 1141, 1148, 1150, 1152};
    private int[] originalImageHeights = {600, 600, 600, 600, 600};

    public Vertex(Context context, String name, Floor floor, int x, int y )
    {
        this.context = context;
        this.name = name;
        this.floor = floor;
        this.x = x;
        this.y = y;
        adjacencies = new ArrayList<Edge>();
        floor.addVertex( this );
    }

//    public Vertex( int x, int y )
//    {
//       this.x = x;
//       this.y = y;
//       adjacencies = new ArrayList<Edge>();
//    }

    /**
     * computes the Euclidian distance between two vertices
     * from positions on the map image
     */
    public double computeDistance( Vertex other)
    {
        if ( getFloor().equals( other.getFloor() ) )
        {
            return Math.sqrt( (other.getY() - getY()) * (other.getY() - getY())
                    + (other.getX() - getX()) * (other.getX() - getX()) );
        }
        else // if on different floors
            return Integer.MAX_VALUE;
    }

    /**
     * checks x, y values and floor
     */
    public boolean equals( Vertex other)
    {
        return (getX() == other.getX()) && (getY() == other.getY())
                && (getFloor().equals(other.getFloor()));
    }

    /**
     * finds the closest vertex on the same floor to a given vertex
     */
    public Vertex findClosestVertex()
    {
        Floor f = getFloor();
        Vertex closest;
        double minDistance;

        closest = f.vertices.get(0);
        minDistance = computeDistance(closest);
        for ( int i = 1; i < f.vertices.size(); i++ )
        {
            if ( ! f.vertices.get(i).equals( this ) // so as to not count itself
                    && computeDistance( f.vertices.get(i) ) < minDistance )
            {
                closest = f.vertices.get(i);
                minDistance = computeDistance( f.vertices.get(i) );
            }
        }
        return closest;
    }



    /**
     * @return the given name of the vertex
     */
    public String toString()
    {
        return name;
    }

    /**
     * @return the Floor on which the vertex is located
     */
    public Floor getFloor()
    {
        return floor;
    }

    /**
     * @return the y value depending on the height of the image of the used floor map
     */
    public int getY()
    {
        Drawable d = new BitmapDrawable(context.getResources(), floor.getImage());
        int height = d.getIntrinsicHeight();
        return height / originalImageHeights[ floor.getFloorNumber() - floor.getBuilding().getFloors().get(0).getFloorNumber() ] * y;//floor.getImage().getHeight() / originalImageHeights[ floor.getFloorNumber() - floor.getBuilding().getFloors().get(0).getFloorNumber() ] * y;
    }

    /**
     * @return the x value depending on the height of the image of the used floor map
     */
    public int getX()
    {
        Drawable d = new BitmapDrawable(context.getResources(), floor.getImage());
        int width = d.getIntrinsicWidth();
        return width / originalImageWidths[ floor.getFloorNumber() - floor.getBuilding().getFloors().get(0).getFloorNumber() ] * x;//floor.getImage().getWidth() / originalImageWidths[ floor.getFloorNumber() - floor.getBuilding().getFloors().get(0).getFloorNumber() ] * x;
    }

    /**
     * compares distances by calling Double's compare method
     */
    public int compareTo( Vertex other)
    {
        return Double.compare( minDistance, other.minDistance );
    }

    /**
     * (upd) adds adjacency -edge- to a vertex and ensures that the same edge
     * is valid for both of the vertices it connects
     */
    public void addAdjacency( Edge edge)
    {
        adjacencies.add( edge);
        edge.getTarget().adjacencies.add( new Edge( this, edge.getWeight() ) );
    }

}
