package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class FoodRepositoryImpl implements FoodRepository<BakedFood>{

    private List<BakedFood> models;

    public FoodRepositoryImpl(){
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        BakedFood bakedFood= null;
        for (BakedFood food : models) {
            if(food.getName().equals(name)){
                bakedFood = food;
            }
        }
        return bakedFood;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableList(models);
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.models.add(bakedFood);
    }
}
