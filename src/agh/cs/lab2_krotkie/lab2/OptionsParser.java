package agh.cs.lab2_krotkie.lab2;

/**
 * Created by agnieszka on 23.11.16.
 */
public class OptionsParser {

    public MoveDirection[] parse(String[] args)
    {
        MoveDirection[] directions = new MoveDirection[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("f") || args[i].equals("forward")) {
                directions[i] = MoveDirection.Forward;
            } else if (args[i].equals("b") || args[i].equals("backward")) {
                directions[i] = MoveDirection.Backward;
            } else if (args[i].equals("r") || args[i].equals("right")) {
                directions[i] = MoveDirection.Right;
            } else if (args[i].equals("l") || args[i].equals("left")) {
                directions[i] = MoveDirection.Left;
            }

            else throw new IllegalArgumentException(String.format("%s is not legal move specification", args[i]));
        }
        return directions;
    }
}
