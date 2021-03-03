package bithdayCelebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("End")){
            String[] tokens = line.split("\\s+");
            Birthable current;

            if(tokens[0].equals("Citizen")){
                current = new Citizen(tokens[1],Integer.parseInt(tokens[2]),tokens[3],
                        tokens[4]);
                birthables.add(current);
            }else if (tokens[0].equals("Pet")){
                current = new Pet(tokens[1],tokens[2]);
                birthables.add(current);
            }
            line=scanner.nextLine();
        }
        String showInfoForYear = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if(birthable.getBirthDate().endsWith(showInfoForYear)){
                System.out.println(birthable.getBirthDate());
            }
        }

    }
}
