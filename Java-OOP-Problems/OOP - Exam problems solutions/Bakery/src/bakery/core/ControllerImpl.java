package bakery.core;


import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.Bread;
import bakery.entities.bakedFoods.interfaces.Cake;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.drinks.interfaces.Tea;
import bakery.entities.drinks.interfaces.Water;
import bakery.entities.tables.interfaces.InsideTable;
import bakery.entities.tables.interfaces.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.DrinkRepository;
import bakery.repositories.interfaces.FoodRepository;
import bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.ExceptionMessages.TABLE_EXIST;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private final FoodRepository<BakedFood> foodRepository;
    private final DrinkRepository<Drink> drinkRepository;
    private final TableRepository<Table> tableRepository;
    private List<Table> leftTables = new ArrayList<>();
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        leftTables = new ArrayList<>();
    }


    @Override
    public String addFood(String type, String name, double price) {
        Collection<BakedFood> all = foodRepository.getAll();
        for (BakedFood bakedFood : all) {
            if (bakedFood.getName().equals(name)) {
                throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
            }
        }

        if (type.equals("Bread")) {
            this.foodRepository.add(new Bread(name, price));
        } else if (type.equals("Cake")) {
            this.foodRepository.add(new Cake(name, price));
        }

        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Collection<Drink> all = drinkRepository.getAll();
        for (Drink drink : all) {
            if (drink.getName().equals(name)) {
                throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
            }
        }
        if (type.equals("Tea")) {
            this.drinkRepository.add(new Tea(name, portion, brand));
        } else if (type.equals("Water")) {
            this.drinkRepository.add(new Water(name, portion, brand));
        }
        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Collection<Table> all = tableRepository.getAll();
        for (Table table : all) {
            if (table.getTableNumber() == tableNumber) {
                throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
            }
        }

        if (type.equals("InsideTable")) {
            this.tableRepository.add(new InsideTable(tableNumber, capacity));
        } else if (type.equals("OutsideTable")) {
            this.tableRepository.add(new OutsideTable(tableNumber, capacity));
        }
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Collection<Table> all = this.tableRepository.getAll();

        for (Table table : all) {
            if (!table.isReserved() && table.getCapacity() >= numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }

        }
        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Collection<Table> tables = tableRepository.getAll();
        Collection<BakedFood> foods = foodRepository.getAll();
        Table table = null;
        for (Table table1 : tables) {
            if (table1.getTableNumber() == tableNumber && table1.isReserved()) {
                table = table1;
                break;
            }
        }
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        BakedFood food = null;
        for (BakedFood food1 : foods) {
            if (food1.getName().equals(foodName)) {
                food = food1;
                break;
            }
        }
        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
        table.orderFood(food);
        return String.format(FOOD_ORDER_SUCCESSFUL, table.getTableNumber(), food.getName());
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Collection<Table> tables = tableRepository.getAll();
        Collection<Drink> drinks = drinkRepository.getAll();
        Table table = null;
        Drink drink = null;
        for (Table table1 : tables) {
            if (table1.getTableNumber() == tableNumber && table1.isReserved()) {
                table = table1;
                break;
            }
        }
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        for (Drink drink1 : drinks) {
            if (drink1.getName().equals(drinkName) && drink1.getBrand().equals(drinkBrand)) {
                drink = drink1;

                break;
            }
        }
        if (drink == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        table.orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL, table.getTableNumber(),
                drink.getName(), drink.getBrand());

    }

    @Override
    public String leaveTable(int tableNumber) {

        Collection<Table> tables = tableRepository.getAll();
        Table tableToClean = null;
        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber) {
                tableToClean = table;
                leftTables.add(table);
                break;
            }
        }

        return String.format(BILL, tableNumber, tableToClean.getBill());

    }

    @Override
    public String getTotalIncome() {

        for (Table table : leftTables) {
            totalIncome += table.getBill();

        }


        return String.format(TOTAL_INCOME, totalIncome);
    }

    @Override
    public String getFreeTablesInfo() {
        Collection<Table> all = tableRepository.getAll();
        StringBuilder sb = new StringBuilder();
        for (Table table : all) {
            if (!table.isReserved()) {
                sb.append(table.getFreeTableInfo()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
