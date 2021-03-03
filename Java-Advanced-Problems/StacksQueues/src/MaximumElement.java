import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            switch (command) {
                case "1":
                    int numToPush = Integer.parseInt(input[1]);
                    numbers.push(numToPush);
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbers));
                    break;
            }
        }
    }
}
