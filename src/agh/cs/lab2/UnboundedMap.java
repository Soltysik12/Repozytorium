package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agnieszka on 25.11.16.
 */
public class UnboundedMap extends AbstractWorldMap implements IWorldMap {

    private List<HayStack> stacks;


    public UnboundedMap(List<HayStack> stacks)
    {
        this.stacks = stacks;
    }

    public boolean canMoveTo(Position position)
    {
        if(!isOccupied(position))
            return true;
        return false;
    }


    public boolean add(Car car)
    {
        if(isOccupied(car.getPosition()))
            throw new IllegalArgumentException(car.getPosition().toString() + "is occupied");
        else cars.put(car.getPosition(), car);
        return true;
    }


    public boolean isOccupied(Position position)
    {

        if(cars.containsKey(position)) return true;

        for(int i = 0; i < stacks.size() ; i ++)
        {
            if(stacks.get(i).getPosition().equals(position)) return true;

        }
        return false;
    }

    public Object objectAt(Position position)
    {
        if(cars.containsKey(position)) return cars.get(position);

        for(int i = 0; i < stacks.size(); i ++)
        {
            if(stacks.get(i).getPosition().equals(position))
                return stacks.get(i);

        }
        return null;
    }

    public String toString()
    {
        int xmin = 0, xmax = 0, ymin = 0, ymax = 0;

        MapVisualizer mapVisualizer = new MapVisualizer();
        for(int i = 0; i < stacks.size() ; i ++)
        {
            Position position = stacks.get(i).getPosition();
            if(position.x > xmax) xmax = position.x;
            else if(position.x < xmin) xmin = position.x;
            if(position.y > ymax) ymax = position.y;
            else if (position.y < ymin) ymin = position.y;

        }
        Position bottomLeft = new Position(xmin, ymin);
        Position upperRight = new Position(xmax, ymax);
        return mapVisualizer.dump(this,bottomLeft,upperRight);


    }
}
