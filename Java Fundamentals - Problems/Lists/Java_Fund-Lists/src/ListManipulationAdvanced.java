import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] data = input.split("\\s+");

            switch (data[0]) {
                case "Contains":
                    int argument = Integer.parseInt(data[1]);

                    if (listNumbers.contains(argument)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (data[1].equals("even")) {
                        for (Integer listNumber : listNumbers) {
                            if (listNumber % 2 == 0) {
                                System.out.print(listNumber + " ");
                            }
                        }

                    } else if (data[1].equals("odd")) {
                        for (Integer listNumber : listNumbers) {
                            if (listNumber % 2 != 0) {
                                System.out.print(listNumber + " ");
                            }
                        }

                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;

                    for (Integer number : listNumbers) {
                        sum += number;

                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    StringBuilder outputFilter = new StringBuilder();
                    int num = Integer.parseInt(data[2]);
                    switch (data[1]) {
                        case "<":
                            for (Integer aList : listNumbers) {
                                if (aList < num) {
                                    outputFilter.append(aList).append(" ");

                                }
                            }
                            System.out.println(outputFilter);
                            break;
                        case ">":
                            for (Integer aList : listNumbers) {
                                if (aList > num) {
                                    outputFilter.append(aList).append(" ");

                                }
                            }
                            System.out.println(outputFilter);
                            break;
                        case ">=":
                            for (Integer aList : listNumbers) {
                                if (aList >= num) {
                                    outputFilter.append(aList).append(" ");

                                }
                            }
                            System.out.println(outputFilter);
                            break;
                        case "<=":
                            for (Integer aList : listNumbers) {
                                if (aList <= num) {
                                    outputFilter.append(aList).append(" ");

                                }
                            }
                            System.out.println(outputFilter);
                            break;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}