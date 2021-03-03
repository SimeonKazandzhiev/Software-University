import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String input = scanner.nextLine();

        while (!"Done".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            StringBuilder sb = new StringBuilder();
            switch (command){
                case "TakeOdd":
                    if(password.length()>0){
                        for (int i = 1; i < password.length(); i+=2) {
                            char symbol = password.charAt(i);
                            sb.append(symbol);
                        }
                    }
                    password = sb.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                   String cut = password.substring(index,index+length);
                   password = password.replaceFirst(cut,"");
                    System.out.println(password);

                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    if(password.contains(substring)){
                        password = password.replaceAll(substring,replacement);
                        System.out.println(password);
                    }else{
                        System.out.println("Nothing to replace!");
                    }

                    break;
            }
            input=scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
