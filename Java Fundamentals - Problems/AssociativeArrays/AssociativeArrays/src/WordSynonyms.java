import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pairsCount = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i <pairsCount ; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();


            if(synonyms.containsKey(word)){
                List<String> stringList = synonyms.get(word);
                stringList.add(synonym);
                synonyms.put(word,stringList);
            }else{
                List<String> synonymsList = new ArrayList<>();
                synonymsList.add(synonym);
                synonyms.put(word,synonymsList);
            }

        }
        for (Map.Entry<String, List<String>> entry : synonyms.entrySet()) {
            System.out.printf("%s - %s%n",entry.getKey(),entry.getValue().toString().replaceAll("[\\]\\[]",""));
        }
    }
}
