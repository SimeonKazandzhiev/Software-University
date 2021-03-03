import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];

            courses.putIfAbsent(courseName,new ArrayList<>());
            List<String> students = courses.get(courseName);
            students.add(studentName);
            // или
            // courses.get(courseName).add(studentName);


            input = scanner.nextLine();
        }
        courses
                .entrySet()
                .stream()
                .sorted((c1,c2) -> Integer.compare(c2.getValue().size(),c1.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n",entry.getKey(),entry.getValue().size());

                    entry
                            .getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(s -> System.out.printf("-- %s%n",s));
                });


    }
}



