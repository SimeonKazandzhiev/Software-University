package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;
    private Map<Integer, Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new HashMap<>();
        this.components = new HashMap<>();
        this.peripherals = new HashMap<>();
    }


    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {

        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        Computer computer;

        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        }else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }

        this.computers.put(id, computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer,
                                String model, double price, double overallPerformance, String connectionType) {
        checkComputerId(computerId);

        Peripheral peripheral ;

        if(peripherals.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        if(peripheralType.equals("Headset")){
            peripheral = new Headset(id,manufacturer,model,price,overallPerformance,connectionType);
        }else if(peripheralType.equals("Keyboard")){
            peripheral = new Keyboard(id,manufacturer,model,price,overallPerformance,connectionType);
        }else if(peripheralType.equals("Monitor")){
            peripheral = new Monitor(id,manufacturer,model,price,overallPerformance,connectionType);
        }else if(peripheralType.equals("Mouse")){
            peripheral = new Mouse(id,manufacturer,model,price,overallPerformance,connectionType);
        }else {
            throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        computers.get(computerId).addPeripheral(peripheral);
        this.peripherals.put(id,peripheral);

        return String.format(ADDED_PERIPHERAL,peripheralType,id,computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        checkComputerId(computerId);
        Peripheral peripheral =   computers.get(computerId).removePeripheral(peripheralType);
        peripherals.remove(peripheral.getId());

        return String.format(REMOVED_PERIPHERAL,peripheralType,peripheral.getId());

    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        checkComputerId(computerId);
        if(components.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        Component component;

        if(componentType.equals("CentralProcessingUnit")){
            component = new CentralProcessingUnit(id,manufacturer,model,price,overallPerformance,generation);
        }else if(componentType.equals("Motherboard")){
            component = new Motherboard(id,manufacturer,model,price,overallPerformance,generation);
        }else if(componentType.equals("PowerSupply")){
            component = new PowerSupply(id,manufacturer,model,price,overallPerformance,generation);
        }else if(componentType.equals("RandomAccessMemory")){
            component = new RandomAccessMemory(id,manufacturer,model,price,overallPerformance,generation);
        }else if(componentType.equals("SolidStateDrive")){
            component = new SolidStateDrive(id,manufacturer,model,price,overallPerformance,generation);
        }else if(componentType.equals("VideoCard")){
            component = new VideoCard(id,manufacturer,model,price,overallPerformance,generation);
        }else {
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        this.components.put(component.getId(),component);
        computers.get(computerId).addComponent(component);
        return String.format(ADDED_COMPONENT,componentType,id,computerId);

    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        checkComputerId(computerId);
        Component component =   computers.get(computerId).removeComponent(componentType);
        components.remove(component.getId());

        return String.format(REMOVED_COMPONENT,componentType,component.getId());

    }

    @Override
    public String buyComputer(int id) {
        checkComputerId(id);
        return computers.remove(id).toString();
    }

    @Override
    public String BuyBestComputer(double budget) {

        List<Computer> affordableComputers = computers.values().stream()
                .filter(c -> c.getPrice() <= budget)
                .sorted(Comparator.comparing(Computer::getOverallPerformance).reversed())
                .collect(Collectors.toList());

        if(affordableComputers.isEmpty()){
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER,budget));
        }
        Computer computer = affordableComputers.get(0);
        computers.remove(computer.getId());
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        checkComputerId(id);
        return this.computers.get(id).toString();
    }

    private void checkComputerId(int id) {
        if (!this.computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }
}
