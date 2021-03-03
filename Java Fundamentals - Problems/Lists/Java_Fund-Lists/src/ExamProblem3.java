import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExamProblem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int entryPoint = Integer.parseInt(scanner.nextLine());
        String typeItems = scanner.next();
        String typeOfPrice = scanner.next();

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();


        int leftSum = 0;
        int rightSum = 0;
        int valueOfIndex = listNumbers.get(entryPoint);
        for (int i = 0; i < listNumbers.size(); i++) {
            if (i < entryPoint) {
                left.add(listNumbers.get(i));
            }
            if (i > entryPoint) {
                right.add(listNumbers.get(i));
            }
        }
        if (typeItems.equals("cheap")) {
            for (int i = 0; i < left.size(); i++) {
                if (left.get(i) < valueOfIndex) {
                    continue;
                } else {
                    left.remove(i);
                }
            }
            for (int i = 0; i < right.size(); i++) {
                if (right.get(i) < valueOfIndex) {
                    continue;
                } else {
                    right.remove(i);
                }
            }
        }
        if (typeItems.equals("expensive")) {
            for (int i = 0; i < left.size(); i++) {
                if (left.get(i) >= valueOfIndex) {
                    continue;
                } else {
                    left.remove(i);
                }
            }
            for (int i = 0; i < right.size(); i++) {
                if (right.get(i) >= valueOfIndex) {
                    continue;
                } else {
                    right.remove(i);
                }
            }
        }
        if(typeOfPrice.equals("positive")){
            for (int i = 0; i <left.size() ; i++) {
                if(left.get(i)>0){
                    leftSum+=left.get(i);
                }
            }
            for (int i = 0; i < right.size(); i++) {
                if(right.get(i)>0){
                    rightSum+=right.get(i);
                }
            }
        }
        if(typeOfPrice.equals("negative")){
            for (int i = 0; i <left.size() ; i++) {
                if(left.get(i)<0){
                    leftSum+=left.get(i);
                }
            }
            for (int i = 0; i <right.size() ; i++) {
                if(right.get(i)<0){
                    rightSum+=right.get(i);
                }
            }
        }
        if(typeOfPrice.equals("all")){
            for (int i = 0; i <left.size() ; i++) {
                leftSum+=left.get(i);

            }
            for (int i = 0; i < right.size(); i++) {
                rightSum+=right.get(i);
            }
        }
        if(leftSum > rightSum){
            System.out.printf("Left - %d",leftSum);
        }if(rightSum>leftSum){
            System.out.printf("Right - %d",rightSum);
        }if(leftSum == rightSum){
            System.out.printf("Left - %d",leftSum);
        }



    }
}
