import java.util.Scanner;

public class CheatSheets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*

        -----Принтиране и сортиране на мап(String,Integer)
        Сортиране по стойност(VALUE) във низходящ ред(винаги започваме да сравняваме от 2рия елемент със 1вия)
            mapName
                    .entrySet()
                    .stream()
                    .sorted((item1, item2) -> {
                        int result = item2.getValue().compareTo(item1.getValue());
                        if(result ==0){
                        result = item1.getKey().compareTo(item2.getKey()
                        }
                        return result;
                         })
                     .forEach(item -> System.out.println(String.format("%s: %d,item.getKey(),item.getValue())));



         ------Принтиране и сортиране на мап(String,Integer)
            Сортиране по KEY и азбучен ред.

            mapName
                    .entrySet()
                    .stream()
                    .sorted((item1,item2) -> item1.getKey().compareTo(item2.getKey()))
                    .forEach(item -> System.out.println(String.format("%s: %d",item.getKey(),item.getValue())));



         ------Принтиране и сортиране на мап(String, List<String)(като сортирам във низходящ ред по дължината на листа)
           mapName
                .entrySet()
                .stream()
                .sorted((c1,c2) -> Integer.compare(c2.getValue().size(),c1.getValue().size()))
                .forEach(entry -> {
                    System.out.println(String.format("%s: %d",entry.getKey(),entry.getValue().size()));
                });


          -------Принтиране и сортиране на мап (String, List<Double>) със намиране на средна оценка и низходящ ред

          mapName
                .entrySet()
                .stream()
                .filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >=4.50)
                .sorted((s1,s2) -> {
                    double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = s2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(second,first);
                })
                .forEach(s -> System.out.println(String.format("%s -> %.2f",s.getKey(),
                        s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble())));




        ****
        Когато имам задача със четене на вход
            и не знаем колко реда ще получим и
            нямаме условие за приклучване на цикъла
            използваме BOOLEAN променлива която слагаме
            във WHILE цикъла
        ****


        -----Метод за добавяне към МАП(String,Integer)
        private static void addToMap(Map<String, Integer> map, String item, int quantity) {
        map.putIfAbsent(item,0);
        int newQuantity = map.get(item) + quantity;
        map.put(item,newQuantity);

    }

         */




















    }
}