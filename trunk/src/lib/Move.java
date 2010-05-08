
package lib;

/**
 * Rappresenta una mossa
 * 
 * @author muffo
 */
public class Move {
    private int x, y;
    String color;
    String figure;
    int time;

    public Move(int x, int y, String color, String figure, int time) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.figure = figure;
        this.time = time;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String toString() {
        return "hap(sono(" + x + "," + y + "," + color + "," + figure + ")," + time + ").\n";
    }

}
