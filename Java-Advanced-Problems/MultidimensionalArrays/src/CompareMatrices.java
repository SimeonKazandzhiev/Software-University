import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readAndFillMatrix(scanner);
        int[][] secondMatrix = readAndFillMatrix(scanner);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];
            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int col = 0; col < firstArr.length; col++) {
                if (firstArr[col] != secondArr[col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] readAndFillMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];
        // Пълнене на матрица 1-ви начин:
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        return matrix;
    }
}
