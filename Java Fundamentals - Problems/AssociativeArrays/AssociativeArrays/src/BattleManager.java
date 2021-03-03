import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> healthRecords = new HashMap<>();
        Map<String, Integer> energyRecords = new HashMap<>();

        String input = scanner.nextLine();

        while (!"Results".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String personName = tokens[1];
                    int health = Integer.parseInt(tokens[2]);
                    int energy = Integer.parseInt(tokens[3]);
                    if (!healthRecords.containsKey(personName)) {
                        healthRecords.put(personName, health);
                        energyRecords.put(personName, energy);
                    } else {
                        int currentHealth = healthRecords.get(personName);
                        int currentEnergy = energyRecords.get(personName);
                        healthRecords.put(personName, currentHealth + health);
                        energyRecords.put(personName, currentEnergy + energy);
                    }
                    break;
                case "Attack":
                    String attackerName = tokens[1];
                    String defenderName = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);
                    if (healthRecords.containsKey(attackerName) && healthRecords.containsKey(defenderName)) {
                        int currentHealth = healthRecords.get(defenderName);
                        int currentEnergy = energyRecords.get(attackerName);
                        healthRecords.put(defenderName, currentHealth - damage);
                        energyRecords.put(attackerName, currentEnergy - 1);
                        if (healthRecords.get(defenderName) <= 0) {
                            healthRecords.remove(defenderName);
                            energyRecords.remove(defenderName);
                            System.out.println(String.format("%s was disqualified!", defenderName));
                        }
                        if (energyRecords.get(attackerName) <= 0) {
                            energyRecords.remove(attackerName);
                            healthRecords.remove(attackerName);
                            System.out.println(String.format("%s was disqualified!", attackerName));
                        }
                    }
                    break;
                case "Delete":
                    if (tokens[1].equals("All")) {
                        healthRecords.clear();
                        energyRecords.clear();
                    } else {
                        String username = tokens[1];
                        if (healthRecords.containsKey(username)) {
                            healthRecords.remove(username);
                            energyRecords.remove(username);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("People count: " + healthRecords.size());
        healthRecords.entrySet().stream()
                .sorted((p1,p2) -> {
                    int result = Integer.compare(p2.getValue(),p1.getValue());
                    if(result == 0){
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return result;

                }).forEach(p -> {
                    String name = p.getKey();
                    int health = p.getValue();
                    int energy = energyRecords.get(name);
            System.out.println(String.format("%s - %d - %d",name,health,energy));
            
        });
    }
}
