import factorymethod.Airport;

public class BoardingState implements PassengerState {
    @Override
    public boolean handle(Passenger passenger, Airport airport) {
        double failingChance = Math.random();
        if (failingChance < 0.05) { //5% chance to miss boarding time

            System.out.println(passenger.getName() 
                + " missed boarding at gate " 
                + passenger.getFlight().getGate() + ".");   

            return false;
        }

        System.out.println(passenger.getName() 
            + " has boarded at gate " 
            + passenger.getFlight().getGate() + ".");

        return true;
    }
}