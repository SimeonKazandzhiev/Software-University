import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> composers = new TreeMap<>();
        Map<String,String> keys = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
           String input = scanner.nextLine();
           String[] tokens = input.split("\\|");
           String piece = tokens[0];
           String composerName = tokens[1];
           String keyName = tokens[2];
           composers.put(piece,composerName);
           keys.put(piece,keyName);

        }

        String input =scanner.nextLine();
        while (!"Stop".equals(input)){
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            String piece = tokens[1];
            switch (command){
                case "Add":
                    String composer = tokens[2];
                    String key = tokens[3];
                    if(composers.containsKey(piece)){
                        System.out.printf("%s is already in the collection!%n",piece);
                    }else{
                        System.out.printf("%s by %s in %s added to the collection!%n",piece,composer,key);
                        composers.put(piece,composer);
                        keys.put(piece,key);
                    }
                    break;

                case "Remove":
                    if(!composers.containsKey(piece)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }else{
                        composers.remove(piece);
                        System.out.printf("Successfully removed %s!%n",piece);
                    }
                    break;

                case "ChangeKey":
                    String newKey = tokens[2];
                    if(keys.containsKey(piece)){
                        keys.put(piece,newKey);
                        System.out.printf("Changed the key of %s to %s!%n",piece,newKey);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;

            }
            input=scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : composers.entrySet()) {
            String name = entry.getKey();
            System.out.printf("%s -> Composer: %s, Key: %s%n",entry.getKey(),entry.getValue(),keys.get(name));


        }

    }
}
