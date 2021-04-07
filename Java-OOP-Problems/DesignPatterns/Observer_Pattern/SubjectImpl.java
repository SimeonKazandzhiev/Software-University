import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {
    private List<Observer> observers;
    private String state;

    public SubjectImpl() {
        observers = new ArrayList<>();
        state = "INITIAL";
    }

    @Override
    public void changeState(String newState){
        this.state = newState;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("Observer removed successfully!");
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}