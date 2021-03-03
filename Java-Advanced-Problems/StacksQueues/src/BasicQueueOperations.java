import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersAsQueue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] secondInput = scanner.nextLine().split("\\s+");

        for (int i = 0; i < n; i++) {
            numbersAsQueue.offer(Integer.parseInt(secondInput[i]));
        }
        for (int i = 0; i < s; i++) {
            numbersAsQueue.poll();
        }
        if (numbersAsQueue.isEmpty()) {
            System.out.println(0);
        } else {
            if (numbersAsQueue.contains(x)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(numbersAsQueue));
            }
        }
    }
}
