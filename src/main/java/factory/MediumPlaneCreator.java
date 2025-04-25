package factory;

public class MediumPlaneCreator extends AirplaneCreator {
    /**
    *Creates plane with fixed attributes initialzied.
    */
    @Override
    public Airplane createAirplane() {
        MediumPlane jet = new MediumPlane();
        return jet;
    }
}