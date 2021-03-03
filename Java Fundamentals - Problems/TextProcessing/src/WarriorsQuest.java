import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();

        while (!"For Azeroth".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "GladiatorStance":
                    StringBuilder sb = new StringBuilder(message);
                    String replace = sb.substring(0, sb.length()).toUpperCase();
                    message = sb.replace(0, sb.length(), replace).toString();
                    System.out.println(message);
                    break;
                case "DefensiveStance":
                    StringBuilder newOne = new StringBuilder(message);
                    String replaceD = newOne.substring(0, newOne.length()).toLowerCase();
                    message = newOne.replace(0, newOne.length(), replaceD).toString();
                    System.out.println(message);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];
                    if (index >= 0 && index < message.length()) {

                        StringBuilder sb1 = new StringBuilder(message);
                        message = sb1.replace(index, index + 1, letter).toString();
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }
                    break;
                case "Target":
                    if (tokens[1].equals("Change")) {
                        String substring = tokens[2];
                        String secondSub = tokens[3];
                        message = message.replace(substring, secondSub);
                        System.out.println(message);
                    } else if (tokens[1].equals("Remove")) {
                        String substring = tokens[2];
                        message = message.replace(substring, "");
                        System.out.println(message);
                    } else {
                        System.out.println("Command doesn't exist!");
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;

            }
            input = scanner.nextLine();
        }

    }
}
