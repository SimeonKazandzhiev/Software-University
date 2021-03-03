import java.util.Scanner;
public class Garden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] gardenField = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                gardenField[row][col] = 0;
            }
        }
        String line = scanner.nextLine();
        while (!line.equals("Bloom Bloom Plow")) {
            String[] tokens = line.split("\\s+");
            int flowerRow = Integer.parseInt(tokens[0]);
            int flowerCol = Integer.parseInt(tokens[1]);
            if (isInBounds(gardenField, flowerRow, flowerCol)) {

                increaseRight(gardenField,flowerRow,flowerCol);
                increaseLeft(gardenField,flowerRow,flowerCol);
                increaseUp(gardenField,flowerRow,flowerCol);
                increaseDown(gardenField,flowerRow,flowerCol);

                gardenField[flowerRow][flowerCol] +=1;

            }else {
                System.out.println("Invalid coordinates.");
            }
            line = scanner.nextLine();
        }
        printMatrix(gardenField);
    }


    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void increaseRight(int[][] matrix, int flowerRow , int flowerCol){

        for (int row = flowerRow; row < matrix.length; row++) {
            for (int col = flowerCol + 1; col < matrix[row].length; col++) {
                matrix[row][col] += 1;
            }
            if (++row > flowerRow) {
                break;
            }
        }
    }
    public static void increaseLeft(int[][] matrix, int flowerRow , int flowerCol){
        for (int row = flowerRow; row <matrix.length ; row++) {
            for (int col = flowerCol-1; col >=0 ; col--) {
                matrix[row][col] += 1;
            }
            if (++row > flowerRow) {
                break;
            }
        }
    }
    public static void increaseUp(int[][] matrix, int flowerRow, int flowerCol){
        for (int col = flowerCol; col < matrix.length ; col++) {
            for (int row = flowerRow-1; row >=0 ; row--) {
                matrix[row][col] += 1;
            }
            if(++col > flowerCol){
                break;
            }
        }
    }
    public static void increaseDown(int[][] matrix , int flowerRow, int flowerCol){
        for (int col = flowerCol; col < matrix.length; col++) {
            for (int row = flowerRow+1; row < matrix.length ; row++) {
                matrix[row][col] += 1;
            }
            if(++col > flowerCol){
                break;
            }
        }
    }
}
