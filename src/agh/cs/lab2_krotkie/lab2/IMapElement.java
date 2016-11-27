package agh.cs.lab2_krotkie.lab2;



/**
 * Created by agnieszka on 25.11.16.
 */
public interface IMapElement {

    public String toString();

    public Position getPosition();

    public void move(MoveDirection direction);
}
