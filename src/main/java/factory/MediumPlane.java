package factory;

public class MediumPlane extends Airplane {
    /**
    * creates a new medium airplane and initializes fixed attributes.
    */
    public MediumPlane() {
        super(750, 75000);
    }

    @Override
    public void doMaintenance() {
        System.out.println("Refueling " + this.getName() + " to 63,000 gallons of fuel.");
        System.out.println("Testing components on " + this.getName() + ".");
        System.out.println("Upgrading avionics on " + this.getName() + ".");
    }
}