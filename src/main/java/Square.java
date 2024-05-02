import java.awt.Point;

public class Square extends Shape {
    // Create the variables.
    private Point location;
    private double width;

    // Create the constructor.
    public Square(World world, double width) {
        super(world);
        this.width = width;
    }

    // Create the override methods.
    @Override
    public void paint() {
        Turtle turtle = new Turtle(getWorld());
        turtle.setColor(getColor());
        turtle.setPenWidth(getBorder());
        turtle.penDown();

        for (int i = 0; i < 4; i++) {
            turtle.forward(width);
            turtle.turnLeft(90);
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