package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agnieszka on 24.11.16.
 */
public class RectangularMap extends AbstractWorldMap implements IWorldMap {

    private int width;
    private int height;
    private final static Position SWBound = new Position(0, 0);

    public RectangularMap(int width, int height)
    {
        this.width = width;
        this.height = height;
    }


    public boolean canMoveTo(Position position)
    {
        if(SWBound.smaller(position) && position.smaller(new Position(this.width - 1, this.height - 1)) && !isOccupied(position))
            return true;

        return false;
    }


    public boolean add(Car car)
    {
        if(!isOccupied(car.getPosition()) && SWBound.smaller(car.getPosition()) && car.getPosition().smaller(new Position(this.width, this.height)))
            cars.put(car.getPosition(), car);
        return false;
    }

    public boolean isOccupied(Position position)
    {
        for(int i = 0; i < cars.size() ; i ++)
        {
            if(cars.get(i).getPosition().equals(position)) return true;
        }
        return false;
    }

    public Object objectAt(Position position)
    {
        for(int i = 0; i < cars.size(); i ++)
        {
            if(cars.get(i).getPosition().equals(position))
                return cars.get(i);

        }
        return null;
    }

    public String toString()
    {
        MapVisualizer mapVisualizer = new MapVisualizer();
        Position bottomLeft = new Position(0,0);
        Position upperRight = new Position(this.width - 1, this.height - 1);
        return mapVisualizer.dump(this ,bottomLeft, upperRight);
    }

}
