
import java.util.*;

public class CharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<Character,Integer> countsChars = new LinkedHashMap<>();


        String input = scanner.nextLine();

        for (int i = 0; i < input.length() ; i++) {
            char current = input.charAt(i);
            if(!Character.isWhitespace(current)){
                if(!countsChars.containsKey(current)){
                    countsChars.put(current,0);
                }
                int newCurrent = countsChars.get(current)+1;
                countsChars.put(current,newCurrent);
            }
        }
        for (Map.Entry<Character, Integer> entry : countsChars.entrySet()) {
            System.out.printf("%c -> %d%n",entry.getKey(),entry.getValue());
        }

    }
}
