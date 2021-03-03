package Vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = false;
    }

    @Override
    public void drive(double distance) {
        double fuelNeeded = 0;
        if (isEmpty) {
            fuelNeeded = super.getFuelConsumption() * distance;
        } else {
            fuelNeeded = (super.getFuelConsumption() + 1.4) * distance;
        }
        if (fuelNeeded <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - fuelNeeded);
            DecimalFormat decimalFormat = new DecimalFormat("###.##");

            System.out.println(String.format("Bus travelled %s km", decimalFormat.format(distance)));
        } else {
            System.out.println("Bus needs refueling");
        }

    }

    @Override
    public void refuel(double amount) {
        if (amount > 0) {
            if (amount + super.getFuelQuantity() <= super.getTankCapacity()) {
                super.setFuelQuantity(super.getFuelQuantity() + amount);
            } else {
                System.out.println("Cannot fit fuel in tank");
            }

        } else {
            System.out.println("Fuel must be a positive number");
        }


    }
}
