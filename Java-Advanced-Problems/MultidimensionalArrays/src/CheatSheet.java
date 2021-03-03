import java.util.Arrays;
import java.util.Scanner;

public class CheatSheet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] firstMatrix = readAndFillMatrix(scanner);
        int[][] secondMatrix = readAndFillMatrix(scanner);

        boolean areEqual = compareMatrices(firstMatrix,secondMatrix);
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row <firstMatrix.length ; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr =secondMatrix[row];
            if(firstArr.length != secondArr.length){
                return false;
            }
            for (int col = 0; col <firstArr.length ; col++) {
                if(firstArr[col] != secondArr[col]){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] readAndFillMatrix (Scanner scanner){
        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];
        // Пълнене на матрица 1-ви начин:
        for (int row = 0; row <rows ; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        return matrix;
        //  Пълнене на матрица 2-ри начин:
        /* for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < line.length; col++) {
                firstMatrix[row][col] = Integer.parseInt(line[col]);
            }
        }*/
    }


    public static char[][] readCharMatrix (Scanner scanner , int rows , int cols){
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] =symbols[col].charAt(0);
            }
        }
        return matrix;
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

    public static void printCharMatrix (char[][] matrix){ // Ако искам да принтирам друг вид матрица просто сменям типа !!!!
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}
