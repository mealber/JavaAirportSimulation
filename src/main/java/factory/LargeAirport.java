package factory;

public class LargeAirport extends Airport {
    public LargeAirport() {    
        //Initializes concrete Large airport
        super(8, 40, 10);
    }

    private LargeAirport(int gates, int runways, int securityChecks) {
        super(gates, runways, securityChecks);
    }


    /**
    *Returns defensive copy of airport 
    *
    *@param name of airport
    */
    public Airport copy(String name) {
        Airport a = new LargeAirport(8, 40, 10);
        a.setName(name);
        return a;
    }
}