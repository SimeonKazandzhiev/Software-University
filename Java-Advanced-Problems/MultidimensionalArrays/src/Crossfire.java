import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                numbers.add(counter++);
            }
            matrix.add(numbers);
        }
        String command = "";
        while (!(command = scanner.nextLine()).equals("Nuke it from orbit")){
            int[] tokens = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int targetRow = tokens[0];
            int targetCol = tokens[1];
            int radius = tokens[2];

            for (int row = targetRow - radius; row <= targetRow + radius ; row++) {
                if(isValid(row,targetCol,matrix)){
                    matrix.get(row).set(targetCol,0);
                }
            }
            for (int col = targetCol - radius; col <= targetCol + radius ; col++) {
                if(isValid(targetRow,col,matrix)){
                    matrix.get(targetRow).set(col,0);
                }
            }

            for (int i = 0; i < matrix.size(); i++) {
                matrix.get(i).removeAll(new ArrayList<Integer>(){{add(0);}});
                if(matrix.get(i).size() == 0){
                    matrix.remove(i);
                    i--;
                }
            }
        }
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    private static boolean isValid(int row, int col, List<List<Integer>> matrix) {
        return row>=0 && row < matrix.size() && col>=0 && col < matrix.get(row).size();
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >=0 && row <matrix.length && col>=0 && col <matrix[row].length;
    }

    public static boolean isOutOfBounds (int[][] matrix, int row, int col){
        return !isInBounds(matrix,row,col);
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
