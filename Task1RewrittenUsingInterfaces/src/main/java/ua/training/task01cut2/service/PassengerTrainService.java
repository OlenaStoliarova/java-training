package ua.training.task01cut2.service;

import ua.training.task01cut2.entity.BaggageRailcar;
import ua.training.task01cut2.entity.passenger_railcar.PassengerRailcar;
import ua.training.task01cut2.entity.passenger_railcar.PassengerRailcarDirector;
import ua.training.task01cut2.interfaces.PassengerTrainRailcar;
import ua.training.task01cut2.entity.PassengerTrain;
import ua.training.task01cut2.entity.PassengerTrainRailcarComfortLevel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PassengerTrainService {

    public int countPassengers(PassengerTrain train){
        return train.getCars()
                .stream()
                //.filter(car -> car instanceof PassengerRailcar)
                //.map (car -> (PassengerRailcar) car)
                .filter(PassengerRailcar.class::isInstance)
                .map (PassengerRailcar.class::cast)
                .mapToInt(PassengerRailcar::getNumberOfPassengers)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public BigDecimal countTotalBaggageWeightTn(PassengerTrain train){

        BigDecimal totalLuggageWeightKg = train.getCars()
                .stream()
                .filter(PassengerRailcar.class::isInstance)
                .map (PassengerRailcar.class::cast)
                .map( car -> car.getTotalLuggageKg())
                .reduce( (x,y) -> x.add(y))
                .orElse(BigDecimal.ZERO);

        BigDecimal totalBaggageWeightTn =  train.getCars()
                .stream()
                .filter(BaggageRailcar.class::isInstance)
                .map(BaggageRailcar.class::cast)
                .map( car -> car.getMaxBaggageLoadTn())
                .reduce( (x,y) -> x.add(y))
                .orElse(BigDecimal.ZERO);

        return totalBaggageWeightTn.add( totalLuggageWeightKg.divide(new BigDecimal(1000)));
    }

    public PassengerTrain sortRailcarsByComfortLevel(PassengerTrain unsortedTrain) {
        PassengerTrain sortedTrain = unsortedTrain;
        sortedTrain.setCars( unsortedTrain.getCars()
                .stream()
                .sorted(Comparator.comparing(PassengerTrainRailcar::getComfortLevel))
                .collect(Collectors.toList()));
        return sortedTrain;
    }

    public List<PassengerTrainRailcar> findRailcarsByNumberOfPassengers(PassengerTrain train, int minNumberOfPassengers, int maxNumberOfPassengers){
        return train.getCars()
                .stream()
                .filter(PassengerRailcar.class::isInstance)
                .map (PassengerRailcar.class::cast)
                .filter(car -> (car.getNumberOfPassengers() >= minNumberOfPassengers) && (car.getNumberOfPassengers() <= maxNumberOfPassengers) )
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PassengerRailcarDirector passengerRailcarDirector = new PassengerRailcarDirector();
        List<PassengerTrainRailcar> cars1 = Stream.of(
                passengerRailcarDirector.buildPassengerRailcar ("0430-254", PassengerTrainRailcarComfortLevel.FIRST),
                passengerRailcarDirector.buildPassengerRailcar ("0432-5698", PassengerTrainRailcarComfortLevel.THIRD_C),
                passengerRailcarDirector.buildPassengerRailcar ("0431-546", PassengerTrainRailcarComfortLevel.SECOND_A),
                new BaggageRailcar("bag1"))
                .collect(Collectors.toList());

        PassengerTrain train = PassengerTrain.builder()
                .name("056K")
                .cars(cars1)
                .build();

        System.out.println( train.toString());

        PassengerTrainService trainService = new PassengerTrainService();
        System.out.println( "Total number of passengers in train: " + trainService.countPassengers(train));

        System.out.println( "Total weight of baggage in train (Tn): " + trainService.countTotalBaggageWeightTn(train));

        System.out.println( "\nSorted train on base of comfort level:");
        PassengerTrain sortedTrain = trainService.sortRailcarsByComfortLevel(train);
        System.out.println( sortedTrain.toString());

        List<PassengerTrainRailcar> cars2 =  trainService.findRailcarsByNumberOfPassengers(train, 10, 40);
        System.out.println( "\n" + cars2.toString());
    }
}
