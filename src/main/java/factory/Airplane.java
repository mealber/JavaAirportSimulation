package factory;
import data.Flight;

public abstract class Airplane {
    //capacity and fuel fixed based on type
    private final int capacity;
    private final int fuelCap;
    private final String type;
    private int gate;
    private String destination;
    private int departureTime;

    /**
    * creates a new Boeing airplane with set capacity and fuel values based on airplane type.
    */
    public Airplane(int capacity, int fuelCap, String type) {
        this.capacity = capacity;
        this.fuelCap = fuelCap;
        this.type = type;
        this.gate = -1; //no gate assigned yet
        this.destination = null; //no destination assigned yet
        this.departureTime = -1; //no departure time assigned yet
    } 

    public int getCapacity() {
        return this.capacity;
    }

    public int getFuelCap() {
        return this.fuelCap;
    }

    public String getType() {
        return this.type;
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

    public Flight toFlight() {
        Flight flight = new Flight(destination, gate, departureTime);
        return flight;
    }

    //includes refueling, unique to differnt airplanes
    abstract void doMaintenance();
}