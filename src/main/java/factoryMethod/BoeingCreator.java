package factory;

public class BoeingCreator extends AirplaneCreator {
    /**
    *Creates Boeing with fixed attributes initialzied.
    */
    @Override
    public Airplane createAirplane() {
        Boeing boeingPlane = new Boeing();
        return boeingPlane;
    }
}