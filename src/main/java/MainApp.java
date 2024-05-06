/* 
MainApp.java
This Java file is the main file that contains all the menus and options.

displayHomeScreen() - The home screen for the program.
addShape() - The menu for adding a shape to the program.
addSquare() - If user chose to add a square, it asks them the square options and then prints it to the program.
createCircle() - Same as the last method, but asks them options for a circle.
createTriangle() - Same as the last method, but asks them options for a triangle.
saveImage() - Method to save an image of the program.
*/

import java.awt.Color;
import java.awt.Point;
import java.util.Scanner;

public class MainApp {
    // Initalize the scanner.
    private static Scanner scanner = new Scanner(System.in);
    
    // Create the variable.
    private static World world;

    public static void main(String[] args) {
        // Print title.
        System.out.println("Welcome to Turtle Paint!");

        // Print canvas title.
        System.out.println("Enter the size of the canvas below:");

        // Ask user for the width.
        System.out.print("Enter the width: ");
        int width = scanner.nextInt();

        // Ask user for the height.
        System.out.print("Enter the height: ");
        int height = scanner.nextInt();

        // Create the canvas.
        world = new World(width, height);

        int choice;
        do {
            // Call displayHomeScreen.
            displayHomeScreen();
            choice = getUserChoice();

            // Read the user input and execute the appropiate method.
            switch (choice) {
                case 1:
                    addShape();
                    break;
                case 2:
                    saveImage(world);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } while (choice != 0);
    }

    // Create displayHomeScreen method.
    private static void displayHomeScreen() {
        // Print home screen.
        System.out.println("\nHome Screen:");
        System.out.println("1) Add Shape");
        System.out.println("2) Save Image");
        System.out.println("0) Exit");
    }

    // Create getUserChoice method.
    private static int getUserChoice() {
        // Ask user for their choice.
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    // Create addShape method.
    private static void addShape() {
        // Print shape options.
        System.out.println("\nAdding a new shape:");
        System.out.println("1. Square");
        System.out.println("2. Circle");
        System.out.println("3. Triangle");

        // Ask user what shape they want to add.
        System.out.println("Which shape do you want to add?");
        int shapeChoice = scanner.nextInt();

        Shape shape;
        // Read the user input and execute the appropiate method.
        switch (shapeChoice) {
            case 1:
                addSquare(world, scanner);
                break;
            case 2:
                shape = createCircle();
                break;
            case 3:
                shape = createTriangle();
                break;
            default:
                System.out.println("Invalid shape choice.");
                return;
        }
    }

    // Create addSquare method.
    private static void addSquare(World world, Scanner scanner) {
        // Ask user for the width of the square.
        System.out.print("Enter the width of the square: ");
        double width = scanner.nextDouble();

        // Ask user for the border width.
        System.out.print("Enter the border width: ");
        double borderWidth = scanner.nextDouble();

        // Ask user for the border color.
        System.out.println("Enter the border color (R,G,B):");
        System.out.print("R Number: ");
        int r = scanner.nextInt();
        System.out.print("G Number: ");
        int g = scanner.nextInt();
        System.out.print("B Number: ");
        int b = scanner.nextInt();

        // Ask user for the location.
        System.out.println("Enter the location of the square (x,y):");
        System.out.print("X: ");
        double x = scanner.nextDouble();
        System.out.print("Y: ");
        double y = scanner.nextDouble();

        // Create the square and draw it.
        Square square = new Square(world, width);
        square.setBorder(borderWidth);
        square.setColor(new java.awt.Color(r, g, b));
        square.setLocation(new java.awt.Point((int) x, (int) y));
        square.paint();
    }

    // Create createCircle method.
    private static Circle createCircle() {
        // Ask user for the radius.
        System.out.print("Enter the radius: ");
        int radius = scanner.nextInt();

        // Ask user for the border width.
        System.out.print("Enter the border width: ");
        int border = scanner.nextInt();

        // Ask user for the border color.
        System.out.println("Enter the border color (R,G,B):");
        System.out.print("R Number: ");
        int r = scanner.nextInt();
        System.out.print("G Number: ");
        int g = scanner.nextInt();
        System.out.print("B Number: ");
        int b = scanner.nextInt();

        // Ask user for the location.
        System.out.println("Enter the location of the circle (x,y):");
        System.out.print("X: ");
        int x = scanner.nextInt();
        System.out.print("Y: ");
        int y = scanner.nextInt();

        // Create the circle and draw it.
        Circle circle = new Circle(world, radius, border, new Color(r, g, b), new Point(x, y));
        circle.paint();
        return circle;
    }

    // Create createTriangle method.
    private static Triangle createTriangle() {
        // Ask user for the coordinates of each vertex.
        System.out.println("Enter the coordinates of the first vertex (x,y):");
        System.out.print("X: ");
        int x1 = scanner.nextInt();
        System.out.print("Y: ");
        int y1 = scanner.nextInt();

        System.out.println("Enter the coordinates of the second vertex (x,y):");
        System.out.print("X: ");
        int x2 = scanner.nextInt();
        System.out.print("Y: ");
        int y2 = scanner.nextInt();

        System.out.println("Enter the coordinates of the third vertex (x,y):");
        System.out.print("X: ");
        int x3 = scanner.nextInt();
        System.out.print("Y: ");
        int y3 = scanner.nextInt();
    
        // Ask user for the border width.
        System.out.print("Enter the border width: ");
        int border = scanner.nextInt();
    
        // Ask user for the border color.
        System.out.println("Enter the border color (R,G,B):");
        System.out.print("R Number: ");
        int r = scanner.nextInt();
        System.out.print("G Number: ");
        int g = scanner.nextInt();
        System.out.print("B Number: ");
        int b = scanner.nextInt();
    
        // Ask user for the location.
        System.out.println("Enter the location of the triangle (x,y):");
        System.out.print("X: ");
        int x = scanner.nextInt();
        System.out.print("Y: ");
        int y = scanner.nextInt();
    
        // Create the triangle.
        Point[] vertices = { new Point(x1, y1), new Point(x2, y2), new Point(x3, y3) };
        Triangle triangle = new Triangle(world, vertices, border, new Color(r, g, b), new Point(x, y));
        return triangle;
    }

    // Create the saveImage method.
    private static void saveImage(World world) {
        // Save image as output.png.
        world.saveAs("output.png");
        System.out.println("Image saved as 'output.png'");
    }
}