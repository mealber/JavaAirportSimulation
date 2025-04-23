package factory;

import java.util.ArrayList;

public abstract class Airport {

    //name, checks, gates, and runways fixed based on airport type
    private final int securityChecks;
    private final int gates;
    private final int runways;
    private String name;
    private ArrayList<Airplane> airplanes = new ArrayList<>();

    /**
    *Creates new airport object with empty airplane list.
    */
    public Airport(int checks, int gates, int runways) {
        this.name = null;
        this.securityChecks = checks;
        this.gates = gates;
        this.runways = runways;
        this.airplanes = null;
    }

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

    //adds airplane to airplane list
    public void addAirplanes(Airplane airplane) {
        airplanes.add(airplane);
    }

    //returns a copy of airplane list to protect internal info
    public ArrayList<Airplane> getAirplanes() {
        return new ArrayList<>(airplanes);
    }
}