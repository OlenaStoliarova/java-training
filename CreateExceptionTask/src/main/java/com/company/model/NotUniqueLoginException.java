package com.company.model;

import java.util.Locale;
import java.util.ResourceBundle;

public class NotUniqueLoginException extends Exception {
    static String EXCEPTION_NON_UNIQUE_LOGIN = "exception.login.exists";
    static String MESSAGES_BUNDLE_NAME = "messages";

    private String login;

    public NotUniqueLoginException(String login){
        super();
        this.login = login;
    }

    @Override
    public String getMessage() {
        ResourceBundle bundle = ResourceBundle.getBundle( MESSAGES_BUNDLE_NAME, new Locale("en"));        // English
        return String.format( bundle.getString(EXCEPTION_NON_UNIQUE_LOGIN), login);
    }

    @Override
    public String getLocalizedMessage() {
        ResourceBundle bundle = ResourceBundle.getBundle( MESSAGES_BUNDLE_NAME,
                new Locale("ua", "UA"));  // Ukrainian
        return String.format( bundle.getString(EXCEPTION_NON_UNIQUE_LOGIN), login);
    }
}
