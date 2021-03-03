import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = scanner.nextLine();

        while(!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int index =Integer.parseInt(tokens[1]);
            int value =Integer.parseInt(tokens[2]);

            switch (command){
                case "Shoot":
                    if(isValid(numbers,index)){
                        int result = numbers.get(index) - value;

                        if(result <=0){
                            numbers.remove(index);
                        }else{
                            numbers.set(index,result);
                        }
                    }
                    break;
                case "Add":
                    if(isValid(numbers,index)){
                        numbers.add(index,value);
                    }else{
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":

                    if((index - value>=0) && (index + value<numbers.size())){
                        for (int i = 1; i <=value ; i++) {
                            numbers.remove(index-1);
                            numbers.remove(index);
                            index--;
                        }numbers.remove(index);

                    }else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input= scanner.nextLine();
        }

        for (int i = 0; i < numbers.size(); i++) {
            if(i < numbers.size()-1){
                System.out.print(numbers.get(i) + "|");
            }else {
                System.out.println(numbers.get(i));
            }
        }
    }
    private static boolean isValid(List<Integer> numbers, int index) {
        boolean result = index >=0 && index < numbers.size();

        return result;
    }
}
