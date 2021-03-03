import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> vips = new TreeSet<>();
        Set<String> regulars = new TreeSet<>();

        String line = scanner.nextLine();
        while(!line.equals("PARTY")){
            if(Character.isDigit(line.charAt(0))){
                vips.add(line);
            }else {
                regulars.add(line);
            }
            line=scanner.nextLine();
        }
        String input = scanner.nextLine();
        while (!input.equals("END")){
            if(Character.isDigit(input.charAt(0))) {
                vips.remove(input);
            }else {
                regulars.remove(input);
            }

            input= scanner.nextLine();
        }
        System.out.println(vips.size() + regulars.size());
        for (String vip : vips) {
            System.out.println(vip);
        }
        for (String regular : regulars) {
            System.out.println(regular);
        }

    }
}
