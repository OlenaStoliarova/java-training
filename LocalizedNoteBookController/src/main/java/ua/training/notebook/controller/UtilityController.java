package ua.training.notebook.controller;

import ua.training.notebook.view.View;

import java.util.Scanner;

class UtilityController {
    private Scanner sc;
    private View view;

    UtilityController(Scanner scanner, View view) {
        this.sc = scanner;
        this.view = view;
    }

    String inputStringWithScannerUsingRegEx(String enterInvitationMessage, String expectedFormatRegEx, String wrongFormatMessage) {
        String input;

        view.printMessage(enterInvitationMessage);

        while (true) {
            input = sc.nextLine();

            if (!input.matches(expectedFormatRegEx)) {
                view.printMessage(wrongFormatMessage);
                view.printMessage(enterInvitationMessage);
            } else {
                break;
            }
        }

        return input;
    }
}
