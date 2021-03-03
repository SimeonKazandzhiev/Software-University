import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int [] numbers = new int[input.length];
        int target = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <input.length ; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i <numbers.length - 1 ; i++) {
            int firstNumber = numbers[i];
            for (int j = i+ 1; j <numbers.length ; j++) {
                int secondNumber = numbers[j];
                if(firstNumber + secondNumber == target){
                    System.out.printf("%d %d%n",firstNumber,secondNumber);
                }
            }
        }
    }
}
