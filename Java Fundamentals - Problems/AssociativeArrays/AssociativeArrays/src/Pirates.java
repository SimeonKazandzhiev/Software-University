import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> population = new LinkedHashMap<>();
        Map<String, Integer> gold = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("Sail")) {

            String[] tokens = line.split("\\|\\|");
            String name = tokens[0];
            int populationToAdd = Integer.parseInt(tokens[1]);
            int goldToAdd = Integer.parseInt(tokens[2]);

            if(population.containsKey(name)){
                int newPopulation = population.get(name) + populationToAdd;
                int newGold = gold.get(name) + goldToAdd;
                population.put(name,newPopulation);
                gold.put(name,newGold);
            }else{
                population.put(name,populationToAdd);
                gold.put(name,goldToAdd);
            }

            line = scanner.nextLine();
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("=>");
            String command = tokens[0];
            String town = tokens[1];

            switch (command) {
                case "Plunder":
                    int peopleKilled =Integer.parseInt(tokens[2]);
                    int stolenGold = Integer.parseInt(tokens[3]);
                    int populationLeft= population.get(town) -peopleKilled;
                    int goldLeft = gold.get(town) - stolenGold;
                    population.put(town,populationLeft);
                    gold.put(town,goldLeft);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",town,stolenGold,peopleKilled);
                    if(population.get(town)==0 || gold.get(town) == 0){
                        population.remove(town);
                        gold.remove(town);
                        System.out.printf("%s has been wiped off the map!%n",town);
                    }
                    break;
                case "Prosper":
                    int givenGold = Integer.parseInt(tokens[2]);
                    if(givenGold<0){
                        System.out.println("Gold added cannot be a negative number!");
                    }else{
                        int newGold = gold.get(town) + givenGold;
                        gold.put(town,newGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",givenGold,town,newGold);
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        if(gold.isEmpty()){
            System.out.print("Ahoy, Captain! All targets have been plundered and destroyed!");
        }else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",gold.size());
        }
        gold.entrySet().stream().sorted((city1,city2)->{
            int result = city2.getValue().compareTo(city1.getValue());
            if(result == 0){
                result = city1.getKey().compareTo(city2.getKey());
            }
            return result;

        }).forEach(city -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",city.getKey(),
                population.get(city.getKey()),city.getValue()));
    }
}
