package CustomList;

public class Sorter<T extends Comparable<T>> {
    public static <T extends Comparable<T>> void sort(CustomList<T> list){
        // Bubble sort //
        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            for (int j = i+ 1; j < list.size(); j++) {
                T nextElement = list.get(j);
                if(element.compareTo(nextElement) > 0){
                    list.swap(i,j);
                }
            }
        }


    }
}
