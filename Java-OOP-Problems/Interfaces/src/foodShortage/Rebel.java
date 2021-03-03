package foodShortage;

public class Rebel implements Buyer,Person{
    public static final int START_FOOD = 0;

    private String name;
    private int age;
    private String group;
    private int food;


    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = START_FOOD;
    }

    @Override
    public void buyFood() {
        this.food = 5;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public String getGroup() {
        return this.group;
    }
}
