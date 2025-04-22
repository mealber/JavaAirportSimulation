package factory;

import java.util.ArrayList;

public abstract class Airport {

    //name, checks, gates, and runways fixed based on airport
    private final String name;
    private final int securityChecks;
    private final int gates;
    private final int runways;
    private ArrayList<Airplane> airplanes = new ArrayList<>();

    /**
    *Creates new airport object with empty airplane list.
    */
    public Airport(String name, int checks, int gates, int runways) {
        this.name = name;
        this.securityChecks = checks;
        this.gates = gates;
        this.runways = runways;
        this.airplanes = null;
    }

    public String getName() {
        return name;
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

    //adds airplane to airplane list
    public void addAirplanes(Airplane airplane) {
        airplanes.add(airplane);
    }

    //returns a copy of airplane list to protect internal info
    public ArrayList<Airplane> getAirplanes() {
        return new ArrayList<>(airplanes);
    }
}