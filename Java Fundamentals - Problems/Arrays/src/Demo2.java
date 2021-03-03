import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String values = "2 8 30 25 40 72 -2 44 56";
        String[] numbersAsString = values.split(" ");
        int[] numbers = new int[numbersAsString.length];


        for (int i = 0; i <numbers.length ; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] * 1.5);

        }
    }
}
