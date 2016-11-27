package agh.cs.lab2_krotkie.lab2;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by agnieszka on 25.11.16.
 */
public abstract class AbstractWorldMap {
    Map<Position,Car> cars = new HashMap<>();

    public List<IMapElement> elements = new ArrayList<>();

    public void run(MoveDirection[] directions)
    {
        int j = 0;
        for(int i = 0 ; i < elements.size() ; i ++)
        {
            if(elements.get(i) instanceof Car)
            {
                elements.get(i).move(directions[j]);
                j++;
            }
        }
    }

    public boolean isOccupied(Position position)
    {
        for(int i = 0; i < elements.size() ; i ++)
        {
            if(elements.get(i).getPosition().equals(position)) {
                throw new IllegalArgumentException(elements.get(i).getPosition().toString());
            }
        }


        return false;
    }

    /**
     * Return object at given position.
     *
     * @param position
     *            The position of the object.
     * @return Object or null if the position is not occupied.
     */
    public Object objectAt(Position position)
    {
        for(int i = 0; i < elements.size(); i ++)
        {
            if(elements.get(i).getPosition().equals(position))
                return elements.get(i).getPosition();

        }

        return null;
    }
}
