package ua.training.task1var8railways.model.entity;

public class CompartmentRailcar extends PassengerRailcar {
    public static final int STANDARD_NUMBER_OF_PASSENGERS = 36;
    public static final int STANDARD_LUGGAGE_ALLOWANCE = 36;

    public CompartmentRailcar(String railcarNumber, CompartmentRailcarComfortLevel comfortLevel) {
        super(railcarNumber, comfortLevel.getComfortLevel(), CompartmentRailcar.STANDARD_NUMBER_OF_PASSENGERS, CompartmentRailcar.STANDARD_LUGGAGE_ALLOWANCE);
    }

    @Override
    public String toString() {
        return "CompartmentRailcar\t{" +
                "numberID='" + numberID + '\'' +
                ", \tcomfortLevel=" + comfortLevel +
                ", \tnumberOfPassengers=" + numberOfPassengers +
                ", \tmaxLuggagePerPassengerKg=" + maxLuggagePerPassengerKg +
                '}';
    }
}
