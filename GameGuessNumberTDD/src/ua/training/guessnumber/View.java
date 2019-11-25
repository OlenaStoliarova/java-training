package ua.training.guessnumber;

public class View {
    public static final String GREETING = "Hello! I have the random number for you. Try to guess it.";
    public static final String RANGE = "My number is within %d]...[%d (exclusively).";
    public static final String GUESS_INVITATION = "Enter your guess:";
    public static final String LOWER = "My number is lower.";
    public static final String HIGHER = "My number is higher.";
    public static final String VICTORY = "That's it! Congratulations!!!";
    public static final String WARNING_NOT_NUMBER = "Please focus! You are allowed to enter integer numbers only";
    public static final String WARNING_OUT_OF_RANGE = "Please focus! You are out of logical range";
    public static final String STATISTICS = "You've guessed my number by %d tries. Here is your way:";

    public void printMessage(String message){
        System.out.println(message);
    }

    public String concatenationString (String... message){
        StringBuilder concatString = new StringBuilder();
        for (String v : message){
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }
}
