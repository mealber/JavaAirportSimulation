package factory;

public class MediumAirportCreator extends AirportCreator {
    @Override
    public Airport createAirport() {    
        Airport airport = new SmallAirport();
        return airport;    
    }
}