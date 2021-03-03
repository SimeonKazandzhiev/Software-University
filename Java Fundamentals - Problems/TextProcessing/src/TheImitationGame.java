import java.util.Scanner;
public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] tokens = input.split("[|]");
            String command = tokens[0];
            switch (command) {
                case "Move":
                    int number = Integer.parseInt(tokens[1]);
                    String toBeMoved = message.substring(0, number);
                    message = message.replace(toBeMoved, "");
                    message = message + toBeMoved;
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    StringBuilder sb = new StringBuilder(message);
                    message = sb.insert(index, value).toString();
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    while (message.contains(substring)) {
                        message = message.replace(substring, replacement);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }
}
