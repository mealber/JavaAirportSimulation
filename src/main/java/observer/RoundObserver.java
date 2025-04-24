package observer;

public class RoundObserver implements Observer {
    Simulation s;

    public RoundObserver(Simulation s) {
        this.s = s;
    }

    @Override
    public void update() {
        try {
            System.out.println("\n-----Starting next round in 10 seconds-----");
            Thread.sleep(10000); //pause for 10 seconds between rounds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}