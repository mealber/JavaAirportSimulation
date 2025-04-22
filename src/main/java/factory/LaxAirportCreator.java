package factory;

public class LaxAirportCreator extends AirportCreator {
    @Override
    public Airport createAirport() {    
        Airport lax = new LaxAirport();
        return lax;    
    }
}