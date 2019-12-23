package ua.training.task01cut2.entity;

import lombok.*;
import ua.training.task01cut2.interfaces.Locomotive;
import ua.training.task01cut2.interfaces.PassengerTrainRailcar;

import java.util.List;

@Builder
@Getter
@Setter
public class PassengerTrain {
    @NonNull
    private String name;
    private Locomotive locomotive;
    @Singular
    private List<PassengerTrainRailcar> cars;

    @Override
    public String toString() {
        StringBuilder allTrainCars = new StringBuilder();
        for (PassengerTrainRailcar car: cars) {
            allTrainCars.append( car.toString() );
            allTrainCars.append( "\n");
        }

        return "PassengerTrain{" +
                "number='" + name + '\'' +
                ", locomotive=" + locomotive + "}:\n" +
                allTrainCars.toString();
    }
}
