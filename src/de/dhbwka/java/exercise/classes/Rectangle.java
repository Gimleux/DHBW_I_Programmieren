package de.dhbwka.java.exercise.classes;

import org.w3c.dom.css.Rect;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getArea(){
        return height*width;
    }

    public void scale(int factor){
        width *= factor;
        height *= factor;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle Width:  " + height + "\n" +
               "          Height: " + width + "\n";
    }

    public static void main(String[] args) {
        Rectangle a = new Rectangle(3,4);
        Rectangle b = new Rectangle(1,2);

        System.out.println(a.toString());
        System.out.println(b);

        a.scale(3);
        b.setWidth(2);
        System.out.println(a.getArea());
        int area = b.getArea();
        System.out.println(area);

        System.out.println(a);
        System.out.println(b.toString());
    }
}
