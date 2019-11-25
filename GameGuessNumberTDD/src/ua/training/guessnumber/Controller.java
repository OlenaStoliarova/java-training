package ua.training.guessnumber;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public static final int DEFAULT_RANGE_MIN = 0;
    public static final int DEFAULT_RANGE_MAX = 100;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void letsPlay() {
        Scanner sc = new Scanner(System.in);

        view.printMessage(View.GREETING);
        model.setInitialInterval(DEFAULT_RANGE_MIN, DEFAULT_RANGE_MAX);
        model.setSecretNumber();
        showGuessInvitation( model.getCurrentGuessRangeMin(), model.getCurrentGuessRangeMax());

        int guess = inputIntValueWithScannerWithinCurrentGuessRange(sc);

        while ( ! model.isVictory(guess)) {
            if (model.isSecretNumberHigher(guess))
                view.printMessage(View.HIGHER);
            if (model.isSecretNumberLower(guess))
                view.printMessage(View.LOWER);

            showGuessInvitation( model.getCurrentGuessRangeMin(), model.getCurrentGuessRangeMax());
            guess = inputIntValueWithScannerWithinCurrentGuessRange(sc);
        }

        view.printMessage(View.VICTORY);
        view.printMessage(String.format(View.STATISTICS, model.getGuessHistory().size()));
        view.printMessage(String.valueOf(model.getGuessHistory()));
   }

    private int inputIntValueWithScannerWithinCurrentGuessRange(Scanner sc) {
        int res;
        while (true) {
            // check int-value
            while( ! sc.hasNextInt()) {
                view.printMessage(View.WARNING_NOT_NUMBER);
                showGuessInvitation( model.getCurrentGuessRangeMin(), model.getCurrentGuessRangeMax());
                sc.next();
            }
            res = sc.nextInt();
            if ( !isGuessWithinCurrentGuessRange(res)){
                view.printMessage(View.WARNING_OUT_OF_RANGE);
                showGuessInvitation( model.getCurrentGuessRangeMin(), model.getCurrentGuessRangeMax());
                continue;
            }
            break;
        }
        return res;
    }

    private void showGuessInvitation(int rangeMin, int RangeMax){
        view.printMessage(String.format(View.RANGE, model.getCurrentGuessRangeMin(),model.getCurrentGuessRangeMax()));
        view.printMessage(View.GUESS_INVITATION);
    }

    private boolean isGuessWithinCurrentGuessRange(int currentGuess){
        if( currentGuess <= model.getCurrentGuessRangeMin())
            return false;
        if( currentGuess >= model.getCurrentGuessRangeMax())
            return false;

        return true;
    }


}
