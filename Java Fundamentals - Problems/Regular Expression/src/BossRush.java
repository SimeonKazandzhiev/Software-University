import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^\\|(?<boss>[A-Z]{4,})\\|:[#](?<title>[A-Z][a-z]+ [a-z]+)[#]$";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String bossName = matcher.group("boss");
                String title = matcher.group("title");
                System.out.printf("%s, The %s%n",bossName,title);
                System.out.printf(">>>Strength: %d%n",bossName.length());
                System.out.printf(">>>Armour: %d%n",title.length());
            }else{
                System.out.println("Access denied!");
            }
        }

    }
}
