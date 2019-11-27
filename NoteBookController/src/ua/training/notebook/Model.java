package ua.training.notebook;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<NoteBookEntry> noteBook = new ArrayList<NoteBookEntry>();

    public void addContact(NoteBookEntry newEntry){
        noteBook.add(newEntry);
    }
}
