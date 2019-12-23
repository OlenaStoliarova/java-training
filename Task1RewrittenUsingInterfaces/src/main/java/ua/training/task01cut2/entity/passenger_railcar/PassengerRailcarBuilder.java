package ua.training.task01cut2.entity.passenger_railcar;

import ua.training.task01cut2.entity.PassengerTrainRailcarComfortLevel;

public abstract class PassengerRailcarBuilder {
    PassengerRailcar railcar;

    void createPassengerRailcar(){ railcar = new PassengerRailcar();}

    abstract void buildIdNumber(String id);
    abstract void buildTareWeight();
    abstract void buildComfortLevel(PassengerTrainRailcarComfortLevel comfortLevel);
    abstract void buildNumberOfPassengers();
    abstract void buildMaxLuggagePerPassengerKg();

    PassengerRailcar getPassengerRailcar() { return railcar;}
}
