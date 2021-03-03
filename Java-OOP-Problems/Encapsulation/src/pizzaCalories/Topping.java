package pizzaCalories;

import pizzaCalories.TypeUtils.TypeUtils;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType){
        if(!TypeUtils.TOPPING_TYPES.containsKey(toppingType)){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
        this.toppingType = toppingType;
    }
    private void setWeight(double weight){
        if(weight >=1 && weight <=50){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",getToppingType()));
        }
    }
    public double calculateCalories(){
        return this.weight * 2 * TypeUtils.TOPPING_TYPES.get(this.toppingType);
    }

    private String getToppingType() {
        return toppingType;
    }
}
