package factory;

public class SmallAirport extends Airport {
    public SmallAirport() {    
        //Initializes concrete Small airport
        super(3, 10, 4);
    }

    private SmallAirport(int gates, int passengers, int runways) {
        super(gates, passengers, runways);
    }

    public Airport copy() {
        return new SmallAirport(3, 10, 4);
    }
}