import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length() ; i++) {
            char symbol = words.charAt(i);
            char newSymbol = ((char) (symbol + 3));
            result.append(newSymbol);
        }
        System.out.println(result);
    }
}

