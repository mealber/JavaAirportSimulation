package factory;

public class SmallPlaneCreator extends AirplaneCreator {
    /**
    *Creates plane with fixed attributes initialzied.
    */
    @Override
    public Airplane createAirplane() {
        SmallPlane jet = new SmallPlane();
        return jet;
    }
}