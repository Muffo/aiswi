
package lib;

/**
 * Rappresents a move
 * 
 * @author muffo
 */
public class Move {
    private int x, y;
    String color;
    String figure;
    int time;

    /**
     *
     * @param x
     * @param y
     * @param color
     * @param figure
     * @param time
     */
    public Move(int x, int y, String color, String figure, int time) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.figure = figure;
        this.time = time;
    }

    /**
     * Get X value
     * @return
     */
    public int getX(){
        return this.x;
    }

    /**
     * Get Y value
     * @return
     */
    public int getY(){
        return this.y;
    }

    public int getTime(){
        return this.time;
    }

    @Override
    public String toString() {
        return "hap(sono(" + x + "," + y + "," + color + "," + figure + ")," + time + ".0).";
    }

}
