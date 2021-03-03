import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([@#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        List<String> foundWords = new ArrayList<>();
        List<String> mirrorWords = new ArrayList<>();
        while (matcher.find()) {
            String first = matcher.group("first");
            String second = matcher.group("second");
            StringBuilder sb = new StringBuilder(matcher.group("second"));
            foundWords.add(matcher.group());
            String secondReversed = sb.reverse().toString();
            if (secondReversed.equals(first)) {
                String result = first + " <=> " + second;
                mirrorWords.add(result);
            }
        }
        if(foundWords.size()>0){
            System.out.println(String.format("%d word pairs found!", foundWords.size()));
        }else{
            System.out.println("No word pairs found!");
        }

        if (mirrorWords.size() > 0) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", " , mirrorWords));
        }else{
            System.out.println("No mirror words!");
        }
    }
}
