import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CheetSheet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading stack and queue with stream:
        // QUEUE ::
        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        // OR ::

        int[] femalesNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> females = new ArrayDeque<>();
        for (int female : femalesNums) {
            females.offer(female);
        }


        //STACK ::

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        // OR ::

        int[] malesNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> males = new ArrayDeque<>();
        for (int male : malesNums) {
            males.push(male);
        }


        // Print stack or queue with stream :

       // String casingsOutput = "Casings Effects: " +
       //         (casings.isEmpty() ? "empty" :
       //                 casings.stream()
       //                         .map(String::valueOf)
        //                          .collect(Collectors.joining(", ")));

       // Проверяване на мап дали стойностите му изпълняват някакво условие:

       // if(mapName.entrySet().stream().allMatch(e -> e.getValue() >0 ));
            // Do something if the condition is satisfied.
        // Проверява в случая дали всички стойности са по големи от нула в мапа
        // с anyMatch се проверява дали поне един елемент изпълнява това условие

    }
}
