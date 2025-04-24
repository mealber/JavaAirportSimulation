package factory;

public class LargeAirport extends Airport {
    public LargeAirport() {    
        //Initializes concrete Large airport
        super(3, 7, 6);
    }

    private LargeAirport(int securityChecks, int gates, int runways) {
        super(securityChecks, gates, runways);
    }


    /**
    *Returns defensive copy of airport 
    *
    *@param name of airport
    */
    public Airport copy(String name) {
        Airport a = new LargeAirport(3, 7, 6);
        a.setName(name);
        return a;
    }
}