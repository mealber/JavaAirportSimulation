package observer;

import java.util.ArrayList;

public class Simulation implements Subject {
    ArrayList<Observer> observers = new ArrayList<>();
    int time = 0;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(int time) {
        for(Observer o : observers) {
            o.update(time);
        }
    }

    public void runSimulation() {
        //TODO
    }
}