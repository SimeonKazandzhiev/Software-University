import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {


        List<String> names = new ArrayList<>();

        names.add("Peter");
        names.add("Maria");
        names.add("George");
        names.remove("Peter");


        for (String name:names) {
            System.out.println(name);
        }

    }
}
