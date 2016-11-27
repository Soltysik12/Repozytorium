package agh.cs.lab2;

/**
 * Created by agnieszka on 25.11.16.
 */
public class HayStack implements IMapElement{

    private Position position;

    public HayStack(Position  position)
    {
        this.position = position;
    }

    public Position getPosition()
    {
        return this.position;
    }

    public String toString()
    {
        return "s";
    }




}
