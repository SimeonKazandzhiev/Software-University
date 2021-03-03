
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String threshold = "\\d";
        String Emojis = "(?>([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1)";

        Pattern thresholdPattern = Pattern.compile(threshold);
        Pattern emojisPattern = Pattern.compile(Emojis);
        String input = scanner.nextLine();
        int coolThreshold = 1;
        List<String> ValidEmojis = new ArrayList<>();
        Matcher thresholdMatch = thresholdPattern.matcher(input);

        while (thresholdMatch.find()) {
            int current = Integer.parseInt(thresholdMatch.group());
            coolThreshold *= current;
        }

        Matcher emojiMatcher = emojisPattern.matcher(input);
        while (emojiMatcher.find()) {
            String emoji = emojiMatcher.group();
            ValidEmojis.add(emoji);

        }
        System.out.println("Cool threshold: " + coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", ValidEmojis.size());

        for (String validEmoji : ValidEmojis) {
            int sum = 0;
            for (int j = 0; j < validEmoji.length(); j++) {
                char current = validEmoji.charAt(j);
                if(Character.isLetter(current)){
                    sum += current;
                }

            }
            if (sum > coolThreshold) {
                System.out.println(validEmoji);
            }
        }


    }
}

