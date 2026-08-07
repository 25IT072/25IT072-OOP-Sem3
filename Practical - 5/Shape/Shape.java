public abstract class Shape {
    public abstract double area();
}

class Circle extends Shape{
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }
    public double area(){
        return 3.14*radius*radius;
    }
}

class Rectangle extends Shape{
    private double length, breadth;

    Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public double area(){
        return length * breadth;
    }
}

class Triangle extends Shape{
    private double base, height;

    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    public double area(){
        return 0.5*base*height;
    }
}
