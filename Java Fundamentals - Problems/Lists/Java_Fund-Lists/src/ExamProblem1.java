import java.util.Scanner;

public class ExamProblem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double neededExp = Double.parseDouble(scanner.nextLine());
        int countOfBattles = Integer.parseInt(scanner.nextLine());
        int battlesDone = 0;
        double sum = 0;
        for (int i = 1; i <= countOfBattles ; i++) {
            if(sum >= neededExp){
                break;
            }
            double expPerBattle = Double.parseDouble(scanner.nextLine());
            if(i % 3 ==0){
                expPerBattle = expPerBattle + (expPerBattle*0.15);

            } if(i% 5 == 0){
                expPerBattle = expPerBattle - (expPerBattle * 0.10);

            } if(i % 15 ==0){
                expPerBattle = expPerBattle + (expPerBattle * 0.05);
            }
            sum+=expPerBattle;
            battlesDone++;
        }
        if(sum >= neededExp){
            System.out.printf("Player successfully collected his needed experience for %d battles.",battlesDone);
        }else{
            double diff = neededExp- sum;
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.",diff);
        }

    }
}
