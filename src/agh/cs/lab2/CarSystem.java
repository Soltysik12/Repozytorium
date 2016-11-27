package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agnieszka on 22.11.16.
 */
public class CarSystem {

    public static void main(String[] args) {
        try {

            MoveDirection[] directions = new OptionsParser().parse(args);
            List<HayStack> stacks = new ArrayList<>();
            stacks.add(new HayStack(new Position(-4, -4)));
            stacks.add(new HayStack(new Position(7, 7)));
            stacks.add(new HayStack(new Position(7, 7)));
            stacks.add(new HayStack(new Position(3, 6)));
            stacks.add(new HayStack(new Position(2, 0)));

            IWorldMap map = new UnboundedMap(stacks);
            map.add(new Car(map));
            map.add(new Car(map, 3, 4));
            map.run(directions);
            System.out.println(map.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
