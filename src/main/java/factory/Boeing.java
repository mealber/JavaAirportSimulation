package factory;

public class Boeing extends Airplane {
    /**
    * creates a new Boeing airplane and initializes fixed attributes.
    */
    public Boeing() {
        super(500, 63000, "Boeing 737");
    }

    @Override
    public void doMaintenance() {
        System.out.println("Refueling Boeing 737 to 63,000 gallons of fuel.");
        System.out.println("Testing Boeing 737 components.");
        System.out.println("Upgrading avionics on Boeing 737.");
    }
}