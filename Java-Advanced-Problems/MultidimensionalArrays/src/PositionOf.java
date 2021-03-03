import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int [][] matrix = new int[rows][cols];
        boolean isFound = false;
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }
        int number = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];
                if(number == currentNumber){
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }

    }

    public static int[][] readAndFillMatrix (Scanner scanner){
        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row <rows ; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        return matrix;

    }
}
