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
}
