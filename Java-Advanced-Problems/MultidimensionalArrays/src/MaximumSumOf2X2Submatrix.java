import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[][] biggestMatrix = new int[2][2];
        int biggestSum = Integer.MIN_VALUE;
        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < cols-1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1];
                if(currentSum > biggestSum){
                    biggestSum = currentSum;
                    biggestMatrix[0][0] = matrix[row][col];
                    biggestMatrix[0][1] = matrix[row][col+1];
                    biggestMatrix[1][0] = matrix[row+1][col];
                    biggestMatrix[1][1] = matrix[row+1][col+1];
                }

            }
        }

        for (int row = 0; row <biggestMatrix.length ; row++) {
            for (int col = 0; col < biggestMatrix[row].length; col++) {
                System.out.print(biggestMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(biggestSum);
    }
}
