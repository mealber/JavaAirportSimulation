package factory;

public class LargeAirportCreator extends AirportCreator {
    @Override
    public Airport createAirport() {    
        Airport airport = new SmallAirport();
        return airport;    
    }
}