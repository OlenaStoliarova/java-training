package ua.training.notebook.controller;

public enum ContactType {
    VIP (1, "ВАЖЛИВІ"),
    FAMILY (2, "СІМ'Я"),
    FRIENDS (3, "ДРУЗІ"),
    COLLEAGUES (4, "КОЛЕГИ"),
    GENERAL (5, "ЗАГАЛЬНІ");

    private int value;
    private String ukrName;

    ContactType(int value, String ukrName){
        this.value = value;
        this.ukrName = ukrName;
    }

    public int getValue(){
        return this.value;
    }

    public String getUkrName(){ return this.ukrName;}

    public static ContactType getContactType (int value){
        for(ContactType type: ContactType.values()){
            if (type.getValue()==value) return type;}
        return GENERAL;
    }
}
