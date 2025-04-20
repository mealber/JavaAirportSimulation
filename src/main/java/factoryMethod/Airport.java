package factorymethod;

import java.util.ArrayList;

public class Airport {
    private String name;
    private ArrayList<Airplane> airplaneList = new ArrayList<>();

    public Airport() {
        this.name = null;
        this.airplaneList = null;
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
}