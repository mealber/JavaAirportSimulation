package factory;

import java.util.ArrayList;

public abstract class Airport {

    //name, checks, gates, and runways fixed based on airport type
    private final int securityChecks;
    private final int gates;
    private final int runways;
    private String name;

    /**
    *Creates new airport object with empty airplane list.
    */
    public Airport(int checks, int gates, int runways) {
        this.securityChecks = checks;
        this.gates = gates;
        this.runways = runways;
    }

    /**
    *Returns a copy of airport object.
    */
    public abstract Airport copy();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSecurityChecks() {
        return securityChecks;
    }

    public int getGates() {
        return gates;
    }

    public int getRunways() {
        return runways;
    }
}