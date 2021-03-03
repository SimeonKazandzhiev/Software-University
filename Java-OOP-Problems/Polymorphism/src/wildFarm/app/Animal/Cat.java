package wildFarm.app.Animal;

import wildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime{

    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion,
               String breed) {
        super(animalType, animalName, animalWeight,  livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        return super.getAnimalType() + String.format("[%s, %s, %s, %s, %d]", super.getAnimalName(),this.breed,
                decimalFormat.format(super.getAnimalWeight()),getLivingRegion(),super.getFoodEaten());
    }
}
