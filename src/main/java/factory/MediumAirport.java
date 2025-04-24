package factory;

public class MediumAirport extends Airport {
    public MediumAirport() {    
        //Initializes concrete medium airport
        super(2, 5, 4);
    }

    private MediumAirport(int securityChecks, int gates, int runways) {
        super(securityChecks, gates, runways);
    }

    /**
    *Returns defensive copy of airport 
    *
    *@param name of airport
    */
    public Airport copy(String name) {
        Airport a = new MediumAirport(2, 5, 4);
        a.setName(name);
        return a;
    }
}