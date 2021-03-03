package wildFarm.app.Animal;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    protected Mammal(String animalType, String animalName, Double animalWeight,
                     String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        return super.getAnimalType() + String.format("[%s, %s, %s, %d]", super.getAnimalName()
                ,decimalFormat.format(super.getAnimalWeight()),getLivingRegion(),super.getFoodEaten());    }
}
