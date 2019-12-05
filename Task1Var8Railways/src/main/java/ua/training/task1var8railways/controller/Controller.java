package ua.training.task1var8railways.controller;

import ua.training.task1var8railways.model.Model;
import ua.training.task1var8railways.model.entity.PassengerTrain;
import ua.training.task1var8railways.view.View;

import java.util.Scanner;

import static ua.training.task1var8railways.view.TextConstants.*;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void showProgramActions(){
        Scanner sc = new Scanner(System.in);

        view.printMessage(CHOOSE_LANGUAGE);
        view.setBundle( sc.nextLine());
        view.printLocalizedMessage(GREETING);

        view.printLocalizedMessage(TRAIN_CREATED);
        view.printMessage("");
        PassengerTrain train1 = model.createTrain();
        view.printMessage( train1.toString());

        view.printMessage( String.format( view.returnLocalizedMessage(PASSENGERS_AND_LUGGAGE), train1.countPassengers(), train1.countLuggageKg()));
    }
}
