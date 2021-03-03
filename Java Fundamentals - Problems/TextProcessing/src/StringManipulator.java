import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        String input = scanner.nextLine();

        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Change":
                    String charToBeRepl = tokens[1];
                    String replacement = tokens[2];
                    string = string.replaceAll(charToBeRepl,replacement);
                    System.out.println(string);
                    break;
                case "Includes":
                    String includes = tokens[1];
                    if(string.contains(includes)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String check = tokens[1];
                    if(string.endsWith(check)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    string = string.toUpperCase();
                    System.out.println(string);
                    break;
                case "FindIndex":
                    String symbol = tokens[1];
                    int index = string.indexOf(symbol);
                    System.out.println(index);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);

                    string = string.substring(startIndex,startIndex+length);
                    System.out.println(string);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
