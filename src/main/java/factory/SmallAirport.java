package factory;

public class SmallAirport extends Airport {
    public SmallAirport() {    
        //Initializes concrete Small airport
        super(1, 3, 2);
    }

    private SmallAirport(int securityChecks, int gates, int runways) {
        super(securityChecks, gates, runways);
    }

    /**
    *Returns defensive copy of airport 
    *
    *@param name of airport
    */
    public Airport copy(String name) {
        Airport a = new SmallAirport(1, 3, 2);
        a.setName(name);
        return a;
    }
}