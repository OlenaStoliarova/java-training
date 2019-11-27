package ua.training.notebook;

public interface NoteBookRegExs {
    String EMPTY_STRING = "^$";
    String NAME = "^[a-zA-Z]+([' -]?[a-zA-Z]+)*$";
    String NICKNAME = "\\w*";
    String COMMENT = "[\\w\\W]{1,150}";
}
