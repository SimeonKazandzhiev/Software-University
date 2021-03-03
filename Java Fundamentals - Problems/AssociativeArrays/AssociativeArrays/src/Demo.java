import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        Map<String, Integer> junk = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        boolean isObtained = false;

        while (!isObtained) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int i = 0; i < inputLine.length; i += 2) {
                int quantity = Integer.parseInt(inputLine[i]);
                String item = inputLine[i + 1].toLowerCase();

                if (keyMaterials.containsKey(item)) {
                    keyMaterials.putIfAbsent(item, 0);
                    int newQuantity = keyMaterials.get(item) + quantity;
                    keyMaterials.put(item, newQuantity);
                    if (keyMaterials.get(item) >= 250) {
                        int leftQuantity = keyMaterials.get(item) - 250;
                        keyMaterials.put(item, leftQuantity);
                        switch (item) {
                            case "Shadowmourne":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "Valanyr":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "Dragonwrath":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        isObtained = true;

                    }

                } else {
                    junk.putIfAbsent(item, 0);
                    int newQuantity = junk.get(item) + quantity;
                    junk.put(item, newQuantity);
                }
                if (isObtained) {
                    break;
                }
            }


        }
        keyMaterials.entrySet()
                .stream()
                .sorted((k1, k2) -> {
                    int result = k2.getValue().compareTo(k1.getValue());
                    if (result == 0) {
                        result = k1.getKey().compareTo(k2.getKey());
                    }
                    return result;
                }).forEach(k -> System.out.println(String.format("%s: %d", k.getKey(), k.getValue())));

        junk.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
