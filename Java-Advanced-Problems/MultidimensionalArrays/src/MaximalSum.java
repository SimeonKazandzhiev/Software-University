import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
       int[][] biggestMatrix =   biggestMatrix3x3InMatrix(matrix,rows,cols);
       int sum =   sumOfMatrix(biggestMatrix,3,3);

        System.out.println("Sum = " + sum);
        printMatrix(biggestMatrix);


    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] biggestMatrix3x3InMatrix(int[][] matrix, int rows, int cols) {
        int maxSum = Integer.MIN_VALUE;
        int[][] biggestMatrix = new int[3][3];
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    biggestMatrix[0][0] = matrix[row][col];
                    biggestMatrix[0][1] = matrix[row][col + 1];
                    biggestMatrix[0][2] = matrix[row][col + 2];
                    biggestMatrix[1][0] = matrix[row + 1][col];
                    biggestMatrix[1][1] = matrix[row + 1][col + 1];
                    biggestMatrix[1][2] = matrix[row + 1][col + 2];
                    biggestMatrix[2][0] = matrix[row + 2][col];
                    biggestMatrix[2][1] = matrix[row + 2][col + 1];
                    biggestMatrix[2][2] = matrix[row + 2][col + 2];
                }
            }

        }
        return biggestMatrix;
    }
    public static int sumOfMatrix(int[][]matrix,int rows,int cols){
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum+=matrix[row][col];
            }
        }

        return sum;
    }
}
