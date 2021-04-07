public class Main {
    public static void main(String[] args) {

        Subject site = new SubjectImpl();

        Observer john = new ObserverImpl();
        Observer george = new ObserverImpl();

        site.registerObserver(john);
        site.registerObserver(george);

        site.changeState("NEW STATE");

        site.removeObserver(george);
    }
}