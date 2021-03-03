import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];


        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
               if(row == col){
                   int currentSum = matrix[row][col];
                   primaryDiagonalSum +=currentSum;
               }
               if(col == size- row - 1){
                   secondaryDiagonalSum+= matrix[row][col];
               }
            }
        }
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));

    }
    public static void printMatrix (int [][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
