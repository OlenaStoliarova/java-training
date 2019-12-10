package com.company.model;

/**
 * Created by student on 26.09.2017.
 */
public class Model {

    public void addNoteBookEntry (String firstName, String login) throws NotUniqueLoginException {
        for (NoteBook existingEntries : NoteBook.values()){
            if (login.equalsIgnoreCase(existingEntries.getLogin()))
                throw new NotUniqueLoginException(login);
        }
    }
}
