import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] inputNums = scanner.nextLine().split(" ");
      List <Integer> numbersPainting = new ArrayList<>();
        for (String inputNum : inputNums) {
            numbersPainting.add(Integer.parseInt(inputNum));
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String [] command = input.split("\\s+");

            switch (command[0]) {
                case "Change":
                    int firstValue = Integer.parseInt(command[1]);
                    int changedValue = Integer.parseInt(command[2]);
                    if (numbersPainting.contains(firstValue)) {
                        int indexFirstValue = numbersPainting.indexOf(firstValue);

                        numbersPainting.set(indexFirstValue, changedValue);
                    }

                    break;
                case "Hide":
                    int numPaintToHide = Integer.parseInt(command[1]);

                    if (numbersPainting.contains(numPaintToHide)) {
                        numbersPainting.remove(Integer.valueOf(numPaintToHide));
                    }
                    break;
                case "Switch":
                    int firstNum = Integer.parseInt(command[1]);
                    int secondNum = Integer.parseInt(command[2]);

                    if (numbersPainting.contains(firstNum) && numbersPainting.contains(secondNum)) {
                        int indexOne = numbersPainting.indexOf(firstNum);
                        int indexTwo = numbersPainting.indexOf(secondNum);

                        int valueOne = numbersPainting.get(indexOne);
                        int valueTwo = numbersPainting.get(indexTwo);

                        numbersPainting.set(indexOne, valueTwo);
                        numbersPainting.set(indexTwo, valueOne);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[1]);
                    int paintingNum = Integer.parseInt(command[2]);

                    if (index+1<numbersPainting.size()) {
                        numbersPainting.add(index+1, paintingNum);
                    }
                    break;

                case "Reverse":
                    Collections.reverse(numbersPainting);
                    break;
                default:

            }
            input = scanner.nextLine();
        }

        for (Integer integer : numbersPainting) {
            System.out.print(integer + " ");
            // System.out.println(numbersPainting.toString().replaceAll("[\\[\\],]", ""));
        }
    }


}
