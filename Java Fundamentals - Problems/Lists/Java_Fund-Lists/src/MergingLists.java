import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstArr = scanner.nextLine();
        String secondArr = scanner.nextLine();

        List<Integer> listOne = inputToList(firstArr);
        List<Integer> listTwo = inputToList(secondArr);

        int minLength = Math.min(listOne.size(),listTwo.size());

        for (int i = 0; i <minLength ; i++) {
            System.out.print(listOne.get(i)+ " ");
            System.out.print(listTwo.get(i)+ " ");
        }
        printAfterIndex (listOne,minLength);
        printAfterIndex (listTwo,minLength);


    }

    private static void printAfterIndex(List<Integer> list, int startIndex) {
        for (int i = startIndex; i <list.size() ; i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    private static List<Integer> inputToList(String firstArr) {
        String[] parts = firstArr.split(" ");
        List<Integer> result = new ArrayList<>();
        for (String part : parts) {
            int current = Integer.parseInt(part);
            result.add(current);
        }
        return result;
    }
}
