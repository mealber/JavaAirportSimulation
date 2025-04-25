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
        System.out.println("Refueling " + this.getName() + " to 90,000 gallons of fuel.");
        System.out.println("Doing pre-flight inspection on " + this.getName() + ".");
        System.out.println("Checking fluid levels on " + this.getName() + ".");
    }
}