package Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle{


    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }


    @Override
    public void drive(double distance) {
        double fuelNeeded = (super.getFuelConsumption() + 1.6) * distance;
        if(fuelNeeded <= super.getFuelQuantity()){
            super.setFuelQuantity(super.getFuelQuantity()-fuelNeeded);
            DecimalFormat decimalFormat = new DecimalFormat("###.##");

            System.out.println(String.format("Truck travelled %s km",decimalFormat.format(distance)));
        }else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(double amount) {
        if (amount > 0) {
            if(amount + super.getFuelQuantity() <= super.getTankCapacity()){
                super.setFuelQuantity(super.getFuelQuantity() + amount * 0.95);
            }else {
                System.out.println("Cannot fit fuel in tank");
            }

        }else {
            System.out.println("Fuel must be a positive number");
        }
    }
}
