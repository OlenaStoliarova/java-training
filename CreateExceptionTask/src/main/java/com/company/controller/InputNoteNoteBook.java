package com.company.controller;

import com.company.model.Model;
import com.company.model.NotUniqueLoginException;
import com.company.view.View;

import java.util.Scanner;

import static com.company.controller.RegexContainer.*;
import static com.company.controller.RegexContainer.REGEX_LOGIN;
import static com.company.view.TextConstant.*;
import static com.company.view.TextConstant.LOGIN_DATA;

/**
 * Created by student on 26.09.2017.
 */
public class InputNoteNoteBook {
    private Model model;
    private View view;
    private Scanner sc;

    private String firstName;
    private String login;

    public InputNoteNoteBook(Model model, View view, Scanner sc) {
        this.model = model;
        this.view = view;
        this.sc = sc;
    }

    public void inputNote() {
        UtilityController utilityController = new UtilityController(sc, view);
        String str = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_NAME_UKR : REGEX_NAME_LAT;

        this.firstName = utilityController.inputStringValueWithScanner(FIRST_NAME, str);

        while(true) {
            login = utilityController.inputStringValueWithScanner(LOGIN_DATA, REGEX_LOGIN);

            try {
                model.addNoteBookEntry(firstName, login);
                break;
            } catch (NotUniqueLoginException ex) {
                view.printMessage(ex.getLocalizedMessage());
            }
        }

        view.printLocalizedMessage( ENTRY_SUCCESSFULLY_ADDED);
        view.printMessage(String.format( view.returnLocalizedMessage(RESULT_ENTRY), firstName, login));
    }
}
