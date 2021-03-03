import java.util.Scanner;

public class ExtractFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        String file = path.substring(path.lastIndexOf("\\") +1);

        String fileName = file.substring(0,file.indexOf("."));
        String extension = file.substring(file.indexOf(".")+ 1);

        System.out.println("File name: " +fileName);
        System.out.println("File extension: " + extension);
    }
}
