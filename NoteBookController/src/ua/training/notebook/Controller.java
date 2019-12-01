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

        String enteredPhone = inputStringWithScannerUsingRegEx(sc,
                    View.PLEASE_ENTER + View.PHONE_HOME + String.format(View.FOR_EXAMPLE, View.PHONE_EXPECTED_FORMAT) + View.SKIP,
                     NoteBookRegExs.PHONE + "|" + NoteBookRegExs.PHONE_NO_DELIMITERS + "|" + NoteBookRegExs.EMPTY_STRING, View.WRONG_PHONE_FORMAT);
        noteBookEntry.contactHomePhone = addDelimitersToPhoneNumber(enteredPhone);

        enteredPhone = inputStringWithScannerUsingRegEx(sc,
                View.PLEASE_ENTER + View.PHONE_CELL1 + String.format(View.FOR_EXAMPLE, View.PHONE_EXPECTED_FORMAT),
                NoteBookRegExs.PHONE + "|" + NoteBookRegExs.PHONE_NO_DELIMITERS, View.WRONG_PHONE_FORMAT);
        noteBookEntry.contactCellPhone = addDelimitersToPhoneNumber(enteredPhone);

        enteredPhone = inputStringWithScannerUsingRegEx(sc,
                View.PLEASE_ENTER + View.PHONE_CELL2 + String.format(View.FOR_EXAMPLE, View.PHONE_EXPECTED_FORMAT) + View.SKIP,
                NoteBookRegExs.PHONE + "|" + NoteBookRegExs.PHONE_NO_DELIMITERS + "|" + NoteBookRegExs.EMPTY_STRING, View.WRONG_PHONE_FORMAT);
        noteBookEntry.contactCellPhone2 = addDelimitersToPhoneNumber(enteredPhone);

        noteBookEntry.contactEmail = inputStringWithScannerUsingRegEx(sc,
                View.PLEASE_ENTER + View.EMAIL + View.SKIP,
                NoteBookRegExs.EMAIL + "|" + NoteBookRegExs.EMPTY_STRING, View.WRONG_EMAIL_FORMAT);


        view.printMessage( View.LASTNAME + ":\t\t" + noteBookEntry.contactLastName);
        view.printMessage( View.FIRSTNAME + ":\t\t" + noteBookEntry.contactFirstName);
        view.printMessage( View.PATRONYMIC + ":\t\t" + noteBookEntry.contactPatronymic);
        view.printMessage( "contact's short name:\t\t" + noteBookEntry.contactShortName);
        view.printMessage( View.NICKNAME + ":\t\t\t" + noteBookEntry.contactNickname);
        view.printMessage( View.COMMENT + ":\t\t" + noteBookEntry.comment);
        view.printMessage( View.PHONE_HOME + ":\t\t" + noteBookEntry.contactHomePhone);
        view.printMessage( View.PHONE_CELL1 + ":\t\t" + noteBookEntry.contactCellPhone);
        view.printMessage( View.PHONE_CELL2 + ":\t\t" + noteBookEntry.contactCellPhone2);
        view.printMessage( View.EMAIL + ":\t\t" + noteBookEntry.contactEmail);

        model.addContact(noteBookEntry);
    }

    private String addDelimitersToPhoneNumber(String enteredPhone) {
        if ( !enteredPhone.equals("")) {
            StringBuilder result = new StringBuilder(17);
            if (!enteredPhone.contains("(")) {
                result.append(enteredPhone,0, 3);
                result.append("(");
                result.append(enteredPhone, 3, 6);
                result.append(")");
                result.append(enteredPhone, 6, 9);
                result.append("-");
                result.append(enteredPhone, 9, 11);
                result.append("-");
                result.append(enteredPhone, 11, 13);
                return result.toString();
            }
        }
        return enteredPhone;
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
