package observer;

public interface Subject {
    /**
    *Adds an observer to observer list.
    *
    *@param observer to be added
    */
    void addObserver(Observer observer);

    /**
    *Removes an observer from observer list.
    *
    *@param observer to be removed
    */
    void removeObserver(Observer observer);

    /**
    *Notifies all observers when new simulation round should start.
    */
    void notifyObservers();
}