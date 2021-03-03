import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = readIntList(scanner);

        String input = scanner.nextLine();

        while(!"end".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            Integer element =Integer.valueOf(tokens[1]);
            if("Delete".equals(command)){
               while (numbers.contains(element)){
                   numbers.remove(element);
               }
            }else if("Insert".equals(command)){
                int numberToInsert = element;
                int positionToInsert = Integer.parseInt(tokens[2]);
                if(positionToInsert >= 0 && positionToInsert < numbers.size()){
                    numbers.add(positionToInsert,numberToInsert);
                }

            }

            input=scanner.nextLine();
        }
        printList(numbers);
    }

    private static void printList(List<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }
    }

    private static List<Integer> readIntList(Scanner scanner) {
        List<Integer> train = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (String s : input) {
            train.add(Integer.parseInt(s));
        }
        return train;
    }
}
