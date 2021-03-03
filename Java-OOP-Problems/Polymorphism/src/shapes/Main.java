package shapes;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(5.5,2.5);

        System.out.println(rectangle.calculateArea());


        Shape circle = new Circle(5.5);
        System.out.println(circle.calculateArea());
    }
}
