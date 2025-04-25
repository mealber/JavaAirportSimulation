package factory;

public class SmallAirportCreator extends AirportCreator {
    @Override
    public Airport createAirport() {    
        Airport airport = new SmallAirport();
        return airport;    
    }
}