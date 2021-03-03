import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Followers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> likesAndComments = new HashMap<>();


        String input = scanner.nextLine();

        while (!"Log out".equals(input)) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String username = tokens[1];
            switch (command) {
                case "New follower":
                    if (!likesAndComments.containsKey(username)) {
                        likesAndComments.put(username, 0);
                    }
                    break;
                case "Like":
                    int count = Integer.parseInt(tokens[2]);
                    if (!likesAndComments.containsKey(username)) {
                        likesAndComments.put(username, count);
                    } else {
                        int currentCount = likesAndComments.get(username);
                        likesAndComments.put(username, currentCount + count);
                    }
                    break;
                case "Comment":
                    if (!likesAndComments.containsKey(username)) {
                        likesAndComments.put(username, 1);
                    } else {
                        int currentCount = likesAndComments.get(username);
                        likesAndComments.put(username, currentCount + 1);
                    }
                    break;
                case "Blocked":
                    if (likesAndComments.containsKey(username)) {
                        likesAndComments.remove(username);
                    } else {
                        System.out.println(String.format("%s doesn't exist.", username));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.format("%d followers",likesAndComments.size()));
        likesAndComments.entrySet().stream()
                .sorted((f1,f2) -> {
                    int result = Integer.compare(f2.getValue(),f1.getValue());
                    if(result == 0){
                        result = f1.getKey().compareTo(f2.getKey());
                    }
                    return result;

                }).forEach(f -> System.out.println(String.format("%s: %d",f.getKey(),f.getValue())));
    }
}
