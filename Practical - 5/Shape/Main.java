public class Main {
    public static void main(String[] args){
        Shape[] shape = {
            new Circle(7),
            new Rectangle(5, 2),
            new Triangle(10, 12)
        };

        double totalArea = 0;
        double maxArea = 0;

        for(Shape s : shape){
            double a = s.area();
            System.out.println("Area: " + a);
            totalArea += a;

            if(a > maxArea){
                maxArea = a;
            }
        }
        
        System.out.println("Total Area: " + totalArea);
        System.out.println("Largest Area: " + maxArea);
    }
}
