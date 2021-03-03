package wildFarm;

import wildFarm.app.Animal.*;
import wildFarm.food.Food;
import wildFarm.food.Meat;
import wildFarm.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String evenLine = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!evenLine.equals("End")) {

            Animal animal = createAnimal(evenLine.split("\\s+"));

            String oddLine = scanner.nextLine();

            Food food = createFood(oddLine.split("\\s+"));

            animal.makeSound();
            animal.eat(food);
            animals.add(animal);

            evenLine = scanner.nextLine();
        }

        for (Animal animal1 : animals) {
           System.out.println(animal1);
        }


    }

    private static Food createFood(String[] tokens) {
        int quantity = Integer.parseInt(tokens[1]);
        return tokens[0].equals("Meat") ? new Meat(quantity) : new Vegetable(quantity);
    }

    private static Animal createAnimal(String[] tokens) {

        switch (tokens[0]) {

            case "Mouse":
                return new Mouse(tokens[0], tokens[1],
                        Double.parseDouble(tokens[2]), tokens[3]);
            case "Zebra":
                return new Zebra(tokens[0], tokens[1],
                        Double.parseDouble(tokens[2]), tokens[3]);
            case "Tiger":
               return new Tiger(tokens[0], tokens[1],
                        Double.parseDouble(tokens[2]), tokens[3]);

            case "Cat":
                return new Cat(tokens[0], tokens[1],
                        Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
            default:
                throw new IllegalStateException("Invalid input!");

        }

    }

}