package factory;

public class MediumAirport extends Airport {
    public MediumAirport() {    
        //Initializes concrete medium airport
        super(5, 20, 6);
    }

    private MediumAirport(int gates, int runways, int securityChecks) {
        super(gates, runways, securityChecks);
    }

    /**
    *Returns defensive copy of airport 
    *
    *@param name of airport
    */
    public Airport copy(String name) {
        Airport a = new MediumAirport(8, 40, 10);
        a.setName(name);
        return a;
    }
}