package agh.cs.lab2_krotkie.lab2;

import java.util.List;

/**
 * Created by agnieszka on 25.11.16.
 */
public class UnboundedMap extends AbstractWorldMap implements IWorldMap {


    public UnboundedMap(List<IMapElement> stacks)
    {
        this.elements = stacks;
    }

    public boolean canMoveTo(Position position)
    {
        if(!isOccupied(position))
            return true;

        return false;
    }


    public boolean add(Car car)
    {
        if(!isOccupied(car.getPosition()))
            elements.add(car);
        return false;
    }


    public String toString()
    {
        int xmin = 0, xmax = 0, ymin = 0, ymax = 0;

       MapVisualizer mapVisualizer = new MapVisualizer();
        for(int i = 0; i < elements.size() ; i ++)
        {
            Position position = elements.get(i).getPosition();
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
