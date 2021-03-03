import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("!");
        List<String> list = new ArrayList<>(Arrays.asList(input));


        String command = scanner.nextLine();
        while(!"Go Shopping!".equals(command)){
            String[] tokens = command.split(" ");

            String action = tokens[0];
            String item = tokens[1];


            switch (action){
                case "Urgent":
                    if(!list.contains(item)){
                        list.add(0,item);
                    }
                    break;
                case "Unnecessary":
                    if(list.contains(item)){
                        list.remove(item);
                    }
                    break;
                case "Correct":
                    String newItem = tokens[2];
                    if(list.contains(item)){
                        int index = list.indexOf(item);
                        list.set(index,newItem);
                    }
                    break;
                case "Rearrange":
                    if(list.contains(item)){
                        list.remove(item);
                        list.add(item);
                    }
                    break;
            }

            command=scanner.nextLine();
        }
        System.out.println(String.join(", ",list));
    }
}
