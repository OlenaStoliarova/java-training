package ua.training.task1var8railways.model.entity;

public abstract class PassengerRailcar{
    private String numberID;
    private PassengerRailcarComfortLevel comfortLevel;
    private int numberOfPassengers;
    private int maxLuggagePerPassengerKg;

    public PassengerRailcar(String railcarNumber, PassengerRailcarComfortLevel comfortLevel, int numberOfPassengers, int maxLuggagePerPassengerKg){
        numberID = railcarNumber;
        this.comfortLevel = comfortLevel;
        this.numberOfPassengers = numberOfPassengers;
        this.maxLuggagePerPassengerKg = maxLuggagePerPassengerKg;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public int getMaxLuggagePerPassengerKg() {
        return maxLuggagePerPassengerKg;
    }

    public PassengerRailcarComfortLevel getComfortLevel(){
        return comfortLevel;
    }

    @Override
    public String toString() {
        return "PassengerRailcar{" +
                "numberID='" + numberID + '\'' +
                ", \tcomfortLevel=" + comfortLevel +
                ", \tnumberOfPassengers=" + numberOfPassengers +
                ", \tmaxLuggagePerPassengerKg=" + maxLuggagePerPassengerKg +
                '}';
    }
}
