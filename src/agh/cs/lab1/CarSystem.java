package agh.cs.lab1;

public class CarSystem {

    public static void main(String[] args) {
	    System.out.println("Start");
        run(convert(args));
        System.out.println("Koniec");
    }

     static void run(Direction[] directions){
        System.out.println("Jedziemy do przodu");
        for(Direction argument : directions){
            switch(argument){
                case Forward:
                    System.out.println("Do przodu");
                    break;
                case Backward:
                    System.out.println("Do tyłu");
                    break;
                case Right:
                    System.out.println("Prawo");
                    break;
                case Left:
                    System.out.println("Lewo");
                    break;
                default:
                    break;
            }
        }
    }

    static Direction[] convert(String[] args){
        Direction [] directions = new Direction[args.length];

        for(int i = 0; i < args.length; i++)
            switch (args[i]) {
                case "f":
                    directions[i] = Direction.Forward;
                    break;
                case "b":
                    directions[i] = Direction.Backward;
                    break;
                case "l":
                    directions[i] = Direction.Left;
                    break;
                case "r":
                    directions[i] = Direction.Right;
                    break;
                default:
                    break;
            }
        return directions;
    }
}
