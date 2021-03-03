import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MakeSalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] vegs = scanner.nextLine().split("\\s+");
        ArrayDeque<String> vegetables = new ArrayDeque<>();
        for (String vegetable : vegs) {
            vegetables.offer(vegetable);
        }

        int[] saladsCalories = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> salads = new ArrayDeque<>();
        for (int salad : saladsCalories) {
            salads.push(salad);
        }

        HashMap<String, Integer> vegetablesCalories = new HashMap<>();
        vegetablesCalories.put("tomato", 80);
        vegetablesCalories.put("carrot", 136);
        vegetablesCalories.put("lettuce", 109);
        vegetablesCalories.put("potato", 215);

        while (!vegetables.isEmpty() && !salads.isEmpty()) {
            int currentSalad = salads.peek();

            while (currentSalad > 0 && !vegetables.isEmpty()) {
                currentSalad -= vegetablesCalories.get(vegetables.poll());
            }
            System.out.print(salads.pop() + " ");
        }
        System.out.println();

        if (!vegetables.isEmpty()) {
            System.out.println(String.join(" ", vegetables));
        }

        if (!salads.isEmpty()) {
            for (Integer salad : salads) {
                System.out.print(salad + " ");
            }
        }
    }
}
