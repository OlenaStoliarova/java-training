package ua.training.task01cut2.entity.passenger_railcar;

import ua.training.task01cut2.entity.PassengerTrainRailcarComfortLevel;

public class PassengerRailcarDirector {
    PassengerRailcarBuilder passengerRailcarBuilder;
/*
    void setPassengerRailcarBuilder (PassengerRailcarBuilder b){
        passengerRailcarBuilder = b;
    }*/

    public PassengerRailcar buildPassengerRailcar(String id, PassengerTrainRailcarComfortLevel comfortLevel){
        switch (comfortLevel){
            case FIRST:
                passengerRailcarBuilder = new SleepingRailcarBuilder();
                break;

            case SECOND_A:
            case SECOND_B:
            case SECOND_C:
                passengerRailcarBuilder = new CompartmentRailcarBuilder();
                break;

            case THIRD_A:
            case THIRD_B:
            case THIRD_C:
                passengerRailcarBuilder = new CouchetteRailcarBuilder();
                break;

            default:
                throw new RuntimeException("buildPassengerRailcar: unsupported PassengerTrainRailcarComfortLevel");
        }

        passengerRailcarBuilder.createPassengerRailcar();
        passengerRailcarBuilder.buildIdNumber(id);
        passengerRailcarBuilder.buildTareWeight();
        passengerRailcarBuilder.buildComfortLevel(comfortLevel);
        passengerRailcarBuilder.buildNumberOfPassengers();
        passengerRailcarBuilder.buildMaxLuggagePerPassengerKg();

        return passengerRailcarBuilder.getPassengerRailcar();
    }
}
