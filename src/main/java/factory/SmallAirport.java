package factory;

public class SmallAirport extends Airport {
    public SmallAirport() {    
        //Initializes concrete Small airport
        super(3, 10, 4);
    }

    private SmallAirport(int gates, int runways, int securityChecks) {
        super(gates, runways, securityChecks);
    }

    /**
    *Returns defensive copy of airport 
    *
    *@param name of airport
    */
    public Airport copy(String name) {
        Airport a = new SmallAirport(8, 40, 10);
        a.setName(name);
        return a;
    }
}