package agh.cs.lab2;

import java.util.*;

/**
 * Created by agnieszka on 25.11.16.
 */
public abstract class AbstractWorldMap {

    Map<Position,Car> cars = new LinkedHashMap<>();

    public void run(MoveDirection[] directions)
    {
        List<Car> carsList = new ArrayList<>(cars.values());

        for(int i = 0; i < directions.length ; i ++)
        {
            int j = i % carsList.size();
            Position tmp = carsList.get(j).getPosition();
            carsList.get(j).move(directions[i % directions.length]);
            if (!tmp.equals(carsList.get(j).getPosition()))
            {
                cars.remove(tmp);
                cars.put(carsList.get(j).getPosition(), carsList.get(j));
            }

        }
    }
}
