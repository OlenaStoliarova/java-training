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

    public static final String PHONE_HOME = "contact's home phone number";
    public static final String PHONE_CELL1 = "contact's cell phone number";
    public static final String PHONE_CELL2 = "contact's second cell phone number";
    public static final String FOR_EXAMPLE = " (for example: %s)";
    public static final String PHONE_EXPECTED_FORMAT = "+38(050)111-11-11 (with or without delimiters)";
    public static final String WRONG_PHONE_FORMAT = "please enter phone in expected format";

    public static final String EMAIL = "contact's e-mail";
    public static final String WRONG_EMAIL_FORMAT = "wrong format. please enter valid email";


    public void printMessage(String message){
        System.out.println(message);
    }
}
