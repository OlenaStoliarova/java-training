package ua.training.notebook.controller;

import ua.training.notebook.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static ua.training.notebook.view.TextConstants.*;

public class InputNoteBookEntry {
    private View view;
    private Scanner sc;

    private String contactLastName;
    private String contactFirstName;
    private String contactPatronymic;
    private String contactShortName; // Lastname N.
    private String contactNickname;

    private String comment;
    private ContactType contactType;

    private String contactHomePhone;
    private String contactCellPhone;
    private String contactCellPhone2;

    private String contactEmail;
    private String contactSkype;

    private String contactZipCode;
    private String contactCity;
    private String contactStreet;
    private String contactBuilding;
    private String contactApartment;
    private String contactAddress;

    private Date entryCreationDate;
    private Date entryLastEditDate;

    public InputNoteBookEntry (View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
    }

    public void inputEntry() {
        UtilityController utilityController = new UtilityController(sc, view);
        String currentLocale = view.getLocale();
/*
        contactLastName = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, LASTNAME),
                currentLocale.equals("uk_UA") ? NoteBookRegExs.NAME_UKR : NoteBookRegExs.NAME_LAT,
                view.returnLocalizedMessage(WRONG_INPUT_NAME));

        contactFirstName = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, FIRSTNAME),
                currentLocale.equals("uk_UA") ? NoteBookRegExs.NAME_UKR : NoteBookRegExs.NAME_LAT,
                view.returnLocalizedMessage(WRONG_INPUT_NAME));

        contactPatronymic = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, PATRONYMIC, SKIP),
                NoteBookRegExs.EMPTY_STRING + "|" + (currentLocale.equals("uk_UA") ? NoteBookRegExs.NAME_UKR : NoteBookRegExs.NAME_LAT),
                view.returnLocalizedMessage(WRONG_INPUT_NAME));

        contactShortName = contactLastName + " " + contactFirstName.charAt(0) + ".";

        contactNickname = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, NICKNAME),
                NoteBookRegExs.NICKNAME,
                view.returnLocalizedMessage(WRONG_INPUT_NICKNAME));

        comment = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, COMMENT, SKIP),
                NoteBookRegExs.EMPTY_STRING + "|" + NoteBookRegExs.COMMENT,
                view.returnLocalizedMessage(WRONG_COMMENT_LENGTH));

        String enteredPhone = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, PHONE_HOME, PHONE_EXPECTED_FORMAT, SKIP),
                NoteBookRegExs.PHONE + "|" + NoteBookRegExs.PHONE_NO_DELIMITERS + "|" + NoteBookRegExs.EMPTY_STRING,
                view.returnLocalizedMessage(WRONG_PHONE_FORMAT));
        contactHomePhone = addDelimitersToPhoneNumber(enteredPhone);

        enteredPhone = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, PHONE_CELL1, PHONE_EXPECTED_FORMAT),
                NoteBookRegExs.PHONE + "|" + NoteBookRegExs.PHONE_NO_DELIMITERS,
                view.returnLocalizedMessage(WRONG_PHONE_FORMAT));
        contactCellPhone = addDelimitersToPhoneNumber(enteredPhone);

        enteredPhone = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, PHONE_CELL2, PHONE_EXPECTED_FORMAT, SKIP),
                NoteBookRegExs.PHONE + "|" + NoteBookRegExs.PHONE_NO_DELIMITERS + "|" + NoteBookRegExs.EMPTY_STRING,
                view.returnLocalizedMessage(WRONG_PHONE_FORMAT));
        contactCellPhone2 = addDelimitersToPhoneNumber(enteredPhone);

        contactEmail = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, EMAIL, SKIP),
                NoteBookRegExs.EMAIL + "|" + NoteBookRegExs.EMPTY_STRING,
                view.returnLocalizedMessage(WRONG_EMAIL_FORMAT));

        contactSkype = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, SKYPE, SKIP),
                NoteBookRegExs.SKYPE + "|" + NoteBookRegExs.EMPTY_STRING,
                view.returnLocalizedMessage(WRONG_SKYPE_FORMAT));

        contactZipCode = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, ZIPCODE, SKIP),
                NoteBookRegExs.EMPTY_STRING + "|" + (currentLocale.equals("uk_UA") ? NoteBookRegExs.ZIPCODE_UA : NoteBookRegExs.ZIPCODE_US),
                view.returnLocalizedMessage(WRONG_ZIPCODE_FORMAT));

        contactCity = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, CITY),
                currentLocale.equals("uk_UA") ? NoteBookRegExs.NAME_UKR : NoteBookRegExs.NAME_LAT,
                view.returnLocalizedMessage(WRONG_INPUT_NAME));

        contactStreet = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, STREET),
                currentLocale.equals("uk_UA") ? NoteBookRegExs.STREET_UKR : NoteBookRegExs.STREET_LAT,
                view.returnLocalizedMessage(WRONG_INPUT_STREET));

        contactBuilding = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, BUILDING),
                currentLocale.equals("uk_UA") ? NoteBookRegExs.BUILDING_NUMBER_UKR : NoteBookRegExs.BUILDING_NUMBER_LAT,
                view.returnLocalizedMessage(WRONG_INPUT_BUILDING));

        contactApartment = utilityController.inputStringWithScannerUsingRegEx(
                view.concatenateLocalizedStrings(PLEASE_ENTER, APARTMENT, SKIP),
                NoteBookRegExs.EMPTY_STRING + "|" + (currentLocale.equals("uk_UA") ? NoteBookRegExs.APARTMENT_NUMBER_UKR : NoteBookRegExs.APARTMENT_NUMBER_LAT),
                view.returnLocalizedMessage(WRONG_INPUT_APARTMENT));

        if (currentLocale.equals("uk_UA"))
            contactAddress = contactStreet  + ", " + contactBuilding + ", " + (contactApartment.equals("") ? "" : contactApartment + ", ") + contactCity + " " + contactZipCode;
        else
            contactAddress = contactBuilding + " " + contactStreet + ", " + (contactApartment.equals("") ? "" : contactApartment + ", ") + contactCity + " " + contactZipCode;
*/
        StringBuilder all_groups = new StringBuilder();
        for ( ContactType elem: ContactType.values())
        {
            all_groups.append(elem.getValue());
            all_groups.append(" - ");
            if (currentLocale.equals("uk_UA"))
                all_groups.append(elem.getUkrName());
            else
                all_groups.append( elem.toString());
            all_groups.append("; ");
        }
        contactType = ContactType.getContactType( Integer.parseInt(utilityController.inputStringWithScannerUsingRegEx(
                view.returnLocalizedMessage(CHOOSE_CONTACT_TYPE) + "\n" + all_groups.toString(),
                NoteBookRegExs.CONTACT_TYPE,
                view.returnLocalizedMessage(WRONG_INPUT_CONTACT_TYPE))));


        entryCreationDate = new Date();
    }

    public void printNoteBookEntry(){
        String currentLocale = view.getLocale();
        String printFormat = "%-50s%s";
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(LASTNAME)+ ":", this.contactLastName));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(FIRSTNAME) + ":", this.contactFirstName));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(PATRONYMIC) + ":", this.contactPatronymic));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(SHORTNAME) + ":", this.contactShortName));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(NICKNAME) + ":", this.contactNickname));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(COMMENT) + ":", this.comment));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(TYPE) + ":", (currentLocale.equals("uk_UA") ? this.contactType.getUkrName() : this.contactType)));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(PHONE_HOME) + ":", this.contactHomePhone));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(PHONE_CELL1) + ":", this.contactCellPhone));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(PHONE_CELL2) + ":", this.contactCellPhone2));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(EMAIL) + ":", this.contactEmail));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(SKYPE) + ":", this.contactSkype));
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(ADDRESS) + ":", this.contactAddress));

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        view.printMessage( String.format( printFormat, view.returnLocalizedMessage(CREATION_DATE) + ":", formatter.format(this.entryCreationDate)));
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

}
