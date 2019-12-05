package ua.training.task1var8railways.model.entity;

public abstract class PassengerRailcar{
    protected String numberID;
    protected PassengerRailcarComfortLevel comfortLevel;
    protected int numberOfPassengers;
    protected int maxLuggagePerPassengerKg;

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

    protected String readableClassName = "PassengerRailcar";
    @Override
    public String toString() {
        return readableClassName + "\t{" +
                "numberID='" + numberID + '\'' +
                ", \tcomfortLevel=" + comfortLevel +
                ", \tnumberOfPassengers=" + numberOfPassengers +
                ", \tmaxLuggagePerPassengerKg=" + maxLuggagePerPassengerKg +
                '}';
    }
}
