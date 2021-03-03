import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i <numbers.size() ; i++) {
            sum+=numbers.get(i);

        }
        double average = sum* 1.0 / numbers.size() ;


        for (int i = 0; i <numbers.size() ; i++) {
            if(numbers.get(i)> average){
                result.add(numbers.get(i));

            }
        }
        List<Integer> finalLiSt = new ArrayList<>();
        Collections.sort(result);
        Collections.reverse(result);
        for (int i = 0; i < result.size(); i++) {
            if(i == 5){
                break;
            }else{
               finalLiSt.add(result.get(i));
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Integer integer : finalLiSt) {
            stringList.add(String.valueOf(integer));
        }


        if(finalLiSt.size() >1 && finalLiSt.size()<=10000 ){
            System.out.println(String.join(" ",stringList));

        }else{
            System.out.println("No");
        }

    }
}
