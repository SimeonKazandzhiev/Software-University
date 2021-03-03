import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row <size ; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        for (int index = 0; index < size; index++) {
            System.out.print(matrix[index][index] + " ");
        }
        System.out.println();
        for (int index = 0; index < size; index++) {
            System.out.print(matrix[(size - 1)-index][index] + " ");
        }


    }
}
