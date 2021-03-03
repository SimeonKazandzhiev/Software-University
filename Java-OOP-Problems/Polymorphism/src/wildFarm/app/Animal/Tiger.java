package wildFarm.app.Animal;

import wildFarm.food.Food;

public class Tiger extends Felime{


    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(food.getClass().getSimpleName().equals("Meat")) {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
