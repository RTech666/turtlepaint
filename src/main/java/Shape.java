package main.java;

abstract class Shape {
    protected Point location;
    protected Color color;
    protected int border;

    public Shape(Point location, Color color, int border) {
        this.location = location;
        this.color = color;
        this.border = border;
    }

    public abstract void paint(Graphics2D g);
}