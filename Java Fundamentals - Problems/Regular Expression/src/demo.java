import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> population = new HashMap<>();
        Map<String, Integer> gold = new HashMap<>();

        while (!"Sail".equals(input)) {
            String[] tokens = input.split("[|]{2}");
            String town = tokens[0];
            int popul = Integer.parseInt(tokens[1]);
            int currentGold = Integer.parseInt(tokens[2]);
            if (!population.containsKey(town)) {
                population.put(town, popul);
                gold.put(town, currentGold);
            } else {
                int newPopulation = population.get(town) + popul;
                int newGold = gold.get(town) + currentGold;
                population.put(town, newPopulation);
                gold.put(town, newGold);
            }
            input = scanner.nextLine();
        }
        String inputLine = scanner.nextLine();
        while (!"End".equals(inputLine)) {
            String[] tokens = inputLine.split("=>");
            String command = tokens[0];
            String town = tokens[1];
            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(tokens[2]);
                    int goldTobeSteal = Integer.parseInt(tokens[3]);
                    int peopleLeft = population.get(town) - people;
                    int goldLeft = gold.get(town) - goldTobeSteal;
                    population.put(town, peopleLeft);
                    gold.put(town, goldLeft);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, goldTobeSteal, people);
                    if (peopleLeft <= 0 || goldLeft <= 0) {
                        System.out.println(town + " has been wiped off the map!");
                        population.remove(town);
                        gold.remove(town);
                    }
                    break;
                case "Prosper":
                    int goldToAdd = Integer.parseInt(tokens[2]);
                    if(goldToAdd <0){
                        System.out.println("Gold added cannot be a negative number!");
                    }else {
                        int newGold = gold.get(town) + goldToAdd;
                        gold.put(town,newGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",goldToAdd,town,newGold);
                    }

                    break;
            }
            inputLine = scanner.nextLine();
        }
        if(population.size()>0){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",population.size());
            gold.entrySet().stream()
                    .sorted((t1,t2) -> {
                        int result = Integer.compare(t2.getValue(),t1.getValue());
                        if(result == 0){
                            result = t1.getKey().compareTo(t2.getKey());
                        }
                        return result;

                    }).forEach(city ->{
                        String name = city.getKey();
                        int goldFinal = city.getValue();
                        int popul = population.get(name);
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",name,popul,goldFinal);
            });

        }else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
