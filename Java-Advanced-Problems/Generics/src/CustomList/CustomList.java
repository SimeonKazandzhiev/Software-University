package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList(){
        this.list = new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }
    public T remove(int index){
        validateIndex(index);
        return this.list.remove(index);
    }
    public boolean contains(T element){
        return this.list.contains(element);
    }
    public void swap(int indexOne , int secondIndex){
        validateIndex(indexOne);
        validateIndex(secondIndex);
        T first = this.list.get(indexOne);
        T second = this.list.get(secondIndex);
        this.list.set(indexOne,second);
        this.list.set(secondIndex,first);
    }
    public int countGreaterThan(T element){
        return (int) this.list.stream().filter(e -> e.compareTo(element) >0).count();
    }
    public T max(){
       // return Collections.max(this.list);
        T max = this.list.get(0);
        for (int i = 1; i <this.list.size() ; i++) {
            T current = this.list.get(i);
            if(current.compareTo(max) > 0){
                max = current;
            }
        }
        return max;
    }
    public T min(){
        //return Collections.min(this.list);
        T min = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            T current = this.list.get(i);
            if(current.compareTo(min) < 0){
                min = current;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : list) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
    private void validateIndex(int index){
        if(index <0 || index >=this.list.size()){
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }
    public int size(){
        return this.list.size();
    }
    public T get(int index){
        return this.list.get(index);
    }
}
