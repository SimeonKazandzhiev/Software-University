import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        List<String> list = new ArrayList<>(Arrays.asList(input));


        String line = scanner.nextLine();

        while(!"Craft!".equals(line)){
            String[] tokens = line.split(" - ");
            String command = tokens[0];
            String item = tokens[1];
            switch (command){
                case "Collect":

                    if(!list.contains(item))
                        list.add(item);
                    break;
                case "Drop":
                    if(list.contains(item)){
                        list.remove(item);
                    }
                    break;
                case "Combine Items":
                    String [] items = item.split(":");
                    String oldItem = items[0];
                    String newItem = items[1];


                    if(list.contains(oldItem)){
                        int index = list.indexOf(oldItem);
                        list.add(index+1,newItem);
                    }
                    break;
                case "Renew":

                    if(list.contains(item)){
                        list.remove(item);
                        list.add(item);
                    }


                    break;

            }

            line=scanner.nextLine();
        }
        System.out.println(String.join(", ",list));
    }
}
