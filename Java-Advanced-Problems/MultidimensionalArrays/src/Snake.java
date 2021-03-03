import java.util.Scanner;
public class Snake {
    public static int snakeRow;
    public static int snakeCol;
    public static int food;
    public static boolean  isFound = false;
    public static int eatenFood = 0;
    public static  boolean isOut = false;
    public static int  size;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];
        for (int row = 0; row < size; row++) {
            String symbols = scanner.nextLine();
            if (symbols.contains("S")) {
                snakeRow = row;
                snakeCol = symbols.indexOf("S");
            }
            field[row] = symbols.toCharArray();
        }
        while (food < 10) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    moveSnake(command,snakeRow-1,snakeCol,field);
                    break;
                case "down":
                    moveSnake(command,snakeRow+1,snakeCol,field);
                    break;
                case "left":
                    moveSnake(command,snakeRow,snakeCol-1,field);
                    break;
                case "right":
                    moveSnake(command,snakeRow,snakeCol+1,field);
                    break;
            }
            if (isOut) {
                break;
            }
        }
        if (isOut) {
            System.out.println("Game over!");
        }
        if (food >= 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + eatenFood);
        printCharMatrix(field);
    }

    private static void moveSnake(String command, int rows, int cols, char[][] field) {
        switch (command) {
            case "up":
                if (isInBounds(field, snakeRow - 1, snakeCol)) {
                    if (field[snakeRow - 1][snakeCol] == '-') {
                        field[snakeRow - 1][snakeCol] = 'S';
                        field[snakeRow][snakeCol] = '.';
                        snakeRow--;
                    } else if (field[snakeRow - 1][snakeCol] == '*') {
                        field[snakeRow - 1][snakeCol] = 'S';
                        field[snakeRow][snakeCol] = '.';
                        food++;
                        eatenFood++;
                        snakeRow--;
                    } else if (field[snakeRow - 1][snakeCol] == 'B') {
                        field[snakeRow - 1][snakeCol] = '.';
                        field[snakeRow][snakeCol] = '.';
                        for (int row = 0; row < size; row++) {
                            for (int col = 0; col < size; col++) {
                                char current = field[row][col];
                                if (current == 'B') {
                                    field[row][col] = 'S';
                                    snakeRow = row;
                                    snakeCol = col;
                                    isFound = true;
                                    break;
                                }
                            }
                            if (isFound) {
                                break;
                            }
                        }
                    }
                } else {
                    field[snakeRow][snakeCol] = '.';
                    isOut = true;
                    break;
                }
                break;
            case "down":
                if (isInBounds(field, snakeRow + 1, snakeCol)) {
                    if (field[snakeRow + 1][snakeCol] == '-') {
                        field[snakeRow + 1][snakeCol] = 'S';
                        field[snakeRow][snakeCol] = '.';
                        snakeRow++;
                    } else if (field[snakeRow + 1][snakeCol] == '*') {
                        field[snakeRow + 1][snakeCol] = 'S';
                        field[snakeRow][snakeCol] = '.';
                        food++;
                        eatenFood++;
                        snakeRow++;
                    } else if (field[snakeRow + 1][snakeCol] == 'B') {
                        field[snakeRow + 1][snakeCol] = '.';
                        field[snakeRow][snakeCol] = '.';
                        for (int row = 0; row < size; row++) {
                            for (int col = 0; col < size; col++) {
                                char current = field[row][col];
                                if (current == 'B') {
                                    field[row][col] = 'S';
                                    snakeRow = row;
                                    snakeCol = col;
                                    isFound = true;
                                    break;
                                }
                            }
                            if (isFound) {
                                break;
                            }
                        }

                    }
                } else {
                    field[snakeRow][snakeCol] = '.';
                    isOut = true;
                    break;
                }
                break;
            case "left":
                if (isInBounds(field, snakeRow, snakeCol - 1)) {
                    if (field[snakeRow][snakeCol - 1] == '-') {
                        field[snakeRow][snakeCol - 1] = 'S';
                        field[snakeRow][snakeCol] = '.';
                        snakeCol--;
                    } else if (field[snakeRow][snakeCol - 1] == '*') {
                        field[snakeRow][snakeCol - 1] = 'S';
                        field[snakeRow][snakeCol] = '.';
                        food++;
                        eatenFood++;
                        snakeCol--;
                    } else if (field[snakeRow][snakeCol - 1] == 'B') {
                        field[snakeRow][snakeCol - 1] = '.';
                        field[snakeRow][snakeCol] = '.';
                        for (int row = 0; row < size; row++) {
                            for (int col = 0; col < size; col++) {
                                char current = field[row][col];
                                if (current == 'B') {
                                    field[row][col] = 'S';
                                    snakeRow = row;
                                    snakeCol = col;
                                    isFound = true;
                                    break;
                                }
                            }
                            if (isFound) {
                                break;
                            }
                        }
                    }
                } else {
                    field[snakeRow][snakeCol] = '.';
                    isOut = true;
                    break;
                }
                break;
            case "right":
                if (isInBounds(field, snakeRow, snakeCol + 1)) {
                    if (field[snakeRow][snakeCol + 1] == '-') {
                        field[snakeRow][snakeCol + 1] = 'S';
                        field[snakeRow][snakeCol] = '.';
                        snakeCol++;
                    } else if (field[snakeRow][snakeCol + 1] == '*') {
                        field[snakeRow][snakeCol + 1] = 'S';
                        field[snakeRow][snakeCol] = '.';
                        food++;
                        eatenFood++;
                        snakeCol++;
                    } else if (field[snakeRow][snakeCol + 1] == 'B') {
                        field[snakeRow][snakeCol + 1] = '.';
                        field[snakeRow][snakeCol] = '.';
                        for (int row = 0; row < size; row++) {
                            for (int col = 0; col < size; col++) {
                                char current = field[row][col];
                                if (current == 'B') {
                                    field[row][col] = 'S';
                                    snakeRow = row;
                                    snakeCol = col;
                                    isFound = true;
                                    break;
                                }
                            }
                            if (isFound) {
                                break;
                            }
                        }
                    }
                } else {
                    field[snakeRow][snakeCol] = '.';
                    isOut = true;
                    break;
                }
                break;
        }

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

}
