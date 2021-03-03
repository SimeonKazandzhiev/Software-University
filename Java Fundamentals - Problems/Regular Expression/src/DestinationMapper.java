import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([=|/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> dest = new ArrayList<>();
        int sum = 0;

        while (matcher.find()){
            String currentDest = matcher.group("destination");
            sum+=currentDest.length();
            dest.add(matcher.group("destination"));
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ",dest));
        System.out.printf("Travel Points: %d",sum);
    }
}
