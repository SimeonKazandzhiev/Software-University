package aquarium.models.aquariums;

import aquarium.models.decorations.contracts.Decoration;
import aquarium.models.fish.contracts.Fish;

import java.util.Collection;

public class SaltwaterAquarium extends BaseAquarium {

    private static final int CAPACITY_AQUARIUM = 25;
    public static final String AQUARIUM_TYPE = "SaltwaterAquarium";

    public SaltwaterAquarium(String name) {
        super(name, CAPACITY_AQUARIUM);
    }


    @Override
    public String getInfo() {
        return String.format("%s (%s):", super.getName(), AQUARIUM_TYPE) +
                System.lineSeparator() +
                super.getInfo();
    }
}
