import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read and Fill up stack or queue
        // 1st way:
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbers = new ArrayDeque<>();
        for (String number : input) {
           numbers.push(number);
        }
        // 2nd way:
      //  Arrays.stream(scanner.nextLine().split("\\s+")).forEach(numbers::push);

        while (!numbers.isEmpty()){
            System.out.print(numbers.pop() + " ");
        }
    }
}
