//for practice
public class Point {
    private int x;
    private int y;

    public Point(){

    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int setX(int x){
        return this.x = x;
    }

    public int setY(int y){
        return this.y = y;
    }
    public double distance() {
        return distance(0,0);
    }

    public double distance(Point point){
        return Math.sqrt(Math.pow(point.x-this.x,2) + Math.pow(point.y-this.y,2));
    }

    public double distance(int x, int y){
        return Math.sqrt(Math.pow(x-this.x,2) + Math.pow(y-this.y,2));
    }

}
