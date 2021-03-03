import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();

        Set<String> parking = new LinkedHashSet<>();

        while (!line.equals("END")){
            String[] tokens = line.split(", ");
            String command = tokens[0];
            String numberPlate = tokens[1];

            if(command.equals("IN")){
                parking.add(numberPlate);
            }else if(command.equals("OUT")) {
                parking.remove(numberPlate);
            }

            line = scanner.nextLine();
        }
        if(parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String s : parking) {
                System.out.println(s);
            }
        }

    }
}
