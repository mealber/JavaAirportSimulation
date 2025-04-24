package factory;

public class LargeAirport extends Airport {
    public LargeAirport() {    
        //Initializes concrete Small airport
        super(8, 40, 10);
    }

    private LargeAirport(int gates, int passengers, int runways) {
        super(gates, passengers, runways);
    }

    public Airport copy() {
        return new LargeAirport(8, 40, 10);
    }
}