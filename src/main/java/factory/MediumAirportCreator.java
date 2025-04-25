package factory;

public class MediumAirportCreator extends AirportCreator {
    @Override
    public Airport createAirport() {    
        Airport airport = new MediumAirport();
        return airport;    
    }
}