package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class RaceRepository implements Repository<Race> {

    private Collection<Race> models;


    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        Race race = null;
        for (Race currentRace : models) {
            if (currentRace.getName().equals(name)) {
                race = currentRace;
                break;
            }
        }
        return race;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Race race) {
        this.models.add(race);
    }

    @Override
    public boolean remove(Race race) {
        return this.models.removeIf(r -> r.getName().equals(race.getName()));
    }
}
