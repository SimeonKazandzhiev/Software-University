import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] p1 = Arrays.stream(scanner.nextLine().split("\\s+"))
        .mapToInt(Integer::parseInt).toArray();
        int[] p2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Set<Integer> playerOne = new LinkedHashSet<>();
        Set<Integer> playerTwo = new LinkedHashSet<>();

        for (int i = 0; i < p1.length; i++) {
            int current =  p1[i];
            playerOne.add(current);
        }
        for (int i = 0; i <p2.length ; i++) {
            int current = p2[i];
            playerTwo.add(current);
        }
        int rounds = 50;
            while (!playerOne.isEmpty() && !playerTwo.isEmpty()){
                if(rounds == 0){
                    break;
                }
                int firstNumber = playerOne.iterator().next();
                playerOne.remove(firstNumber);
                int secondNumber = playerTwo.iterator().next();
                playerTwo.remove(secondNumber);

                if(firstNumber > secondNumber){
                    playerOne.add(firstNumber);
                    playerOne.add(secondNumber);
                }else if(secondNumber >firstNumber){
                    playerTwo.add(firstNumber);
                    playerTwo.add(secondNumber);
                }
                rounds--;
            }

        if(playerOne.size() > playerTwo.size()){
            System.out.println("First player win!");
        }else if(playerTwo.size()> playerOne.size()){
            System.out.println("Second player win!");
        }else {

            System.out.println("Draw!");
        }

    }
}
