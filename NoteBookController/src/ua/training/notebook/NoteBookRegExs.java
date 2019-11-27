package ua.training.notebook;

public interface NoteBookRegExs {
    String EMPTY_STRING = "^$";
    String NAME = "^[a-zA-Z]+([' -]?[a-zA-Z]+)*$";
    String NICKNAME = "\\w+";
    String COMMENT = "[\\w\\W]{1,150}";
    String PHONE = "[+][0-9]{2}[(][0-9]{3}[)][0-9]{3}[-][0-9]{2}[-][0-9]{2}"; //+38(050)555-55-55
    String PHONE_NO_DELIMITERS = "[+][0-9]{12}"; // +380505555555
}
