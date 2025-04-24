package factory;

import data.Flight;

public abstract class Airplane {
    //capacity and fuel fixed based on type
    private final int capacity;
    private final int fuelCap;
    private int gate;
    private String destination;
    private int departureTime;
    private String name;

    /**
    * creates a new airplane with set capacity and fuel values based on airplane type.
    */
    public Airplane(int capacity, int fuelCap) {
        this.capacity = capacity;
        this.fuelCap = fuelCap;
        this.gate = -1; //no gate assigned yet
        this.destination = null; //no destination assigned yet
        this.departureTime = -1; //no departure time assigned yet
        this.name = null; //no name assigned yet
    } 

    public int getCapacity() {
        return this.capacity;
    }

    public int getFuelCap() {
        return this.fuelCap;
    }

    public int getGate() {
        return this.gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
    *converts airplane into immutable flight object,
    *contains neccesary flight info for passengers.
    */
    public Flight toFlight() {
        Flight flight = new Flight(destination, gate, departureTime, name);
        return flight;
    }

    //includes refueling, unique to differnt airplanes
    public abstract void doMaintenance();
}