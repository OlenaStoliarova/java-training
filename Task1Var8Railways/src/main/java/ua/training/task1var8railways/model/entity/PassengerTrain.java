package ua.training.task1var8railways.model.entity;

import java.util.ArrayList;

public class PassengerTrain {
    private String name;
    private ArrayList<PassengerRailcar> passengerTrain = new ArrayList<>();

    public PassengerTrain(String name){
        this.name = name;
    }

    public void addRailcar(PassengerRailcar railcar){
        passengerTrain.add(railcar);
    }

    @Override
    public String toString() {
        StringBuilder allTrainCars = new StringBuilder();
        for (PassengerRailcar car: passengerTrain) {
            allTrainCars.append( car.toString() );
            allTrainCars.append( "\n");
        }
        return "PassengerTrain{" +
                "number=" + name +
                "}:\n" + allTrainCars.toString();
    }
}
