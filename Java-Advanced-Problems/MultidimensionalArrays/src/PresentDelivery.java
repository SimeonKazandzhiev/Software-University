import java.util.Scanner;

public class PresentDelivery {

    public static int santaRow;
    public static int santaCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        for (int row = 0; row < size; row++) {
            String symbols = scanner.nextLine().replaceAll(" ", "");
            if (symbols.contains("S")) {
                santaRow = row;
                santaCol = symbols.indexOf("S");
            }
            field[row] = symbols.toCharArray();
        }
        int goodKids = 0;
        int noPresents = 0;
        boolean isOutOfField = false;
        String command = scanner.nextLine();
        while (!"Christmas morning".equals(command) && presents > 0) {
            switch (command) {
                case "up":
                    if(isInBounds(field,santaRow-1,santaCol)){
                        if(field[santaRow-1][santaCol] == 'V'){
                            goodKids++;
                            presents--;
                            field[santaRow-1][santaCol] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaRow--;
                        }else if(field[santaRow-1][santaCol] == 'X'){
                            field[santaRow-1][santaCol] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaRow--;
                        }else if(field[santaRow-1][santaCol] == '-'){
                            field[santaRow-1][santaCol] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaRow--;
                        }
                    }else {
                        field[santaRow][santaCol] = 'S';
                        isOutOfField =true;
                        break;
                    }
                    break;
                case "down":
                    if(isInBounds(field,santaRow+1,santaCol)){
                        if(field[santaRow+1][santaCol] == 'V'){
                            goodKids++;
                            presents--;
                            field[santaRow+1][santaCol] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaRow++;
                        }else if(field[santaRow+1][santaCol] == 'X'){
                            field[santaRow+1][santaCol] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaRow++;
                        }else if(field[santaRow+1][santaCol] == '-'){
                            field[santaRow+1][santaCol] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaRow++;
                        }
                    }else {
                        field[santaRow][santaCol] = 'S';
                        isOutOfField =true;
                        break;
                    }
                    break;
                case "left":
                    if(isInBounds(field,santaRow,santaCol-1)){
                        if(field[santaRow][santaCol-1] == 'V'){
                            goodKids++;
                            presents--;
                            field[santaRow][santaCol-1] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaCol--;
                        }else if(field[santaRow][santaCol-1] == 'X'){
                            field[santaRow][santaCol-1] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaCol--;
                        }else if(field[santaRow][santaCol-1] == '-'){
                            field[santaRow][santaCol-1] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaCol--;
                        }
                    }else {
                        field[santaRow][santaCol] = 'S';
                        isOutOfField =true;
                        break;
                    }
                    break;
                case "right":
                    if(isInBounds(field,santaRow,santaCol+1)){
                        if(field[santaRow][santaCol+1] == 'V'){
                            goodKids++;
                            presents--;
                            field[santaRow][santaCol+1] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaCol++;
                        }else if(field[santaRow][santaCol+1] == 'X'){
                            field[santaRow][santaCol+1] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaCol++;
                        }else if(field[santaRow][santaCol+1] == '-'){
                            field[santaRow][santaCol+1] = 'S';
                            field[santaRow][santaCol] = '-';
                            santaCol++;
                        }
                    }else {
                        field[santaRow][santaCol] = 'S';
                        isOutOfField =true;
                        break;
                    }
                    break;

            }
            if(isOutOfField){
                break;
            }


            command = scanner.nextLine();
        }
        printCharMatrix(field);
        if(isOutOfField || presents<=0){
            System.out.println("Santa ran out of presents.");
        }
        if(presents>0){
            System.out.println(String.format("Good job, Santa! %d happy nice kid/s.",goodKids));
        }

    }

    public static void printCharMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+ " ");
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
