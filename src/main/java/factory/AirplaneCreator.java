package factorymethod;

public abstract class AirplaneCreator {
    public abstract Airplane createAirplane();

    /**
    *prepares airplane for flight simulation by setting, 
    *destination, gate number, and departure time.
    *
    *@param destination the destination of flight
    *@param gate the gate number of flight
    *@param departureTime the departure time of flight
    *@return airplane object prepared for flight simulation
    */
    public Airplane prepareAirplane(String destination, int gate, int departureTime) {
        Airplane plane = createAirplane();
        plane.setDestination(destination);
        plane.setGate(gate);
        plane.setDepartureTime(departureTime);
        return plane;
    }
}