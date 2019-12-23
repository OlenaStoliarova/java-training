package ua.training.task01cut2.interfaces;

import ua.training.task01cut2.entity.PassengerTrainRailcarComfortLevel;
import ua.training.task01cut2.entity.passenger_railcar.PassengerRailcar;

public interface PassengerTrainRailcar extends Railcar {
    PassengerTrainRailcarComfortLevel getComfortLevel();
}
