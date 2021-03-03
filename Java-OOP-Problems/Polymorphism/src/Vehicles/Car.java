package Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {


    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }


    @Override
    public void drive(double distance) {
        double fuelNeeded = (super.getFuelConsumption() + 0.9) * distance;
        if (fuelNeeded <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - fuelNeeded);
            DecimalFormat decimalFormat = new DecimalFormat("###.##");

            System.out.println(String.format("Car travelled %s km", decimalFormat.format(distance)));
        } else {
            System.out.println("Car needs refueling");
        }

    }

    @Override
    public void refuel(double amount) {
        if (amount > 0) {
            if(amount + super.getFuelQuantity() <= super.getTankCapacity()){
                super.setFuelQuantity(super.getFuelQuantity() + amount);
            }else {
                System.out.println("Cannot fit fuel in tank");
            }
        }else {
            System.out.println("Fuel must be a positive number");
        }
    }
}
