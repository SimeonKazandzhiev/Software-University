package GenericBox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>>  {

   private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }
    public void swap(int indexOne , int secondIndex){
        T first = this.data.get(indexOne);
        T second = this.data.get(secondIndex);
        this.data.set(indexOne,second);
        this.data.set(secondIndex,first);


    }
    public void add(T element){
        this.data.add(element);
    }
    public int count(T element){
        return (int) this.data.stream().filter(e -> e.compareTo(element) >0).count();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : data) {
           sb.append(element.getClass().getName()).append(": ").append(element).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
