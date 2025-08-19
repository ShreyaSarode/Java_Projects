package java;
//Shape class
//Shape class
class Shape {
 public double area() {
     return 0; // Default implementation
 }
}

//Circle class extending Shape
class Circle extends Shape {
 private double radius;

 public Circle(double radius) {
     this.radius = radius;
 }

 @Override
 public double area() {
     return Math.PI * radius * radius;
 }
}

//Rectangle class extending Shape
class Rectangle extends Shape {
 private double length;
 private double width;

 public Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 @Override
 public double area() {
     return length * width;
 }
}

//Main class for testing
public class Main {
 public static void main(String[] args) {
     // Create Circle object
     Circle circle = new Circle(5);
     System.out.println("Area of circle: " + circle.area());

     // Create Rectangle object
     Rectangle rectangle = new Rectangle(4, 6);
     System.out.println("Area of rectangle: " + rectangle.area());
 }
}
