package ua.training.guessnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private int currentGuessRangeMin;
    private int currentGuessRangeMax;

    private int secretNumber;  //numberToGuess
    private List<Integer> guessHistory = new ArrayList<Integer>();
    
    public void setInitialInterval(int guessRangeMin, int guessRangeMax) {
        currentGuessRangeMin = guessRangeMin;
        currentGuessRangeMax = guessRangeMax;
    }

    public boolean isVictory(int currentGuess){
        guessHistory.add(currentGuess);

        if ((currentGuess < secretNumber) && (currentGuess > currentGuessRangeMin))
            currentGuessRangeMin = currentGuess;

        if ((currentGuess > secretNumber) && (currentGuess < currentGuessRangeMax))
            currentGuessRangeMax = currentGuess;

        return secretNumber == currentGuess;
    }

    public boolean isSecretNumberLower(int currentGuess){
        return secretNumber < currentGuess;
    }

    public boolean isSecretNumberHigher(int currentGuess){
        return secretNumber > currentGuess;
    }

    public int getCurrentGuessRangeMin() {
        return currentGuessRangeMin;
    }

    public int getCurrentGuessRangeMax() {
        return currentGuessRangeMax;
    }

    public List<Integer> getGuessHistory() {
        return guessHistory;
    }

    public void setSecretNumber() {
        secretNumber = rand(currentGuessRangeMin, currentGuessRangeMax);
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    /*Функция rand. Описание:
    int rand ( [int min, int max] )
    Например, если вам нужно случайное число между 5 и 15 (включительно), вызовите
    rand (5, 15).*/
    private int rand(int rangeMin, int rangeMax) {
        Random random = new Random();
        //nextInt(int n) returns a pseudorandom int value between 0 (inclusive) and the specified value (exclusive),
        return random.nextInt(rangeMax-1 - rangeMin) + rangeMin + 1;
    }
}
