
import java.util.Scanner;

public class Bee {

    public static int beeRow;
    public static int beeCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        int flowers = 0;
        for (int row = 0; row < size; row++) {
            String symbols = scanner.nextLine();
            if (symbols.contains("B")) {
                beeRow = row;
                beeCol = symbols.indexOf("B");
            }
            field[row] = symbols.toCharArray();
        }
        boolean lost = false;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    if (isInBounds(field, beeRow - 1, beeCol)) {
                        if (field[beeRow - 1][beeCol] == 'f') {
                            flowers++;
                            field[beeRow - 1][beeCol] = 'B';
                            field[beeRow][beeCol] = '.';
                            beeRow--;
                        } else if (field[beeRow - 1][beeCol] == 'O') {
                            if (isInBounds(field, beeRow - 1, beeCol)) {
                                if(field[beeRow - 2][beeCol] == 'f'){
                                    flowers++;
                                }
                                field[beeRow - 2][beeCol] = 'B';
                                field[beeRow - 1][beeCol] = '.';
                                field[beeRow][beeCol] = '.';
                                beeRow--;
                                beeRow--;
                            }
                        }else if(field[beeRow - 1][beeCol] == '.'){
                            field[beeRow - 1][beeCol] = 'B';
                            field[beeRow][beeCol] = '.';
                            beeRow--;
                        }
                    } else {
                        field[beeRow][beeCol] = '.';
                        lost = true;
                        break;
                    }

                    break;
                case "down":
                    if (isInBounds(field, beeRow + 1, beeCol)) {
                        if (field[beeRow + 1][beeCol] == 'f') {
                            flowers++;
                            field[beeRow + 1][beeCol] = 'B';
                            field[beeRow][beeCol] = '.';
                            beeRow++;
                        } else if (field[beeRow + 1][beeCol] == 'O') {
                            if (isInBounds(field, beeRow + 1, beeCol)) {
                                if(field[beeRow + 2][beeCol] == 'f'){
                                    flowers++;
                                }
                                field[beeRow + 2][beeCol] = 'B';
                                field[beeRow + 1][beeCol] = '.';
                                field[beeRow][beeCol] = '.';
                                beeRow++;
                                beeRow++;
                            }
                        }else if(field[beeRow + 1][beeCol] == '.'){
                            field[beeRow + 1][beeCol] = 'B';
                            field[beeRow][beeCol] = '.';
                            beeRow++;
                        }
                    } else {
                        field[beeRow][beeCol] = '.';
                        lost = true;
                        break;
                    }

                    break;
                case "left":
                    if (isInBounds(field, beeRow , beeCol-1)) {
                        if (field[beeRow ][beeCol-1] == 'f') {
                            flowers++;
                            field[beeRow ][beeCol-1] = 'B';
                            field[beeRow][beeCol] = '.';
                            beeCol--;
                        } else if (field[beeRow ][beeCol-1] == 'O') {
                            if (isInBounds(field, beeRow, beeCol-1)) {
                                if(field[beeRow ][beeCol-2] == 'f'){
                                    flowers++;
                                }
                                field[beeRow ][beeCol-2] = 'B';
                                field[beeRow ][beeCol-1] = '.';
                                field[beeRow][beeCol] = '.';
                                beeCol--;
                                beeCol--;
                            }
                        }else if(field[beeRow ][beeCol-1] == '.'){
                            field[beeRow][beeCol-1] = 'B';
                            field[beeRow][beeCol] = '.';
                            beeCol--;
                        }
                    } else {
                        field[beeRow][beeCol] = '.';
                        lost = true;
                        break;
                    }

                    break;
                case "right":
                    if (isInBounds(field, beeRow , beeCol+1)) {
                        if (field[beeRow ][beeCol+1] == 'f') {
                            flowers++;
                            field[beeRow ][beeCol+1] = 'B';
                            field[beeRow][beeCol] = '.';
                            beeCol++;
                        } else if (field[beeRow ][beeCol+1] == 'O') {
                            if (isInBounds(field, beeRow, beeCol+1)) {
                                if(field[beeRow ][beeCol+2] == 'f'){
                                    flowers++;
                                }
                                field[beeRow ][beeCol+2] = 'B';
                                field[beeRow ][beeCol+1] = '.';
                                field[beeRow][beeCol] = '.';
                                beeCol++;
                                beeCol++;
                            }
                        }else if(field[beeRow ][beeCol+1] == '.'){
                            field[beeRow][beeCol+1] = 'B';
                            field[beeRow][beeCol] = '.';
                            beeCol++;
                        }
                    } else {
                        field[beeRow][beeCol] = '.';
                        lost = true;
                        break;
                    }
                    break;
            }
            if(lost){
                break;
            }

            command = scanner.nextLine();
        }
        if(lost){
            System.out.println("The bee got lost!");
        }
        if(flowers <5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",5-flowers);
        }else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",flowers);
        }

        printCharMatrix(field);

    }

    public static char[][] readCharMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }
        return matrix;
    }

    public static void printCharMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return !isInBounds(matrix, row, col);
    }
}
