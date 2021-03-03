import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String arr:array) {
            int current = Integer.parseInt(arr);
            numbers.add(current);
        }

        for (int i = 0; i < numbers.size()-1; i++) {
            if(i == numbers.size()- 1){
                break;
            }
            int last = numbers.get(numbers.size()-1);
            int current = numbers.get(i);
            numbers.set(i,last + current);
            numbers.remove(numbers.size()- 1);


        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }


    }
}
