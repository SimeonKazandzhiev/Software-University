import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FriendListMaintenance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(", ");
        List<String> list = new ArrayList<>(Arrays.asList(line));


        String input = scanner.nextLine();
        int blacklisted = 0;
        int lost = 0;

        while(!"Report".equals(input)){
            String [] tokens = input.split(" ");
            String command = tokens[0];

            switch (command){
                case "Blacklist":
                    String name = tokens[1];
                int index = list.indexOf(name);
                if(list.contains(name)){
                    list.remove(name);
                    list.add(index,"Blacklisted");
                    System.out.printf("%s was blacklisted.%n",name);
                    blacklisted++;
                }else{
                    System.out.printf("%s was not found.%n",name);
                }
                    break;
                case "Error":
                     index = Integer.parseInt(tokens[1]);
                     String oldName = list.get(index);
                     if(!list.get(index).equals("Blacklisted") && !list.get(index).equals("Lost")){
                         list.remove(index);
                         list.add(index,"Lost");
                         System.out.printf("%s was lost due to an error.%n",oldName);
                         lost++;
                     }
                     break;
                case "Change":
                    index = Integer.parseInt(tokens[1]);

                    String newName = tokens[2];
                    if(index>=0 && index<list.size()){
                        String currentName = list.get(index);
                        list.set(index,newName);
                        System.out.printf("%s changed his username to %s.%n",currentName,newName);
                    }
                    break;
            }
            input=scanner.nextLine();

        }

        System.out.printf("Blacklisted names: %d%n",blacklisted);
        System.out.printf("Lost names: %d%n",lost);
        System.out.println(String.join(" ",list));
    }
}
