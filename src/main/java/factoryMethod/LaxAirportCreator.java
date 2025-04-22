package factory;

public class LaxAirportCreator extends AirportCreator{
    @Override
    public Airport createAirport() {    
        Airport LAX = new LaxAirport();
        return LAX;    
    }
}