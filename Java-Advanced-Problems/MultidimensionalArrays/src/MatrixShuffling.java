
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);


        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr =scanner.nextLine().split("\\s+");
            matrix[row] = arr;
        }

        String input ;
        while (!"END".equals(input=scanner.nextLine())){
            String[] tokens = input.split("\\s+");


            if(!input.startsWith("swap") || tokens.length!=5){
                System.out.println("Invalid input!");
                continue;
            }
                int rowIndex1 = Integer.parseInt(tokens[1]);
                int colIndex1 = Integer.parseInt(tokens[2]);
                int rowIndex2 = Integer.parseInt(tokens[3]);
                int colIndex2 = Integer.parseInt(tokens[4]);

                if(isOutOfBounds(matrix,rowIndex1,colIndex1) && isOutOfBounds(matrix,rowIndex2,colIndex2)){
                    System.out.println("Invalid input!");

                }else{
                    String oldValue = matrix[rowIndex1][colIndex1];
                    matrix[rowIndex1][colIndex1] = matrix[rowIndex2][colIndex2];
                    matrix[rowIndex2][colIndex2] = oldValue;

                    printMatrix(matrix);
                }
        }


    }
    public static void printMatrix (String [][] matrix){ // Ако искам да принтирам друг вид матрица просто сменям типа !!!!
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static boolean isInBounds(String[][] matrix, int row, int col) {
        return row >=0 && row <matrix.length && col>=0 && col <matrix.length;
    }
    public static boolean isOutOfBounds (String[][] matrix, int row, int col){
        return !isInBounds(matrix,row,col);
    }

}
