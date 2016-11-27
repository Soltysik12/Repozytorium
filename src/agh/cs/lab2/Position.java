package agh.cs.lab2;

/**
 * Created by agnieszka on 22.11.16.
 */
public class Position {

    public final int x;
    public final int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }

    @Override
    public String toString()
    {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean smaller(Position other)
    {
        if (this.x <= other.x && this.y <= other.y) return true;
        else return false;
    }

    public boolean larger(Position other)
    {
        if(this.x >= other.x && this.y >= other.y) return true;
        else return false;
    }

    public Position add(Position other)
    {
        return new Position(this.x + other.x, this.y + other.y);
    }

    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        return this.x == that.x && this.y == that.y;
    }
}
