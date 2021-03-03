package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver>{

    private Collection<Driver> models;

    public DriverRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        Driver driver = null;
        for (Driver currentDriver : models) {
            if(currentDriver.getName().equals(name)){
                driver = currentDriver;
                break;
            }
        }
        return driver;

    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Driver driver) {
        this.models.add(driver);
    }

    @Override
    public boolean remove(Driver driver) {
        return this.models.removeIf(d -> d.getName().equals(driver.getName()));
    }
}
