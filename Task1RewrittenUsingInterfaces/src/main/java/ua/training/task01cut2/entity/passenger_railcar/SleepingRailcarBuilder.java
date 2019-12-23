package ua.training.task01cut2.entity.passenger_railcar;

import ua.training.task01cut2.entity.PassengerTrainRailcarComfortLevel;

import java.math.BigDecimal;

public class SleepingRailcarBuilder extends PassengerRailcarBuilder {
    public static final int STANDARD_TARE_WEIGHT_TN = 48;
    public static final int STANDARD_NUMBER_OF_PASSENGERS = 18;
    public static final int STANDARD_LUGGAGE_ALLOWANCE = 50;

    @Override
    void buildIdNumber(String id) {  railcar.setIdNumber(id);  }

    @Override
    void buildTareWeight() { railcar.setTareWeight( new BigDecimal(STANDARD_TARE_WEIGHT_TN));}

    @Override
    void buildComfortLevel(PassengerTrainRailcarComfortLevel comfortLevel) { railcar.setComfortLevel(PassengerTrainRailcarComfortLevel.FIRST);}

    @Override
    void buildNumberOfPassengers() { railcar.setNumberOfPassengers(STANDARD_NUMBER_OF_PASSENGERS); }

    @Override
    void buildMaxLuggagePerPassengerKg() { railcar.setMaxLuggagePerPassengerKg(STANDARD_LUGGAGE_ALLOWANCE); }
}
