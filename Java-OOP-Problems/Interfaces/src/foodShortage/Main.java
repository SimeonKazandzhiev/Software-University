package foodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<Buyer> buyers = new HashSet<>();
        int totalFood = 0;
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Buyer buyer;
            if (tokens.length == 4) {
                buyer = new Citizen(name, age, tokens[2], tokens[3]);

            } else {
                buyer = new Rebel(name, age, tokens[2]);

            }
            buyers.add(buyer);

        }

        String name = scanner.nextLine();
        while (!name.equals("End")) {
            for (Buyer buyer : buyers) {
                if (buyer.getName().equals(name)) {
                    buyer.buyFood();
                    totalFood += buyer.getFood();
                }

            }
            name = scanner.nextLine();
        }
        System.out.println(totalFood);
    }
}
