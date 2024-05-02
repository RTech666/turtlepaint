import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape {
    // Create the variables.
    Point location;
    private double radius;

    // Create the constructors.
    public Circle(World world, double radius) {
        super(world);
        this.radius = radius;
    }

    public Circle(World world, double radius, int border, Color color, Point location) {
        super(world);
        this.radius = radius;
        this.setBorder(border);
        this.setColor(color);
        this.setLocation(location);
    }

    // Create the override methods.
    @Override
    public void paint() {
        Turtle turtle = new Turtle(getWorld());
        turtle.setColor(getColor());
        turtle.setPenWidth(getBorder());
        turtle.penDown();

        double circumference = 2 * Math.PI * radius;
        int numSides = (int) (circumference / 5);
        double angle = 360.0 / numSides;

        for (int i = 0; i < numSides; i++) {
            turtle.forward(circumference / numSides);
            turtle.turnLeft(angle);
        }

        turtle.penUp();
    }

    @Override
    public Point getLocation() {
        return location;
    }

    // Create setter.
    public void setLocation(Point location) {
        this.location = location;
    }
}