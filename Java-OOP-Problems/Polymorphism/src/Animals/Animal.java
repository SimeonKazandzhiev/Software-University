package Animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;


    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    abstract String explainSelf();


    @Override
    public String toString() {
        return String.format("I am %s and my favourite food is %s",
                this.name,this.favouriteFood);
    }
}
