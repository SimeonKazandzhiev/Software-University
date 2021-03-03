import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> carMileage = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\|");
            String car = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            carMileage.putIfAbsent(car, mileage);
            carFuel.putIfAbsent(car, fuel);
        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];
            String car = tokens[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    if (carFuel.get(car) > fuel) {
                        int leftFuel = carFuel.get(car) - fuel;
                        carFuel.put(car, leftFuel);
                        int newMileage = carMileage.get(car) + distance;
                        carMileage.put(car, newMileage);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        if (carMileage.get(car) >= 100000) {
                            System.out.printf("Time to sell the %s!%n", car);
                            carFuel.remove(car);
                            carMileage.remove(car);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;

                case "Refuel":
                    int refuel = Integer.parseInt(tokens[2]);
                    int maxCapacity = 75;
                    if (carFuel.get(car) + refuel > maxCapacity) {
                        System.out.printf("%s refueled with %d liters%n", car, maxCapacity - carFuel.get(car));
                        carFuel.put(car, maxCapacity);
                    } else {
                        int newFuel = carFuel.get(car) + refuel;
                        carFuel.put(car, newFuel);
                        System.out.printf("%s refueled with %d liters%n", car, refuel);
                    }
                    break;
                case "Revert":
                    int decrease = Integer.parseInt(tokens[2]);
                    int newMileage = carMileage.get(car) - decrease;
                    carMileage.put(car, newMileage);
                    if (carMileage.get(car) < 10000){
                        carMileage.put(car, 10000);
                    } else{
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, decrease);
                }
                    break;
            }

            input = scanner.nextLine();
        }
        List<String> list = carMileage.entrySet()
                .stream()
                .sorted((c1,c2) ->{
                    int result = c2.getValue().compareTo(c1.getValue());
                    if(result == 0){
                        result = c1.getKey().compareTo(c2.getKey());
                    }
                    return result;
                }).map(Map.Entry::getKey).collect(Collectors.toList());
        for (String s : list) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",s,carMileage.get(s),carFuel.get(s));
        }
    }
}
