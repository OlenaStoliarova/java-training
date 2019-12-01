package ua.training.notebook.controller;

import ua.training.notebook.model.Model;
import ua.training.notebook.view.View;

import java.util.Scanner;

import static ua.training.notebook.view.TextConstants.*;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void enterContact(){
        Scanner sc = new Scanner(System.in);

        view.printMessage("choose language (ua - Ukraininan, eny key - English)");
        view.setBundle( sc.nextLine());

        view.printLocalizedMessage(GREETING);

        InputNoteBookEntry inputNoteBookEntry = new InputNoteBookEntry(view, sc);
        inputNoteBookEntry.inputEntry();
        inputNoteBookEntry.printNoteBookEntry();
    }
}
