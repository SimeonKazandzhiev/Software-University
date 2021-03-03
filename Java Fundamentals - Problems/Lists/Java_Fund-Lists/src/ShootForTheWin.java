import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        int counter = 0;
        while (!"End".equals(input)) {
            int index = Integer.parseInt(input);
            if (index >= 0 && index < listNumbers.size()) {
                for (int i = 0; i < listNumbers.size() ; i++) {
                    int temp = listNumbers.get(index);
                    if (listNumbers.get(i) != -1 && i != index) {
                        if (listNumbers.get(i) > temp) {
                            listNumbers.set(i, listNumbers.get(i) - temp);
                        } else if (listNumbers.get(i) <= temp) {
                            listNumbers.set(i, listNumbers.get(i) + temp);
                        }
                    }

                }

                listNumbers.set(index, -1);
                counter++;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",counter);
        for (Integer listNumber : listNumbers) {
            System.out.print(listNumber + " ");
        }
    }
}
