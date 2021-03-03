import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] firstArray = new String[n];
        String[] secondArray = new String[n];

        for (int i = 0; i < n; i++) {
            String[] temp = scanner.nextLine().split(" ");
            if (i % 2 == 0){
                firstArray[i] = temp[0];
                secondArray[i] = temp[1];
            }else {
                firstArray[i]= temp[1];
                secondArray[i] = temp[0];
            }
        }
        System.out.println(String.join(" ",firstArray));
        System.out.println(String.join(" ",secondArray));
    }
}
