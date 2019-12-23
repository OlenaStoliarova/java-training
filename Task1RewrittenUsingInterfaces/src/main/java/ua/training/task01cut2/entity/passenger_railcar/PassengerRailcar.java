package ua.training.task01cut2.entity.passenger_railcar;

import ua.training.task01cut2.entity.PassengerTrainRailcarComfortLevel;
import ua.training.task01cut2.entity.RailcarImpl;
import ua.training.task01cut2.interfaces.PassengerTrainRailcar;

import java.math.BigDecimal;

public class PassengerRailcar extends RailcarImpl implements PassengerTrainRailcar {
    PassengerTrainRailcarComfortLevel comfortLevel;
    int numberOfPassengers;
    int maxLuggagePerPassengerKg;

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

    private static int AVERAGE_PASSENGER_WEIGHT_KG = 100;
    @Override
    public BigDecimal getMaxWeightTn() {
        BigDecimal totalKg = getTotalLuggageKg().add( new BigDecimal(numberOfPassengers * AVERAGE_PASSENGER_WEIGHT_KG));
        return tareWeight.add(totalKg.divide(new BigDecimal(1000)));
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
