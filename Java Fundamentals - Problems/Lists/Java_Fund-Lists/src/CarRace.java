import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        double leftCar = 0;
        double rightCar = 0;


        for (int i = 0; i <numbers.size()/2; i++) {
            if(numbers.get(i) == 0){
                leftCar *=0.8;
            }else {
                leftCar += numbers.get(i);
            }
        }
        for (int i = numbers.size()-1; i >numbers.size()/2 ; i--) {
            if(numbers.get(i)==0){
                rightCar*=0.8;
            }else {
                rightCar+=numbers.get(i);
            }
        }
        if(rightCar < leftCar){
            System.out.printf("The winner is right with total time: %.1f",rightCar);
        }
        if(leftCar<rightCar){
            System.out.printf("The winner is left with total time: %.1f",leftCar);
        }


    }
}
