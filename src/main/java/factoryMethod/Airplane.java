package factorymethod;

public interface Airplane {
    /**
    *Airplanes have varying 
    *capacity and fuel effiencies, 
    *are assigned airports,
    *gates, destinations, and departure times,
    *must refuel and do maintenance.
    */

    int getCapacity();

    String getType();

    int getFuelCap();

    int getGate();

    void setGate(int gate);

    String getDestination();

    void setDestination(String destination);

    int getDepartureTime();

    void setDepartureTime(int departureTime);

    //includes refueling
    void doMaintenance();
}