import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] malesNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> males = new ArrayDeque<>();
        for (int male : malesNums) {
            males.push(male);
        }
        int[] femalesNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> females = new ArrayDeque<>();
        for (int female : femalesNums) {
            females.offer(female);
        }
        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()){
            int male = males.peek();
            int female = females.peek();
            if(male <= 0){
                males.pop();
                continue;
            }
            if(female <=0){
                females.poll();
                continue;
            }
            if(male % 25 == 0){
                males.pop();
                males.pop();
                continue;
            }
            if(female % 25 ==0 ){
                females.poll();
                females.poll();
                continue;
            }

            if(male == female){
                males.pop();
                females.poll();
                matches++;
            }else {
                females.poll();
                males.pop();
                males.push(male - 2);
            }

        }
        System.out.println("Matches: " + matches);

        String malesOutput = "Males left: " +
                (males.isEmpty() ? "none" :
                        males.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(", ")));
        System.out.println(malesOutput);
        String femalesOutput = "Females left: " +
                (females.isEmpty() ? "none" :
                        females.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(", ")));
        System.out.println(femalesOutput);

    }
}
