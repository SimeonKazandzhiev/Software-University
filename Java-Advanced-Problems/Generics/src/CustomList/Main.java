package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        CustomList<String> list = new CustomList<String>();
        while (!line.equals("END")){
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Add":
                    String element = tokens[1];
                    list.add(element);
                    break;
                case "Remove":
                    int elementToRemove =Integer.parseInt( tokens[1]);
                    list.remove(elementToRemove);
                    break;
                case "Contains":
                    String elementToCheck = tokens[1];
                    System.out.println(list.contains(elementToCheck));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    list.swap(firstIndex,secondIndex);
                    break;
                case "Greater":
                    String elementToCompare = tokens[1];
                    System.out.println(list.countGreaterThan(elementToCompare));
                    break;
                case "Max":
                    System.out.println(list.max());
                    break;
                case "Min":
                    System.out.println(list.min());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
