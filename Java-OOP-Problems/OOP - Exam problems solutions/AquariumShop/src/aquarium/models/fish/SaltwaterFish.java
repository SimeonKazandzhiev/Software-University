package aquarium.models.fish;

public class SaltwaterFish extends BaseFish {

    private static final int INITIAL_SIZE = 5;
    private static final int INCREASE_SIZE = 2;


    //Can only live in SaltwaterAquarium!

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(INITIAL_SIZE);

    }

    @Override
    public void eat() {
        int size = super.getSize();
        size += INCREASE_SIZE;
        super.setSize(size);
    }
}
