import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> companies = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while(!"End".equals(input)){
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String employeeID = tokens[1];

            companies.putIfAbsent(companyName,new LinkedList<>());
            List<String> list = companies.get(companyName);
            if(!list.contains(employeeID)){
                list.add(employeeID);
            }
            input=scanner.nextLine();
        }

        companies
                .entrySet()
                .stream()
                .sorted((c1,c2) -> c1.getKey().compareTo(c2.getKey()))
                .forEach(c -> {
                    System.out.println(c.getKey());
                    c.getValue().forEach(id -> System.out.println(String.format("-- %s",id)));
                });

    }
}
