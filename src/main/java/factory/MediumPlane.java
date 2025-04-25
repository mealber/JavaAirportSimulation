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
        System.out.println("Refueling " + this.getName() + " to 75,000 gallons of fuel.");
        System.out.println("Doing system diagnostics on " + this.getName() + ".");
        System.out.println("Cleaning cabin of " + this.getName() + ".");
    }
}