package com.company.model;

public enum NoteBook {
    NOTE1 ("", "krasava007"),
    NOTE2 ("", "Lenochka-Penochka"),
    NOTE3 ("", "Vovka_morkovka"),
    NOTE4 ("", "PaNdA"),
    NOTE5 ("", "drD");

    private String firstName;
    private String login;

    NoteBook(String name, String login){
        firstName = name;
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }
}
