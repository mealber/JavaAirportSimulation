package factory;

public class LargePlaneCreator extends AirplaneCreator {
    /**
    *Creates plane with fixed attributes initialzied.
    */
    @Override
    public Airplane createAirplane() {
        LargePlane jet = new LargePlane();
        return jet;
    }
}