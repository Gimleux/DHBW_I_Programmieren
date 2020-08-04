package de.dhbwka.java.exercise.classes;

public class Point {
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double yCoord) {
        this.x = x;
        this.y = yCoord;
    }

    public Point mirrorX(){
        return new Point(this.x*-1,this.y);
    }

    public Point mirrorY(){
        return new Point(this.x, this.y*-1);
    }

    public Point mirrorOrigin(){
        return new Point(this.x*-1, this.y*-1);
    }

    public double getDistance(Point pkt){
        double differenceX = Math.abs(this.x - pkt.x);
        double differenceY = Math.abs(this.y - pkt.y);
        return Math.sqrt(Math.pow(differenceX,2) + Math.pow(differenceY,2));
    }

    public double getDistanceToOrigin(){
        return getDistance(new Point(0,0));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point pointA = new Point(4.0, 2.0);
        System.out.println("A: " + pointA);
        Point pointB = new Point(-1.0, -1.0);
        System.out.println("B: " + pointB);
        System.out.println("Abstand A-B: "
                + pointA.getDistance(pointB));
        pointA = pointA.mirrorOrigin();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A’-B: "
                + pointA.getDistance(pointB));
    }
}
