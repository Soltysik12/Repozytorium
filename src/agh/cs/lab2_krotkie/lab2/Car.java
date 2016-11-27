package agh.cs.lab2_krotkie.lab2;


/**
 * Created by agnieszka on 23.11.16.
 */
public class Car implements IMapElement {
    private MapDirection mapDirection = MapDirection.North;
    private Position position;
    private IWorldMap worldMap;

    public Car(IWorldMap map)
    {
        worldMap = map;
        position = new Position(0,0);
    }

    public Car(IWorldMap map, int x, int y)
    {
        worldMap = map;
        position = new Position(x,y);
    }

    public Position getPosition()
    {
        return this.position;
    }

    @Override
    public String toString() {
        return "" + mapDirection;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case Forward:
                run(1);
                break;
            case Backward:
                run(-1);
                break;
            case Right:
                mapDirection = mapDirection.next();
                break;
            case Left:
                mapDirection = mapDirection.previous();
                break;

        }
    }

    public void run(int distance) {
        Position newPosition = new Position(0, 0);
        switch (mapDirection) {
            case North:
                newPosition = position.add(new Position(0, distance));
                break;
            case East:
                newPosition = position.add(new Position(distance, 0));
                break;
            case South:
                newPosition = position.add(new Position(0, -distance));
                break;
            case West:
                newPosition = position.add(new Position(-distance, 0));
                break;
        }
        if (worldMap.canMoveTo(newPosition)) {
            position = newPosition;
        }
        else System.out.println("Samochód " + position + " wyjechał poza mapę");

    }
}
