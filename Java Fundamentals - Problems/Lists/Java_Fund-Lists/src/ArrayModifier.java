import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();


        while (!"end".equals(input)){
            String[] tokens = input.split(" ");
            String command = tokens[0];


            switch (command){

                case "swap":
                    int firstIndex =Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    if((firstIndex >=0 && firstIndex<numbers.size()) && (secondIndex>=0 && secondIndex<numbers.size())){
                        Collections.swap(numbers,firstIndex,secondIndex);
                    }

                    break;
                case "multiply":
                    int fIndex =Integer.parseInt(tokens[1]);
                    int secIndex = Integer.parseInt(tokens[2]);
                    if((fIndex >=0 && fIndex<numbers.size()) && (secIndex>=0 && secIndex<numbers.size())){
                        Integer sum = numbers.get(fIndex) * numbers.get(secIndex);
                        Integer result = numbers.set(fIndex,sum);
                    }

                    break;
                case "decrease":
                    for (int i = 0; i <numbers.size() ; i++) {
                     int temp = numbers.get(i);
                     int result = temp - 1;
                     numbers.set(i,result);
                    }

                    break;
            }

            input=scanner.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
           if(i < numbers.size()-1){
               System.out.print(numbers.get(i) + ", ");
           }else{
               System.out.print(numbers.get(i));
           }
        }

    }
}
