public class Main {
    public static void main(String[] args) {

        HeatingSystem heatingSystem = new HeatingSystem();
        heatingSystem.turnOn();

        Command heatOn = new HeatingOnCommand();
        Command heatOff = new HeatingOffCommand();
        Controller controller = new Controller();
        controller.setCommand(heatOn);
        controller.executeCommand();

        controller.setCommand(heatOff);
        controller.executeCommand();

        heatingSystem.turnOff();
    }
}