package pizzaCalories;

import pizzaCalories.TypeUtils.TypeUtils;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight){
        if(weight>=1 && weight<=200){
            this.weight = weight;
        }else{
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    private void setFlourType(String flourType) {
        if(!TypeUtils.FLOUR_TYPES.containsKey(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }
    private void setBakingTechnique(String bakingTechnique){
        if(!TypeUtils.BAKING_TECHNIQUES.containsKey(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }
    public double calculateCalories(){
        return 2 * this.weight
                * TypeUtils.FLOUR_TYPES.get(this.flourType)
                * TypeUtils.BAKING_TECHNIQUES.get(this.bakingTechnique);
    }
}
