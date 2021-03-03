import java.util.Scanner;

public class ActivationsKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();

        String input = scanner.nextLine();

        while(!"Generate".equals(input)){
            String[] tokens = input.split(">>>");
            String command = tokens[0];

            switch (command){
                case "Contains":
                    String substring = tokens[1];
                    if(key.contains(substring)){
                        System.out.printf("%s contains %s%n",key,substring);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                   if(tokens[1].equals("Upper")){
                       int startIndex = Integer.parseInt(tokens[2]);
                       int endIndex = Integer.parseInt(tokens[3]);
                       StringBuilder sb = new StringBuilder(key);
                       String replace = sb.substring(startIndex,endIndex).toUpperCase();
                       key = sb.replace(startIndex,endIndex,replace).toString();
                       System.out.println(key);
                   }else if(tokens[1].equals("Lower")){
                        int startIndex = Integer.parseInt(tokens[2]);
                        int endIndex = Integer.parseInt(tokens[3]);
                       StringBuilder sb = new StringBuilder(key);
                       String replace = sb.substring(startIndex,endIndex).toLowerCase();
                       key = sb.replace(startIndex,endIndex,replace).toString();
                       System.out.println(key);

                   }
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    StringBuilder sb = new StringBuilder(key);
                    key = sb.replace(startIndex,endIndex,"").toString();
                    System.out.println(key);

                    break;
            }

            input=scanner.nextLine();
        }
        System.out.println("Your activation key is: "+key);
    }
}
