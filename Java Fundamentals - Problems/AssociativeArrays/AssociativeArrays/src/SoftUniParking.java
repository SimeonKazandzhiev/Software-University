import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> infoBook = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            switch (command){
                case "register":
                    String userName = input[1];
                    String plate = input[2];
                    if(!infoBook.containsKey(userName)){
                        infoBook.put(userName,plate);
                        System.out.printf("%s registered %s successfully%n",userName,plate);
                    }else{
                        System.out.printf("ERROR: already registered with plate number %s%n",plate);
                    }

                    break;
                case "unregister":
                     userName = input[1];
                    if(!infoBook.containsKey(userName)){
                        System.out.printf("ERROR: user %s not found%n",userName);
                    }else{
                        System.out.printf("%s unregistered successfully%n",userName);
                        infoBook.remove(userName);

                    }
                    break;



            }
        }
        infoBook.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));

    }
}
