/* 
Triangle.java
This Java file is the file that contains all the methods for the triangle.
*/

import java.awt.Color;
import java.awt.Point;

public class Triangle extends Shape {
    // Create the variables.
    private Point[] vertices;
    private Point location;

    // Create the constructor.
    public Triangle(World world, Point[] vertices, int border, Color color, Point location) {
        super(world);
        this.vertices = vertices;
        this.border = border;
        this.color = color;
        this.location = location;
    }

    // Create the override methods.
    @Override
    public Point getLocation() {
        double centerX = (vertices[0].getX() + vertices[1].getX() + vertices[2].getX()) / 3;
        double centerY = (vertices[0].getY() + vertices[1].getY() + vertices[2].getY()) / 3;
        return new Point((int) centerX, (int) centerY);
    }

    @Override
    public void paint() {
        Turtle turtle = new Turtle(getWorld(), getLocation().getX(), getLocation().getY());
        turtle.setColor(getColor());
        turtle.setPenWidth(getBorder());

        turtle.penDown();
        turtle.goTo(vertices[0]);
        turtle.goTo(vertices[1]);
        turtle.goTo(vertices[2]);
        turtle.goTo(vertices[0]); // Close the triangle
        turtle.penUp();
    }

    @Override
    public void setLocation(Point location) {
        Point currentLocation = getLocation();
        double dx = location.getX() - currentLocation.getX();
        double dy = location.getY() - currentLocation.getY();
        for (Point vertex : vertices) {
            vertex.setLocation(vertex.getX() + dx, vertex.getY() + dy);
        }
    }
}