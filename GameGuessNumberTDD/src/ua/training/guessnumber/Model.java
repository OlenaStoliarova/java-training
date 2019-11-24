package ua.training.guessnumber;

public class Model {
    private int currentGuessRangeMin;
    private int currentGuessRangeMax;
    
    public void setInitialInterval(int guessRangeMin, int guessRangeMax) {
        currentGuessRangeMin = guessRangeMin;
        currentGuessRangeMax = guessRangeMax;
    }

    public int getCurrentGuessRangeMin() {
        return currentGuessRangeMin;
    }

    public int getCurrentGuessRangeMax() {
        return currentGuessRangeMax;
    }
}
