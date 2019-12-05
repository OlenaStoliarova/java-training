package ua.training.task1var8railways.model.entity;

public class SleepingRailcar extends PassengerRailcar {
    public static final int STANDARD_NUMBER_OF_PASSENGERS = 18;
    public static final int STANDARD_LUGGAGE_ALLOWANCE = 50;

    Boolean isPossibleToBuyOneSeat = true;

    {
        readableClassName = "SleepingRailcar";
    }
    public SleepingRailcar(String railcarNumber) {
        super(railcarNumber, PassengerRailcarComfortLevel.FIRST, SleepingRailcar.STANDARD_NUMBER_OF_PASSENGERS, SleepingRailcar.STANDARD_LUGGAGE_ALLOWANCE);
    }

    public SleepingRailcar(String railcarNumber, Boolean isPossibleToBuyOneSeat) {
        this(railcarNumber);
        this.isPossibleToBuyOneSeat = isPossibleToBuyOneSeat;
    }

    @Override
    public String toString() {
        return "SleepingRailcar\t\t{" +
                "numberID='" + numberID + '\'' +
                ", \tcomfortLevel=" + comfortLevel +
                ", \tnumberOfPassengers=" + numberOfPassengers +
                ", \tmaxLuggagePerPassengerKg=" + maxLuggagePerPassengerKg +
                '}';
    }
}
