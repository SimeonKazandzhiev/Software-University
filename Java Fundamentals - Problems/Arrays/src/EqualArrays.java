import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");
        int[] firstNums = new int[firstArr.length];
        int[] secondNums = new int[secondArr.length];


        for (int i = 0; i < firstNums.length; i++) {
            firstNums[i] = Integer.parseInt(firstArr[i]);
        }
        for (int i = 0; i < secondNums.length; i++) {
            secondNums[i] = Integer.parseInt(secondArr[i]);
        }
        int sum = 0;
        boolean identical = true;
        for (int i = 0; i < firstNums.length ; i++) {
            if(firstNums[i] == secondNums[i]){
                sum+=firstNums[i];
            }else {
                System.out.printf("Arrays are not identical. Found difference at %d index.",i);
                identical = false;
                break;
            }
        }
        if(identical)
        System.out.println(sum);
        }
    }


