package ua.training.task1var8railways;

import ua.training.task1var8railways.controller.Controller;
import ua.training.task1var8railways.model.Model;
import ua.training.task1var8railways.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.showProgramActions();
    }
}
