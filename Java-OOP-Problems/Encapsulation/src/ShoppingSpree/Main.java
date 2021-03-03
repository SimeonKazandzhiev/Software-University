package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        Map<String, Person> peopleByName = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split("=");
            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);
            try {
                Person person = new Person(name, money);
                peopleByName.putIfAbsent(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        input = scanner.nextLine().split(";");

        Map<String, Product> productsByNames = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split("=");
            String name = tokens[0];
            double cost = Double.parseDouble(tokens[1]);
            try {
                Product product = new Product(name, cost);
                productsByNames.putIfAbsent(name, product);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());

            }
        }

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String product = tokens[1];
            try {
                peopleByName.get(name).buyProduct(productsByNames.get(product));
                System.out.println(name + " bought " + product);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());

            }

            line = scanner.nextLine();

        }
        for (Person value : peopleByName.values()) {
            System.out.println(value.toString());
        }
    }
}

