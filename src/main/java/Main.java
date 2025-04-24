import observer.Simulation;

public class Main {
    /**
    *entry point of airport simulation.
    */
    public static void main(String[] args) {
        Simulation simulation = new Simulation(); 

//add observers

        simulation.runSimulation();
    }
}