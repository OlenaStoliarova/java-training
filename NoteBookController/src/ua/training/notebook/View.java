package ua.training.notebook;

public class View {
    public static final String GREETING = "Hello! I'll help you to add contact to the notebook correctly";
    public static final String PLEASE_ENTER = "please enter ";
    public static final String LASTNAME = "contact's last name";
    public static final String FIRSTNAME = "contact's first name";
    public static final String PATRONYMIC = "contact's patronymic";
    public static final String SKIP = " (you can skip this step by pressing Enter)";
    public static final String WRONG_INPUT_NAME = "only letters, apostrophe, hyphen and space are allowed";

    public static final String NICKNAME = "contact's nickname";
    public static final String WRONG_INPUT_NICKNAME = "only letters, numbers and underscore character are allowed";

    public static final String COMMENT = "comment about the contact";
    public static final String WRONG_COMMENT_LENGTH = "maximum length of Comment field is 150 characters";

    public void printMessage(String message){
        System.out.println(message);
    }
}
