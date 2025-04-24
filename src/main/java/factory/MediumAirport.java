package factory;

public class MediumAirport extends Airport {
    public MediumAirport() {    
        //Initializes concrete Small airport
        super(5, 20, 6);
    }

    private MediumAirport(int gates, int passengers, int runways) {
        super(gates, passengers, runways);
    }

    public Airport copy() {
        return new MediumAirport(5, 20, 6);
    }
}