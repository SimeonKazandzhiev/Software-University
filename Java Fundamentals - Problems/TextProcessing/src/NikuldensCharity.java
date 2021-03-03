import java.util.Scanner;

public class NikuldensCharity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Finish".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Replace":
                    String old = tokens[1];
                    String newChar = tokens[2];
                    message = message.replaceAll(old, newChar);
                    System.out.println(message);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < message.length() && endIndex >= 0 && endIndex < message.length()) {
                        StringBuilder sb = new StringBuilder(message);
                        message = sb.replace(startIndex, endIndex + 1, "").toString();
                        System.out.println(message);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
                case "Make":
                    if (tokens[1].equals("Upper")) {
                        message = message.toUpperCase();
                        System.out.println(message);
                    } else if (tokens[1].equals("Lower")) {
                        message = message.toLowerCase();
                        System.out.println(message);
                    }
                    break;
                case "Check":
                    String check = tokens[1];
                    if (message.contains(check)) {
                        System.out.println("Message contains " + check);
                    } else {
                        System.out.println("Message doesn't contain " + check);
                    }
                    break;
                case "Sum":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);
                    if (start >= 0 && start < message.length() && end >= 0 && end < message.length()) {
                        int total = 0;
                        String sum = message.substring(start, end + 1);
                        for (int i = 0; i < sum.length(); i++) {
                            total += sum.charAt(i);
                        }
                        System.out.println(total);

                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }

    }
}
