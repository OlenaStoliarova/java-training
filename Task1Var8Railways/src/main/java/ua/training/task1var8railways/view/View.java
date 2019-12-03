package ua.training.task1var8railways.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    private static String MESSAGES_BUNDLE_NAME = "languages";
    private ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
            new Locale("en"));

    public void setBundle(String locale) {
        if ( locale.equals( "ua") ) {
            this.bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
                    new Locale("uk", "UA"));  // Ukrainian;
        }else{
            this.bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
                    new Locale("en"));        // English
        }
    }

    public String getLocale(){
        return String.valueOf(bundle.getLocale());
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printLocalizedMessage(String message){
        System.out.println(returnLocalizedMessage(message));
    }

    public String  returnLocalizedMessage(String message){
        return bundle.getString(message);
    }
}
