package ua.training.task1var8railways.model.entity;

import java.util.ArrayList;
import java.util.Collections;

public class PassengerTrain {
    private String name;
    private ArrayList<PassengerRailcar> passengerTrain = new ArrayList<>();

    public PassengerTrain(String name){
        this.name = name;
    }

    public PassengerTrain(String name, ArrayList<PassengerRailcar> cars){
        this.name = name;
        passengerTrain = cars;
    }

    public void addRailcar(PassengerRailcar railcar){
        passengerTrain.add(railcar);
    }

    public int countPassengers(){
        int passengerCount = 0;
        for (PassengerRailcar car: passengerTrain) {
            passengerCount += car.getNumberOfPassengers();
        }
        return passengerCount;
    }

    public int countLuggageKg(){
        int luggageKg = 0;
        for (PassengerRailcar car: passengerTrain) {
            luggageKg += car.getMaxLuggagePerPassengerKg() * car.getNumberOfPassengers();
        }
        return luggageKg;
    }

    public void sortRailcarsByComfortLevel(){
        Collections.sort(passengerTrain);
    }

    public ArrayList<PassengerRailcar> findRailcarsByNumberOfPassengers(int minNumberOfPassengers, int maxNumberOfPassengers){
        ArrayList<PassengerRailcar> onlyRequestedRailcars = new ArrayList<>();
        for (PassengerRailcar car: passengerTrain) {
            if ((car.getNumberOfPassengers() >= minNumberOfPassengers) && (car.getNumberOfPassengers() <= maxNumberOfPassengers)){
                onlyRequestedRailcars.add(car);
            }
        }
        return onlyRequestedRailcars;
    }

    public PassengerRailcar getRailcar(int index){
        return passengerTrain.get(index);
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
