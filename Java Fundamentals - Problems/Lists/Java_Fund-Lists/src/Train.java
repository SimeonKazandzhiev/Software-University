import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> train = readIntList(scanner);
        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");

            if ("Add".equals(tokens[0])) {
                int people = Integer.parseInt(tokens[1]);
                train.add(people);
            } else {
                int peopleToAdd = Integer.parseInt(tokens[0]);
                for (int wagon = 0; wagon < train.size(); wagon++) {
                    int sum = train.get(wagon) + peopleToAdd;
                    if (sum <= capacity) {
                        train.set(wagon, sum);
                        break;
                    }
                }

            }

            input = scanner.nextLine();
        }
        printList(train);

    }

    private static List<Integer> readIntList(Scanner scanner) {
        List<Integer> train = new ArrayList<>();
        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            train.add(Integer.parseInt(s));
        }
        return train;
    }

    private static void printList(List<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }


    }
}
