package ua.training.task1var8railways.model;

import ua.training.task1var8railways.model.entity.*;

public class Model {

    public PassengerTrain createTrain(){
        PassengerTrain train56K = new PassengerTrain("056K");
        train56K.addRailcar( new SleepingRailcar("0430-254"));
        train56K.addRailcar( new CouchetteRailcar("0432-5698", CouchetteRailcarComfortLevel.THIRD_C));
        train56K.addRailcar( new CouchetteRailcar("0432-23", CouchetteRailcarComfortLevel.THIRD_B));
        train56K.addRailcar( new CompartmentRailcar("0431-9876", CompartmentRailcarComfortLevel.SECOND_B));
        train56K.addRailcar( new CouchetteRailcar("0432-23", CouchetteRailcarComfortLevel.THIRD_A));
        train56K.addRailcar( new CompartmentRailcar("0431-546", CompartmentRailcarComfortLevel.SECOND_A));
        train56K.addRailcar( new SleepingRailcar("0430-350"));
        train56K.addRailcar( new CompartmentRailcar("0431-13", CompartmentRailcarComfortLevel.SECOND_C));
        train56K.addRailcar( new CouchetteRailcar("0432-5479", CouchetteRailcarComfortLevel.THIRD_B));
        train56K.addRailcar( new CompartmentRailcar("0431-13", CompartmentRailcarComfortLevel.SECOND_A));

        return train56K;
    }
}
