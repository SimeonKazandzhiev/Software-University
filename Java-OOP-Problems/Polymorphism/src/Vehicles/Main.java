package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]),
                Double.parseDouble(carInfo[3]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]),
                Double.parseDouble(truckInfo[3]));

        String[] busInfo = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]),
                Double.parseDouble(busInfo[3]));


        int commands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Drive":
                    if (tokens[1].equals("Car")) {
                        car.drive(Double.parseDouble(tokens[2]));
                    } else if (tokens[1].equals("Truck")) {
                        truck.drive(Double.parseDouble(tokens[2]));
                    }else {
                        bus.drive(Double.parseDouble(tokens[2]));
                    }
                    break;

                case "Refuel":
                    if (tokens[1].equals("Car")) {
                        car.refuel(Double.parseDouble(tokens[2]));
                    } else if(tokens[1].equals("Truck")) {
                        truck.refuel(Double.parseDouble(tokens[2]));
                    }else {
                        bus.refuel(Double.parseDouble(tokens[2]));
                    }
                    break;

                case "DriveEmpty":
                    bus.drive(Double.parseDouble(tokens[2]));
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }
}
