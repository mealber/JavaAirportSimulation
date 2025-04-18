package factoryMethod;

public class BoeingCreator extends AirplaneCreator{
    @Override
    public Airplane createAirplane(){
        Boeing boeingPlane = new Boeing();
        return boeingPlane;
    }
}