package Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Team team = new Team("Black Eagles");
        List<Person> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");

            try {
                Person person = createPerson(input);
                players.add(person);

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        for (Person player : players) {
            team.addPlayer(player);
        }
        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Second team have " + team.getReserveTeam().size() + " players");
    }

    private static Person createPerson(String[] input) {
        String firstName = input[0];
        String lastName = input[1];
        int age = Integer.parseInt(input[2]);
        double salary = Double.parseDouble(input[3]);
        return new Person(firstName,lastName,age,salary);
    }
}
