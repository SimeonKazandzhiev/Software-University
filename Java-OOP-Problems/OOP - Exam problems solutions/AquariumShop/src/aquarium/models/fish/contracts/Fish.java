package aquarium.models.fish.contracts;

public interface Fish {
    void setName(String name);

    void eat();

    int getSize();

    String getName();

    double getPrice();
}
