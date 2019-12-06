package ua.training.task1var8railways.model.entity;

/**
 * <p> <b>Class to represent a railway carriage of a passenger train</b></p>
 * @author Olena Stoliarova
 ***/
public abstract class PassengerRailcar implements Comparable<PassengerRailcar>{
    /** numberID unique  number of a railway carriage given to it by its manufacturer */
    protected String numberID;
    /** @see PassengerRailcarComfortLevel PassengerRailcarComfortLevel */
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

    @Override
    public int compareTo(PassengerRailcar o) {
        return this.comfortLevel.compareTo( o.comfortLevel);
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
