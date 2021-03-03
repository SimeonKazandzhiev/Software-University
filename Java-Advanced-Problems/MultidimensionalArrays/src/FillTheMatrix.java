import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];


        int[][] matrix = new int[size][size];

        int startNum = 1;
        if (pattern.equals("A")) {
            createMatrixPatternA(size, matrix, startNum);
        }else if(pattern.equals("B")){
            createMatrixPatternB(size, size, matrix, startNum);

        }
        printMatrix(matrix);

    }

    private static void createMatrixPatternA(int cols, int[][] matrix, int startNum) {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
               matrix[row][col] = startNum;
               startNum++;
            }
        }
    }

    private static void createMatrixPatternB(int rows, int cols, int[][] matrix, int startNum) {
        for (int col = 0; col < cols; col++) {
            if(col % 2 != 0){
                for (int row = rows -1; row >=0 ; row--) {
                    matrix[row][col] = startNum++;
                }
            }else {
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = startNum++;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
