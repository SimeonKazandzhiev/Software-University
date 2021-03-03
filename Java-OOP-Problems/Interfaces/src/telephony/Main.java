package telephony;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] calling = scanner.nextLine().split("\\s+");
        List<String> numbers = new LinkedList<>(Arrays.asList(calling));

        String[] sites = scanner.nextLine().split("\\s+");
        List<String> websites = new LinkedList<>(Arrays.asList(sites));



        Smartphone smartphone = new Smartphone(numbers,websites);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());


    }
}
