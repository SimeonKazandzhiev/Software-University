import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rosesInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        for (int rose : rosesInput) {
            roses.offer(rose);
        }
        int[] liliesInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        for (int lilie : liliesInput) {
            lilies.push(lilie);
        }

        int wreaths = 0;
        int flowers = 0;
        while (!roses.isEmpty() && !lilies.isEmpty()){
            int rose = roses.peek();
            int lili = lilies.peek();

            if(rose + lili == 15){
                wreaths++;
                roses.poll();
                lilies.pop();

            }else if(rose + lili > 15){
                lilies.pop();
                lilies.push(lili - 2 );
            }else {
                flowers += rose + lili;
                roses.poll();
                lilies.pop();

            }
        }
       if(wreaths >= 5 ){
           System.out.println(String.format("You made it, you are going to the competition with %d wreaths!",wreaths) );
       }else {
           int extraWreath = flowers/15;
           int wreathNeed = 5 - (wreaths + extraWreath);

           System.out.println(String.format("You didn't make it, you need %d wreaths more!",wreathNeed));
       }

    }
}
