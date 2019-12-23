package ua.training.task01cut2.entity;

import ua.training.task01cut2.interfaces.PassengerTrainRailcar;

import java.math.BigDecimal;

public class BaggageRailcar extends RailcarImpl implements PassengerTrainRailcar {
    public static final int STANDARD_TARE_WEIGHT_TN = 51;
    public static final int STANDARD_MAX_LOAD_TN = 21;

    PassengerTrainRailcarComfortLevel comfortLevel;
    BigDecimal maxBaggageLoadTn;

    public BaggageRailcar(String id){
        super.setIdNumber(id);
        super.setTareWeight(new BigDecimal(STANDARD_TARE_WEIGHT_TN));
        comfortLevel = PassengerTrainRailcarComfortLevel.BAGGAGE;
        maxBaggageLoadTn = new BigDecimal(STANDARD_MAX_LOAD_TN);
    }

    @Override
    public PassengerTrainRailcarComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    @Override
    public BigDecimal getMaxWeightTn() {
        return tareWeight.add(maxBaggageLoadTn);
    }

    public BigDecimal getMaxBaggageLoadTn() {
        return maxBaggageLoadTn;
    }

    @Override
    public String toString() {
        return "BaggageRailcar{" +
                "idNumber='" + idNumber + '\'' +
                ", comfortLevel=" + comfortLevel +
                ", maxBaggageLoadTn=" + maxBaggageLoadTn +
                ", tareWeight=" + tareWeight +
                '}';
    }
}
