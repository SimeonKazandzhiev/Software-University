import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> heroes = new HashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "Enroll":
                    if(heroes.containsKey(heroName)){
                        System.out.printf("%s is already enrolled.%n",heroName);
                    }else {
                        heroes.put(heroName,new ArrayList<>());
                    }
                    break;
                case "Learn":
                    String spellName = tokens[2];
                    if(!heroes.containsKey(heroName)){
                        System.out.printf("%s doesn't exist.%n",heroName);
                    }else {
                        List<String> spells = heroes.get(heroName);
                        if(spells.contains(spellName)){
                            System.out.printf("%s has already learnt %s.%n",heroName,spellName);
                        }else {
                            spells.add(spellName);
                        }
                    }
                    break;
                case "Unlearn":
                    String spell = tokens[2];
                    if(!heroes.containsKey(heroName)){
                        System.out.printf("%s doesn't exist.%n",heroName);
                    }else {
                        List<String> spells = heroes.get(heroName);
                        if(!spells.contains(spell)){
                            System.out.printf("%s doesn't know %s.%n",heroName,spell);
                        }else {
                            spells.remove(spell);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Heroes:");
        heroes.entrySet().stream()
                .sorted((h1,h2) -> {
                    int result =Integer.compare(h2.getValue().size(),h1.getValue().size());
                    if(result == 0){
                        result = h1.getKey().compareTo(h2.getKey());
                    }
                    return result;
                }).forEach(h -> {
                    String name = h.getKey();
                    List<String> spell = h.getValue();
            System.out.print("== " + name + ": ");
            System.out.println(String.join(", ",spell));

        });
    }
}
