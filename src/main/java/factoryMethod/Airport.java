package factorymethod;

import java.util.ArrayList;

public class Airport {
    private String name;
    private ArrayList<Airplane> airplaneList = new ArrayList<>();
    private int securityChecks;

    public Airport() {
        this.name = null;
        this.airplaneList = null;
        this.securityChecks = -1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAirplane(Airplane airplane) {
        airplaneList.add(airplane);
    }

    public ArrayList<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public void setSecurityChecks(int checkPoints) {
        this.securityChecks = checkPoints;
    }

    public int getSecurityChecks() {
        return securityChecks;
    }
}