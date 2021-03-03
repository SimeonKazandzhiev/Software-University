import java.util.*;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("&");
        List<String> list = new ArrayList<>(Arrays.asList(line));

        String input = scanner.nextLine();

        while (!input.equals("Done")){
            String [] tokens = input.split(" \\| ");
            String command = tokens[0];
            String bookName = tokens[1];

            switch (command){
                case "Add Book":
                    if(!list.contains(bookName)){
                        list.add(0,bookName);
                    }
                    break;
                case "Take Book":
                    if(list.contains(bookName)){
                        list.remove(bookName);
                    }
                    break;
                case "Swap Books":

                    String secondBook = tokens[2];


                    int indexFirst = list.indexOf(tokens[1]);
                    int indexSecond = list.indexOf(secondBook);
                    if(list.contains(tokens[1]) && list.contains(secondBook)){
                        if((indexFirst >=0 && indexFirst< list.size()) && (indexSecond>=0 && indexSecond<list.size()) ){
                            Collections.swap(list,indexFirst,indexSecond);
                        }

                    }
                    break;
                case "Insert Book":
                    list.add(bookName);
                    break;
                case "Check Book":

                    int index = Integer.parseInt(bookName);
                    if(index>=0 && index<list.size()){
                      String theBook = list.get(index);
                        System.out.println(theBook);
                    }

                    break;

            }

            input=scanner.nextLine();
        }
        System.out.println(String.join(", ",list));
    }
}
