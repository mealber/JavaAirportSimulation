package factory;

public class Boeing implements Airplane {
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
    public Boeing() {
        this.capacity = 500;
        this.fuelCap = 63000;
        this.type = "Boeing";
        this.gate = -1; //no gate assigned yet
        this.destination = null; //no destination assigned yet
        this.departureTime = -1; //no departure time assigned yet
    } 

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getFuelCap() {
        return this.fuelCap;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getGate() {
        return this.gate;
    }

    @Override
    public void setGate(int gate) {
        this.gate = gate;
    }

    @Override
    public String getDestination() {
        return this.destination;
    }

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public int getDepartureTime() {
        return this.departureTime;
    }

    @Override
    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public void doMaintenance() {
        System.out.println("Refueling... ");
        System.out.println("Doing maintenance...");
    }
}