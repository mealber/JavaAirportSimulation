package factory;

public class SmallPlaneCreator extends AirplaneCreator {
    /**
    *Creates Boeing with fixed attributes initialzied.
    */
    @Override
    public Airplane createAirplane() {
        SmallPlane jet = new SmallPlane();
        return jet;
    }
}