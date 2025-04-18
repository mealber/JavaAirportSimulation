import factorymethod.*;

public class Main {
    public static void main(String[] args) {
        AirplaneCreator creator = new BoeingCreator();
        Airplane boeing = creator.prepareAirplane("Paris", 3, 1200);
        System.out.println(boeing.getDestination());
    }
}