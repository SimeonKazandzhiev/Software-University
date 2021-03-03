
import java.util.Scanner;


public class demo1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();

        String input = scanner.nextLine();

        while (!"Travel".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String string = tokens[2];
                    if(index >=0 && index<stops.length()){
                        StringBuilder sb = new StringBuilder(stops);
                        stops = sb.insert(index,string).toString();

                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if((startIndex>=0 && startIndex<stops.length())&& (endIndex>=0 && endIndex<stops.length())){
                        StringBuilder sb = new StringBuilder(stops);
                        stops = sb.replace(startIndex,endIndex+1,"").toString();

                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldStr = tokens[1];
                    String newStr = tokens[2];
                  if (stops.contains(oldStr)){
                        stops = stops.replace(oldStr,newStr);
                    }
                    System.out.println(stops);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }
}
