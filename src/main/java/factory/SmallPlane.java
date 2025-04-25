package factory;

public class SmallPlane extends Airplane {
    /**
    * creates a new small airplane and initializes fixed attributes.
    */
    public SmallPlane() {
        super(500, 63000);
    }

    @Override
    public void doMaintenance() {
        System.out.println("Refueling " + this.getName() + " to 63,000 gallons of fuel.");
        System.out.println("Testing components on " + this.getName() + ".");
        System.out.println("Upgrading avionics on " + this.getName() + ".");
    }
}