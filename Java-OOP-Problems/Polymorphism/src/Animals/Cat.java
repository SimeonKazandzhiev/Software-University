package Animals;

public class Cat extends Animal{


    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        return super.toString() + String.format("%nMEEOW");
    }
}
