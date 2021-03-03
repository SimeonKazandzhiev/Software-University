import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split(" ");

        List<Integer> numbers = Arrays.stream(parts)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while(true){
            String line = scanner.nextLine();
            if(line.equals("end")){
                break;
            }
            String[] tokens = line.split(" ");
            String command = tokens[0];
            int argument = Integer.parseInt(tokens[1]);


            switch (tokens[0]){
                case "Add":
                    numbers.add(argument);
                    break;
                case"Remove":
                    numbers.remove(Integer.valueOf(argument));
                    break;
                case "RemoveAt":
                    numbers.remove(argument);
                    break;
                case "Insert":

                    int indexToBeInsert = Integer.parseInt(tokens[2]);
                    numbers.add(indexToBeInsert,argument);
                    break;
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
