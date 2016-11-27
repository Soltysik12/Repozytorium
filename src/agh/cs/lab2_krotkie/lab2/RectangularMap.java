package agh.cs.lab2_krotkie.lab2;



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



    /**
     * Indicates if any object can move to the given position.
     *
     * @param position
     *            The position checked for the movement possibility.
     * @return True if the object can move to that position.
     */
    public boolean canMoveTo(Position position)
    {
        if(SWBound.smaller(position) && position.smaller(new Position(this.width - 1, this.height - 1)) && !isOccupied(position))
            return true;

        return false;
    }

    /**
     * Add a car the map.
     *
     * @param car
     *            The car to add.
     * @return True if the car was added.
     */
    public boolean add(Car car)
    {
        if(!isOccupied(car.getPosition()) && SWBound.smaller(car.getPosition()) && car.getPosition().smaller(new Position(this.width, this.height)))
            elements.add(car);
        return false;
    }


    public String toString()
    {
        MapVisualizer mapVisualizer = new MapVisualizer();
       Position bottomLeft = new Position(0,0);
        Position upperRight = new Position(this.width - 1, this.height - 1);
        return mapVisualizer.dump(this ,bottomLeft, upperRight);
    }

}
