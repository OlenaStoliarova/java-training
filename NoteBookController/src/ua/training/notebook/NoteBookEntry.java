package ua.training.notebook;

import java.util.Date;

public class NoteBookEntry {
    String contactLastName;
    String contactFirstName;
    String contactPatronymic;
    String contactShortName; // Lastname N.
    String contactNickname;

    String comment;
    ContactType contactType;

    String contactHomePhone;
    String contactCellPhone;
    String contactCellPhone2;

    String contactEmail;
    String contactSkype;
    
    String contactZipCode;
    String contactCity;
    String contactStreet;
    String contactBuilding;
    String contactAppartment;
    String contactAddress;

    Date entryCreationDate;
    Date entryLastEditDate;
}
