import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        for (int box : firstNumbers) {
            firstBox.offer(box);
        }
        int[] secondNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        for (int box : secondNumbers) {
            secondBox.push(box);
        }
        int total = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()){
            int firstItem = firstBox.peek();
            int secondItem = secondBox.peek();
            int sum = firstItem + secondItem;
            if(sum % 2 !=0 ){
                secondBox.pop();
                firstBox.offer(secondItem);
            }else {
               total+=sum;
               firstBox.poll();
               secondBox.pop();
            }
        }
        if(firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if(secondBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }

        if(total >= 100){
            System.out.println("Your loot was epic! Value: " + total);
        }else {
            System.out.println("Your loot was poor... Value: " + total);
        }

    }
}
