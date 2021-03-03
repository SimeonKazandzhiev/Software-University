import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRobot = scanner.nextLine().split(";");
        LinkedHashMap<String,Integer> robots=getLinkedHashMap(inputRobot);
        String time = scanner.nextLine();
        ArrayDeque<String> products = new ArrayDeque<>();

        String product = scanner.nextLine();
        int[] workingTime = new int[robots.size()];

        while (!product.equals("End")){
            products.offer(product);
            product = scanner.nextLine();
        }
        while (!products.isEmpty()){
            String currentProduct = products.poll();

            for (int i = 0; i <workingTime.length ; i++) {
                if(workingTime[i] == 0){
                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                        if(count == i){
                            workingTime[i] = robot.getValue();
                            System.out.println(robot.getKey() + " - " + currentProduct);
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }


        }


    }

    private static LinkedHashMap<String,Integer> getLinkedHashMap(String[] inputRobot) {
        LinkedHashMap<String,Integer> robots = new LinkedHashMap<>();

        for (int i = 0; i < inputRobot.length ; i++) {
            String name = inputRobot[i].split("-")[0];
            int time = Integer.parseInt(inputRobot[i].split("-")[1]);
            robots.put(name,time);
        }
        return robots;
    }
}
