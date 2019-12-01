package ua.training.notebook;

import ua.training.notebook.controller.Controller;
import ua.training.notebook.model.Model;
import ua.training.notebook.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.enterContact();
    }
}
