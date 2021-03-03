package needForSpeed;

public class Main {
    public static void main(String[] args) {
        Vehicle motorcycle = new SportCar(20,300);

        motorcycle.drive(2);
        System.out.println(motorcycle.getFuel());

   }
}
