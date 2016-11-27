package agh.cs.lab2;

/**
 * Created by agnieszka on 22.11.16.
 */
public enum MapDirection {
    North,
    East,
    South,
    West;

    @Override
    public String toString()
    {
        switch(this){
            case North:
                return "N";
            case East:
                return "E";
            case South:
                return "S";
            case West:
                return "W";
        }
        return null;
    }

    public MapDirection next()
    {
        switch(this)
        {
            case North: return East;
            case East: return South;
            case South: return West;
            case West:return  North;
        }
        return null;
    }

    public MapDirection previous()
    {
        switch (this)
        {
            case North: return West;
            case West: return South;
            case South: return East;
            case East: return North;
        }
        return null;
    }


}
