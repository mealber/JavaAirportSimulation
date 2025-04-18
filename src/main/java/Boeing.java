public class Boeing implements Airplane {
    private int capacity;
    private int fuelCap;
    private String type;
    private int gate;
    private String destination;
    private int departureTime;

    public Boeing(){
        this.capacity = 500;
        this.fuelCap = 63000;
        this.type = "Boeing";
        this.gate = -1; //set to invalid gate so I know if gate hasn't been assigned yet
        this.destination = null; //set to null before assigned
        this.departureTime = -1; //invalid time so I know if time hasn't been assigned yet
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