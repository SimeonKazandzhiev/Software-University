import java.util.Scanner;

public class OddEvenSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i <numbers.length ; i++) {
            numbers[i] = Integer.parseInt(input[i]);

        }
        int evenSum = 0;
        int oddSum = 0;

        for (int number:numbers) {
            if(number % 2 == 0){
                evenSum +=number;
            }else {
                oddSum+=number;
            }
        }
        System.out.println(evenSum - oddSum);
    }
}
