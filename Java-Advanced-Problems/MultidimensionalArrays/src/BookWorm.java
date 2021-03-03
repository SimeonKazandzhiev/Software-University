import java.util.Scanner;

public class BookWorm {

    public static int playerRow;
    public static int playerCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder string = new StringBuilder(scanner.nextLine());

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];

        for (int row = 0; row < size; row++) {
            String symbols = scanner.nextLine();
            if (symbols.contains("P")) {
                playerRow = row;
                playerCol = symbols.indexOf("P");
            }
            field[row] = symbols.toCharArray();
        }
        boolean punished = false;
        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            switch (command) {
                case "up":
                    if(isInBounds(field,playerRow-1,playerCol)){
                        if(field[playerRow-1][playerCol] != '-' ){
                            string.append(field[playerRow-1][playerCol]);
                            field[playerRow-1][playerCol] = 'P';
                            field[playerRow][playerCol] = '-';
                            playerRow--;
                        }
                        else {
                            field[playerRow-1][playerCol] = 'P';
                            field[playerRow][playerCol] = '-';
                            playerRow--;
                        }
                    }else {
                        if(string.length()>0){
                            string.deleteCharAt(string.length()-1);
                        }

                        field[playerRow][playerCol] = 'P';
                        punished = true;
                        break;
                    }
                    break;
                case "down":
                    if(isInBounds(field,playerRow+1,playerCol)){
                        if(field[playerRow+1][playerCol] != '-' ){
                            string.append(field[playerRow+1][playerCol]);
                            field[playerRow+1][playerCol] = 'P';
                            field[playerRow][playerCol] = '-';
                            playerRow++;
                        }else {
                            field[playerRow+1][playerCol] = 'P';
                            field[playerRow][playerCol] = '-';
                            playerRow++;
                        }
                    }else {
                        if(string.length()>0){
                            string.deleteCharAt(string.length()-1);
                        }
                        field[playerRow][playerCol] = 'P';
                        punished = true;
                        break;
                    }
                    break;
                case "left":
                    if(isInBounds(field,playerRow,playerCol-1)){
                        if(field[playerRow][playerCol-1] != '-' ){
                            string.append(field[playerRow][playerCol-1]);
                            field[playerRow][playerCol-1] = 'P';
                            field[playerRow][playerCol] = '-';
                            playerCol--;
                        }else {
                            field[playerRow][playerCol-1] = 'P';
                            field[playerRow][playerCol] = '-';
                            playerCol--;
                        }
                    }else {
                        if(string.length()>0){
                            string.deleteCharAt(string.length()-1);
                        }
                        field[playerRow][playerCol] = 'P';
                        punished = true;
                        break;
                    }
                    break;
                case "right":
                    if(isInBounds(field,playerRow,playerCol+1)){
                        if(field[playerRow][playerCol+1] != '-' ){
                            string.append(field[playerRow][playerCol+1]);
                            field[playerRow][playerCol+1] = 'P';
                            field[playerRow][playerCol] = '-';
                            playerCol++;
                        }
                        else {
                            field[playerRow][playerCol+1] = 'P';
                            field[playerRow][playerCol] = '-';
                            playerCol++;
                        }
                    }else {
                        if(string.length()>0){
                            string.deleteCharAt(string.length()-1);
                        }
                        field[playerRow][playerCol] = 'P';
                        punished = true;
                        break;
                    }
                    break;

            }
            if(punished){
                break;
            }


            command = scanner.nextLine();
        }
        if(string.length()>0){
            System.out.println(string);
        }
        printCharMatrix(field);
    }
    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return !isInBounds(matrix, row, col);
    }
    public static void printCharMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
