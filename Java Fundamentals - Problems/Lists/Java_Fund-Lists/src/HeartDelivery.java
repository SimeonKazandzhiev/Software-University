import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputNums = scanner.nextLine().split("@");
        List<Integer> numbers = new ArrayList<>();
        for (String inputNum : inputNums) {
            numbers.add(Integer.parseInt(inputNum));
        }


        String input = scanner.nextLine();

        while (!input.equals("Love!")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            int length = Integer.parseInt(tokens[1]);

            switch (command){
                case "Jump":
                   if(length >=0 && length < numbers.size()-1){




                   }


                    break;



            }



            input = scanner.nextLine();
        }
    }
}
