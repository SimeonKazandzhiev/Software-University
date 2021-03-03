package easterRaces.core;


import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository,  Repository<Car> carRepository,Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {

        if(driverRepository.getByName(driver) != null){
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS,driver));
        }

        this.driverRepository.add(new DriverImpl(driver));
        return String.format(DRIVER_CREATED,driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if(carRepository.getByName(model) != null){
            throw new IllegalArgumentException(String.format(CAR_EXISTS,model));
        }
        Car car = null;
        switch (type){
            case "Muscle":
               car = new MuscleCar(model,horsePower);
                break;
            case "Sports":
              car = new SportsCar(model,horsePower);
                break;
        }
        this.carRepository.add(car);
        return String.format(CAR_CREATED,car.getClass().getSimpleName(),model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        Car car = carRepository.getByName(carModel);

        if(driver == null){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }
        if( car== null){
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND,carModel));
        }
        driver.addCar(car);

        return String.format(CAR_ADDED,driverName,carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Driver driver = driverRepository.getByName(driverName);
        Race race = raceRepository.getByName(raceName);


        if(raceRepository.getByName(raceName) == null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }
        if(driverRepository.getByName(driverName) == null){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }

        race.addDriver(driver);

        return String.format(DRIVER_ADDED,driverName,raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);

        if(race == null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }
        if(race.getDrivers().size() < 3){
            throw new IllegalArgumentException(String.format(RACE_INVALID,raceName,3));
        }

        List<Driver> winners = race.getDrivers().stream()
                .sorted((f, s) ->
                        Double.compare(s.getCar().calculateRacePoints(race.getLaps()), f.getCar().calculateRacePoints(race.getLaps())))
                .limit(3)
                .collect(Collectors.toList());


        StringBuilder out = new StringBuilder();
        String firstPosition =String.format(DRIVER_FIRST_POSITION,winners.get(0).getName(),raceName);
        String secondPosition =String.format(DRIVER_SECOND_POSITION,winners.get(1).getName(),raceName);
        String thirdPosition =String.format(DRIVER_THIRD_POSITION,winners.get(2).getName(),raceName);
        out.append(firstPosition).append(System.lineSeparator());
        out.append(secondPosition).append(System.lineSeparator());
        out.append(thirdPosition).append(System.lineSeparator());

        raceRepository.remove(raceRepository.getByName(raceName));
        return out.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {

        if(raceRepository.getByName(name) != null){
            throw new IllegalArgumentException(String.format(RACE_EXISTS,name));
        }

        raceRepository.add(new RaceImpl(name,laps));

        return String.format(RACE_CREATED,name);
    }
}
