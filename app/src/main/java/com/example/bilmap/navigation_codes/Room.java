package com.example.bilmap.navigation_codes;

/**
 * class for Rooms inside buildings
 * @author Melisa Taspinar, Ufuk Palpas
 * @version 19.03.2020
 */
public class Room // extends Vertex?
{
    private Floor  floor;
    private Vertex vertex;
    private String name;

    public Room( String name, Floor floor, Vertex vertex)
    {
        this.name = name;
        this.floor = floor;
        this.vertex = vertex;
    }

//   public Room( String name, Floor floor, int x, int y/*, Location loc*/)
//   {
//      super( floor, x, y);
//      this.name = name;
//   }

    /**
     * @return the vertex associated with the room
     */
    public Vertex getVertex()
    {
        return vertex;
    }

    /**
     * @return the official name of the room
     */
    public String toString()
    {
        return name;
    }

    public String getName() { return name; }

}
