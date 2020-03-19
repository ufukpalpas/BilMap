package com.example.bilmap.navigation_codes;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to implement the Dijkstra Algorithm
 * With its given static methods,
 * Computes possible paths going through a list of vertices, from a starting vertex
 * Determines which one of these paths is the shortest
 * @author Melisa Taspinar
 * @version 10.05.2019
 */
public class Dijkstra
{
    // no need for properties ||Â constructors

    /**
     * computes all possible paths from a given starting point
     * @param source the starting vertex
     */
    public static void computePaths( Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add( source);

        while ( !vertexQueue.isEmpty() )
        {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for ( Edge e : u.adjacencies )
            {
                Vertex v;
                double weight;
                double distanceThroughU;

                v = e.target;
                weight = e.weight;
                distanceThroughU = u.minDistance + weight;

                if (distanceThroughU < v.minDistance )
                {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        } // end of while
    } // end of computePaths()

    /**
     * the starting point being predetermined,
     * finds the shortest path to a given destination
     * @param target the target vertex, the destination
     * @return the shortest path as a collection of vertices
     */
    public static List<Vertex> getShortestPathTo( Vertex target)
    {
        List<Vertex> path;
        path = new ArrayList<Vertex>();

        for ( Vertex vertex = target; vertex != null; vertex = vertex.previous )
        {
            path.add( vertex);
        }

        Collections.reverse( path);
        return path;
    }


}
