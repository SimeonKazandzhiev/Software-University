import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // n -> number of elements to push onto the stack
        // s -> number of elements to pop from the stack
        // x -> an element that you should check whether is present in the stack
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String[] firstLine = scanner.nextLine().split("\\s+");


        int n  = Integer.parseInt(firstLine[0]);
        int s  = Integer.parseInt(firstLine[1]);
        int x  = Integer.parseInt(firstLine[2]);

        String[] secondLine = scanner.nextLine().split("\\s+");

        for (int i = 0; i <n ; i++) {
            numbers.push(Integer.parseInt(secondLine[i]));
        }

        for (int i = 0; i < s; i++) {
            numbers.pop();
        }

        if(numbers.isEmpty()){
            System.out.println(0);
        }else {
            if(numbers.contains(x)){
                System.out.println("true");
            }else {
                //min element
                // System.out.println(numbers.stream().mapToInt(e -> e).min().getAsInt());
                // System.out.println(Collections.min(numbers));
                System.out.println(getMinElement(numbers));
            }
        }


    }

    private static int getMinElement(ArrayDeque<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (Integer number : numbers) {
            if(number < min){
                min = number;
            }
        }
        return min;
    }
}
