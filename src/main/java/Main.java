import factory.Airplane;
import factory.AirplaneCreator;
import factory.Boeing;
import factory.BoeingCreator;

public class Main {
    /**
    *entry point of airport simulation.
    */
    public static void main(String[] args) {
        AirplaneCreator creator = new BoeingCreator();
        Airplane boeing = creator.prepareAirplane("Paris", 3, 1200);
        System.out.println(boeing.getDestination());

        Simulation simulation = new Simulation();
        simulation.setUp();
    }
}