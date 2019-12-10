package pessimistic_throw;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class CatchVsThrows {

    //Если вы часть перехватили, то можете этим не пугать
    // EOFException перехватили catch-ом, им не пугаем
    public static void main(String[] args) throws FileNotFoundException {
        try {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        } catch (EOFException e) {
            // ...
        }
    }
    // CORRECT

    /*
    //Не надо пугать тем, что вы перехватили
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            // ...
        }
    }
    // CORRECT
     */
}
