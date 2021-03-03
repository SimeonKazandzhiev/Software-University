package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DrinkRepositoryImpl implements DrinkRepository<Drink>{

    private List<Drink> models;

    public DrinkRepositoryImpl(){
        this.models = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        Drink drink = null;
        for (Drink drink1 : models) {
            if(drink1.getName().equals(drinkName) &&
            drink1.getBrand().equals(drinkBrand)){
                drink = drink1;
            }
        }
        return drink;
    }

    @Override
    public Collection<Drink> getAll() {
        return  Collections.unmodifiableList(models);
    }

    @Override
    public void add(Drink drink) {
        this.models.add(drink);
    }
}
