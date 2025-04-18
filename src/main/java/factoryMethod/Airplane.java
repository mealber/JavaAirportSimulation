package factoryMethod;

public interface Airplane {
    int getCapacity();
    String getType();
    int getFuelCap();

    int getGate();
    void setGate(int gate);

    String getDestination();
    void setDestination(String destination);

    int getDepartureTime();
    void setDepartureTime(int departureTime);

    void doMaintenance();
}