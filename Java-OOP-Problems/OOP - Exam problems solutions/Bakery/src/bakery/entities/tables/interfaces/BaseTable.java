package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;


public abstract class BaseTable implements Table{

    private  Collection<BakedFood> foodOrders;
    private  Collection<Drink> drinkOrders;
    private final int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private final double pricePerPerson;
    private boolean isReserved = false;
    private double price ;


    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();


    }

    private void setCapacity(int capacity) {
        if(capacity <= 0 ){
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price = this.pricePerPerson * this.numberOfPeople ;
    }


    @Override
    public void reserve(int numberOfPeople) {
        if(numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        if(this.numberOfPeople <= this.capacity){
            isReserved = true;
        }
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double bill = 0;

        for (BakedFood foodOrder : foodOrders) {
            bill+=foodOrder.getPrice();
        }
        for (Drink drinkOrder : drinkOrders) {
            bill+=drinkOrder.getPrice();
        }

        return  this.getPrice() + bill;
    }


    @Override
    public void clear() {
        foodOrders.clear();
        drinkOrders.clear();
        isReserved = false;
        this.price = 0;
        this.numberOfPeople = 0;

    }



    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Table: %d",this.tableNumber)).append(System.lineSeparator());
        sb.append(String.format("Type: %s",this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("Capacity: %d",this.capacity)).append(System.lineSeparator());
        sb.append(String.format("Price per Person: %.2f",this.pricePerPerson))
                .append(System.lineSeparator());

        return sb.toString().trim();

    }


}
