package ua.training.task01cut2.entity.passenger_railcar;

import ua.training.task01cut2.entity.PassengerTrainRailcarComfortLevel;
import ua.training.task01cut2.entity.RailcarImpl;
import ua.training.task01cut2.interfaces.PassengerTrainRailcar;

import java.math.BigDecimal;

public class PassengerRailcar extends RailcarImpl implements PassengerTrainRailcar {
    private PassengerTrainRailcarComfortLevel comfortLevel;
    private int numberOfPassengers;
    private int maxLuggagePerPassengerKg;

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
    public BigDecimal getTotalLuggageKg() {
        return new BigDecimal(maxLuggagePerPassengerKg * numberOfPassengers);
    }

    @Override
    public PassengerTrainRailcarComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    @Override
    public BigDecimal getMaxWeightTn() {
        int AVERAGE_PASSENGER_WEIGHT_KG = 100;
        BigDecimal totalKg = getTotalLuggageKg().add( new BigDecimal(numberOfPassengers * AVERAGE_PASSENGER_WEIGHT_KG));
        return tareWeight.add(totalKg.divide(new BigDecimal(1000), 3, BigDecimal.ROUND_HALF_UP));
    }

    public void setComfortLevel(PassengerTrainRailcarComfortLevel comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setMaxLuggagePerPassengerKg(int maxLuggagePerPassengerKg) {
        this.maxLuggagePerPassengerKg = maxLuggagePerPassengerKg;
    }

    @Override
    public String toString() {
        return "PassengerRailcar{" +
                "idNumber='" + idNumber + '\'' +
                ", comfortLevel=" + comfortLevel +
                ", numberOfPassengers=" + numberOfPassengers +
                ", maxLuggagePerPassengerKg=" + maxLuggagePerPassengerKg +
                ", tareWeight=" + tareWeight +
                '}';
    }
}
