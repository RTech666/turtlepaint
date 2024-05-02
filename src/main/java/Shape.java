import java.awt.Color;
import java.awt.Point;

public abstract class Shape {
    // Create the variables.
    private World world;
    Color color;
    double border;

    // Create the constructor.
    public Shape(World world) {
        this.world = world;
    }

    // Create getters and setters.
    public World getWorld() {
        return world;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getBorder() {
        return border;
    }

    public void setBorder(double border) {
        this.border = border;
    }

    // Create abstract methods.
    public abstract void setLocation(Point location);

    public abstract void paint();

    public abstract Point getLocation();
}