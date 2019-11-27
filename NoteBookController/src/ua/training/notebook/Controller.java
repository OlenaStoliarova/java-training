package ua.training.notebook;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;

public class Controller{
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void enterContact(){
        Scanner sc = new Scanner(System.in);
        NoteBookEntry noteBookEntry = new NoteBookEntry();

        view.printMessage(View.GREETING);

        noteBookEntry.contactLastName = inputStringWithScannerUsingRegEx(sc,View.PLEASE_ENTER + View.LASTNAME, NoteBookRegExs.NAME, View.WRONG_INPUT_NAME);
        noteBookEntry.contactFirstName = inputStringWithScannerUsingRegEx(sc,View.PLEASE_ENTER + View.FIRSTNAME, NoteBookRegExs.NAME, View.WRONG_INPUT_NAME);
        noteBookEntry.contactPatronymic = inputStringWithScannerUsingRegEx(sc,View.PLEASE_ENTER + View.PATRONYMIC + View.SKIP, NoteBookRegExs.EMPTY_STRING + "|" +NoteBookRegExs.NAME, View.WRONG_INPUT_NAME);
        noteBookEntry.contactShortName = noteBookEntry.contactLastName + " " + noteBookEntry.contactFirstName.charAt(0) + "." ;

        noteBookEntry.contactNickname = inputStringWithScannerUsingRegEx(sc,View.PLEASE_ENTER + View.NICKNAME, NoteBookRegExs.NICKNAME, View.WRONG_INPUT_NICKNAME);
        noteBookEntry.comment = inputStringWithScannerUsingRegEx(sc,View.PLEASE_ENTER + View.COMMENT + View.SKIP, NoteBookRegExs.EMPTY_STRING + "|" + NoteBookRegExs.COMMENT, View.WRONG_COMMENT_LENGTH);

        view.printMessage( View.LASTNAME + ": " + noteBookEntry.contactLastName);
        view.printMessage( View.FIRSTNAME + ": " + noteBookEntry.contactFirstName);
        view.printMessage( View.PATRONYMIC + ": " + noteBookEntry.contactPatronymic);
        view.printMessage( "contact's short name: " + noteBookEntry.contactShortName);
        view.printMessage( View.NICKNAME + ": " + noteBookEntry.contactNickname);
        view.printMessage( View.COMMENT + ": " + noteBookEntry.comment);

        model.addContact(noteBookEntry);
    }

    private String inputStringWithScannerUsingRegEx(Scanner sc, String enterInvitationMessage, String expectedFormatRegEx, String wrongFormatMessage) {
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
