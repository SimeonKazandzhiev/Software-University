
import java.util.LinkedHashMap;
import java.util.Scanner;
public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char[] unique = scanner.nextLine().toCharArray();
        char first = unique[0];
        char second = unique[1];
        char third = unique[2];

        String inputToCheck = scanner.nextLine();

        for (int i = 0; i < inputToCheck.length(); i++) {
            LinkedHashMap<Character, Integer> result = new LinkedHashMap<>();
            result.put(first, 0);
            result.put(second, 0);
            result.put(third, 0);
            StringBuilder sb = new StringBuilder();
            if (i + unique.length <= inputToCheck.length()) {
                char[] temp = inputToCheck.substring(i, i + unique.length).toCharArray();
                if (temp[0] == first) {
                    result.put(first, 1);
                    sb.append(temp[0]);
                } else if (temp[0] == second) {
                    result.put(second, 1);
                    sb.append(temp[0]);
                } else if (temp[0] == third) {
                    result.put(third,  1);
                    sb.append(temp[0]);
                }
                if (temp[1] == first) {
                    result.put(first, 1);
                    sb.append(temp[1]);
                } else if (temp[1] == second) {
                    result.put(second,1);
                    sb.append(temp[1]);
                } else if (temp[1] == third) {
                    result.put(third,  1);
                    sb.append(temp[1]);
                }
                if (temp[2] == first) {
                    result.put(first,  1);
                    sb.append(temp[2]);
                } else if (temp[2] == second) {
                    result.put(second,  1);
                    sb.append(temp[2]);
                } else if (temp[2] == third) {
                    result.put(third,  1);
                    sb.append(temp[2]);
                }
            }
            if (result.get(first) == 1 && result.get(second) == 1 && result.get(third) == 1) {
                    System.out.println(sb.toString());
                    break;
            }

        }

    }


}
