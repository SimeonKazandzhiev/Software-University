package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;


import java.util.ArrayList;
import java.util.Collection;

public class GunRepository<T extends Gun> implements Repository<T>{

    private Collection<T> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    @Override
    public void add(T model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return this.models.remove(model);
    }

    @Override
    public T findByName(String name) {
        return this.models.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }
}
