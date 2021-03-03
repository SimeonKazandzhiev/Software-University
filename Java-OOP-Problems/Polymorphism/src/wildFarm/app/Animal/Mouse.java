package wildFarm.app.Animal;

import wildFarm.food.Food;



public class Mouse extends Mammal{
    public Mouse(String animalType, String animalName, Double animalWeight,  String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if(food.getClass().getSimpleName().equals("Vegetable")) {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }else {
            System.out.println("Mice are not eating that type of food!");
        }
    }


}
