package ua.training.task1var8railways.model.entity;

public class CouchetteRailcar extends PassengerRailcar {
    public static final int STANDARD_NUMBER_OF_PASSENGERS = 54;
    public static final int STANDARD_LUGGAGE_ALLOWANCE = 36;

    public CouchetteRailcar(String railcarNumber, CouchetteRailcarComfortLevel comfortLevel) {
        super(railcarNumber, comfortLevel.getComfortLevel(), CouchetteRailcar.STANDARD_NUMBER_OF_PASSENGERS, CouchetteRailcar.STANDARD_LUGGAGE_ALLOWANCE);
    }

    @Override
    public String toString() {
        return "CouchetteRailcar\t{" +
                "numberID='" + numberID + '\'' +
                ", \tcomfortLevel=" + comfortLevel +
                ", \tnumberOfPassengers=" + numberOfPassengers +
                ", \tmaxLuggagePerPassengerKg=" + maxLuggagePerPassengerKg +
                '}';
    }
}