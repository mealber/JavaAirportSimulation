package factory;

public class LargeAirportCreator extends AirportCreator {
    @Override
    public Airport createAirport() {    
        Airport airport = new LargeAirport();
        return airport;    
    }
}