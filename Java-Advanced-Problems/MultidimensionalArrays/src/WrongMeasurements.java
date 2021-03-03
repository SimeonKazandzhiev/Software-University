import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }
        int[] indexesValue = readArray(scanner, "\\s+");
        int wrongValue = matrix[indexesValue[0]][indexesValue[1]];

        List<int[]> indexes = new ArrayList<>();
        List<Integer> correctValue = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    indexes.add(new int[]{row, col});
                    correctValue.add(getCorrectValue(matrix, row, col));
                }
            }
        }
        for (int i = 0; i < indexes.size(); i++) {
            int[] rowsAndCols = indexes.get(i);
            matrix[rowsAndCols[0]][rowsAndCols[1]] = correctValue.get(i);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getCorrectValue(int[][] matrix, int row, int col) {
        int sum = 0;

        int wrongValue = matrix[row][col];

        if (isInBounds(matrix,row - 1 , col) && wrongValue != matrix[row - 1][col]) {
            sum += matrix[row - 1][col];
        }
        if (isInBounds(matrix,row + 1 , col) &&wrongValue != matrix[row + 1][col]) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(matrix,row  , col-1) && wrongValue != matrix[row][col - 1]) {
            sum += matrix[row][col - 1];
        }
        if (isInBounds(matrix,row  , col + 1)  && wrongValue != matrix[row][col + 1]) {
            sum += matrix[row][col + 1] ;
        }

        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >=0 && row <matrix.length && col>=0 && col <matrix[row].length;
    }

    public static boolean isOutOfBounds (int[][] matrix, int row, int col){
        return !isInBounds(matrix,row,col);
    }

    public static int[] readArray(Scanner scanner, String separator) {
        return Arrays.stream(scanner.nextLine().split(separator))
                .mapToInt(Integer::parseInt)
                .toArray();

    }
}
