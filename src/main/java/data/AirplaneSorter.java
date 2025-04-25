package data;

import factory.Airplane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AirplaneSorter {
    /**
    *Sorts list of airplanes by departure time.
    */
    public ArrayList<Airplane> sortAirplanes(ArrayList<Airplane> airplanes) {
        Collections.sort(airplanes, new Comparator<Airplane>() {
            @Override
            public int compare(Airplane a1, Airplane a2) {
                return Integer.compare(a1.getDepartureTime(), a2.getDepartureTime());
            }
        });
        return airplanes;      
    }
}