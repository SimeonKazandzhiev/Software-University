
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([#|])(?<name>[A-Za-z\\s]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<cal>\\d{1,5})\\1";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();

        Matcher matcher = pattern.matcher(input);
        int sum = 0;
        while (matcher.find()){
            int calories =Integer.parseInt(matcher.group("cal"));
            sum+=calories;
        }
        int days = sum/2000;
        System.out.printf("You have food to last you for: %d days!%n",days);
        Matcher matcher2 = pattern.matcher(input);
        while (matcher2.find()){
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n",
                    matcher2.group("name"),matcher2.group("date"),matcher2.group("cal"));
        }

    }
}
