package com.example.bilmap.navigation_codes;

/**
 * class for weighted edges to be used in Dijkstra's algorithm
 * @author Melisa Taspinar
 * @version 10.05.2019
 */
public class Edge
{
    final Vertex target;
    final double weight;

    public Edge( Vertex target, double weight)
    {
        this.target = target;
        this.weight = weight;
    }

    public Vertex getTarget()
    {
        return target;
    }

    public double getWeight()
    {
        return weight;
    }
}
