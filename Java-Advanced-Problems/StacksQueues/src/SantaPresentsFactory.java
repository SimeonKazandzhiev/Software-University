import java.util.*;
import java.util.stream.Collectors;

public class SantaPresentsFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] materialsNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> materials = new ArrayDeque<>();
        for (int material : materialsNumbers) {
            materials.push(material);
        }
        int[] magics = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();
        for (int magic : magics) {
            magicLevel.offer(magic);
        }
        TreeMap<String, Integer> presents = new TreeMap<>();
        int dolls = 0;
        int trains = 0;
        int bears = 0;
        int bicycles = 0;

        while (!materials.isEmpty() && !magicLevel.isEmpty()) {
            int material = materials.peek();
            int magicLlv = magicLevel.peek();
            int sum = material * magicLlv;
            String gift;
            if (sum == 150) {
                gift = "Doll";
                presents.putIfAbsent(gift,0);
                presents.put(gift,presents.get(gift) + 1);
                materials.pop();
                magicLevel.poll();
                dolls++;
            } else if (sum == 250) {
                gift = "Wooden train";
                presents.putIfAbsent(gift,0);
                presents.put(gift,presents.get(gift) + 1);
                materials.pop();
                magicLevel.poll();
                trains++;
            } else if (sum == 300) {
                gift = "Teddy bear";
                presents.putIfAbsent(gift,0);
                presents.put(gift,presents.get(gift) + 1);
                materials.pop();
                magicLevel.poll();
                bears++;
            } else if (sum == 400) {
                gift = "Bicycle";
                presents.putIfAbsent(gift,0);
                presents.put(gift,presents.get(gift) + 1);
                materials.pop();
                magicLevel.poll();
                bicycles++;
            } else {
                if (sum < 0) {
                    int result = material + magicLlv;
                    materials.pop();
                    magicLevel.poll();
                    materials.push(result);
                } else if (sum > 0) {
                    magicLevel.poll();
                    materials.pop();
                    materials.push(material + 15);
                }
                if (material == 0) {
                    materials.pop();
                }
                if (magicLlv == 0) {
                    magicLevel.poll();
                }
            }
        }
        if ((dolls > 0 && trains > 0) || (bears > 0 && bicycles > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if(!materials.isEmpty()) {
            String materialsOutput = "Materials left: " +
                    materials.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", "));
            System.out.println(materialsOutput);

        }
        if(!magicLevel.isEmpty()){
            String magicOutput = "Magic left: " +
                    magicLevel.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", "));
            System.out.println(magicOutput);
        }
        for (Map.Entry<String, Integer> present : presents.entrySet()) {
            System.out.printf("%s: %d%n",present.getKey(),present.getValue());
        }
    }
}
