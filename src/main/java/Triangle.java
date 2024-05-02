import java.awt.Color;
import java.awt.Point;

public class Triangle extends Shape {
    // Create the variables.
    private Point[] vertices;
    private Point location;

    // Create the constructors.
    public Triangle(World world, Point[] vertices) {
        super(world);
        this.vertices = vertices;
    }

    public Triangle(World world, int x1, int y1, int x2, int y2, int x3, int y3, int border, int r, int g, int b, int x, int y) {
        super(world);
        this.vertices = new Point[] { new Point(x1, y1), new Point(x2, y2), new Point(x3, y3) };
        this.border = border;
        this.color = new Color(r, g, b);
        this.location = new Point(x, y);
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
        for (int i = 0; i < 3; i++) {
            turtle.goTo(vertices[i]);
        }
        turtle.goTo(vertices[0]);
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