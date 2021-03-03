import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String line = scanner.nextLine();

        while (!line.equals("Reveal")) {
            String[] tokens = line.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    StringBuilder sb = new StringBuilder(message);
                    message = sb.insert(index, " ").toString();

                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    if (message.contains(substring)) {
                        message = message.replaceFirst(substring, "").concat(new StringBuilder(substring).reverse().toString());
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String sub = tokens[1];
                    String replacement = tokens[2];
                    while(message.contains(sub))
                        message = message.replaceAll(sub,replacement);
                    System.out.println(message);

                    break;
            }
            line = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);

    }
}
