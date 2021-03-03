import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Scanner;


public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> hit = new LinkedHashMap<>();
        Map<String, Integer> mana = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String input = scanner.nextLine();
            String[] heroes = input.split("\\s+");
            String heroName = heroes[0];
            int hitPoints = Integer.parseInt(heroes[1]);
            int manaPoints = Integer.parseInt(heroes[2]);
            hit.put(heroName,hitPoints);
            mana.put(heroName,manaPoints);

        }
        String inputLine= scanner.nextLine();

        while (!inputLine.equals("End")){
            String[] tokens = inputLine.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command){
                case "CastSpell":
                int mpNeeded = Integer.parseInt(tokens[2]);
                String spellName = tokens[3];
                int currentMana = mana.get(heroName);
                if(currentMana >=mpNeeded){
                    int manaLeft = mana.get(heroName) - mpNeeded;
                    mana.put(heroName,manaLeft);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n",heroName,spellName,manaLeft);
                }else {
                    System.out.printf("%s does not have enough MP to cast %s!%n",heroName,spellName);
                }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    int currentHP = hit.get(heroName);
                    currentHP-=damage;
                    if(currentHP > 0) {
                        hit.put(heroName, currentHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP);
                    }else {
                        System.out.printf("%s has been killed by %s!%n",heroName,attacker);
                        hit.remove(heroName);
                        mana.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    int currentMP = mana.get(heroName);
                    int diff =200 - mana.get(heroName);
                    if(currentMP+ amount >200){
                        mana.put(heroName,200);
                        System.out.printf("%s recharged for %d MP!%n",heroName,diff);
                    }else{
                        diff = mana.get(heroName) + amount;
                        mana.put(heroName,diff);
                        System.out.printf("%s recharged for %d MP!%n",heroName,amount);
                    }
                    break;
                case "Heal":
                    int hitAmount = Integer.parseInt(tokens[2]);
                    int currentHP2 = hit.get(heroName);
                    int diffHit = 100 - hit.get(heroName);

                    if(currentHP2 + hitAmount > 100){
                        hit.put(heroName,100);
                        System.out.printf("%s healed for %d HP!%n",heroName,diffHit);
                    }else{
                        diffHit = hit.get(heroName) + hitAmount;
                        hit.put(heroName,diffHit);
                        System.out.printf("%s healed for %d HP!%n",heroName,hitAmount);
                    }


                    break;

            }
            inputLine=scanner.nextLine();
        }

        hit.entrySet().stream()
                .sorted((h1,h2)-> {
                    int result = h2.getValue().compareTo(h1.getValue());
                    if(result == 0){
                        result = h1.getKey().compareTo(h2.getKey());
                    }
                    return result;
                }).forEach(e->{
                    String name = e.getKey();
                    int hp = e.getValue();
                    int mp = mana.get(name);
            System.out.println(name);
            System.out.printf(" HP: %d%n",hp);
            System.out.printf(" MP: %d%n",mp);
        } );
    }
}
