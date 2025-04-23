package factory;

public class LargePlane extends Airplane {
    /**
    * creates a new large airplane and initializes fixed attributes.
    */
    public LargePlane() {
        super(1000, 90000);
    }

    @Override
    public void doMaintenance() {
        System.out.println("Refueling " + this.getName() + " to 63,000 gallons of fuel.");
        System.out.println("Testing components on " + this.getName() + ".");
        System.out.println("Upgrading avionics on " + this.getName() + ".");
    }
}