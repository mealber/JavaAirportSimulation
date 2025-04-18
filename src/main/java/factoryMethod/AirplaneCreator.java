package factorymethod;

public abstract class AirplaneCreator{
    public abstract Airplane createAirplane();

    public Airplane prepareAirplane(String destination, int gate, int departureTime) {
        Airplane plane = createAirplane();
        plane.setDestination(destination);
        plane.setGate(gate);
        plane.setDepartureTime(departureTime);
        return plane;
    }
}