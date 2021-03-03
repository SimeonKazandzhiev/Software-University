import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readCharMatrix(scanner,rows,cols);
        char[][] secondMatrix = readCharMatrix(scanner,rows,cols);

        char[][] outputMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(firstMatrix[row][col] == secondMatrix[row][col]){
                    outputMatrix[row][col] = firstMatrix[row][col];
                }else {
                    outputMatrix[row][col] = '*';
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <cols ; col++) {
                char symbol = outputMatrix[row][col];
                System.out.print(symbol + " ");
            }
            System.out.println();
        }

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
}
