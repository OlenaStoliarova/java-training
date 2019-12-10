package pessimistic_throw;

//Рассмотрим ситуацию с кодом, который может бросать проверяемые исключения разных типов.
//Далее учитывайте, что EOFException и FileNotFoundException — потомки IOException.

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SeveralExceptions {

    //Можно и вот так: EOFException и FileNotFoundException «обобщаем до» IOException,
    // а InterruptedException «пропускаем нетронутым» (InterruptedException — НЕ потомок IOException)
    public static void main(String[] args) throws IOException, InterruptedException {
        f0();
        f1();
        f2();
    }
    public static void f0() throws EOFException {}
    public static void f1() throws FileNotFoundException {}
    public static void f2() throws InterruptedException {}
    // CORRECT

    /*
    // пугаем ПРЕДКОМ исключений
    public static void main(String[] args) throws IOException {
        f0();
        f1();
    }
    public static void f0() throws EOFException {}
    public static void f1() throws FileNotFoundException {}
    // CORRECT
     */

    /*
    //А можем «испугать» сильнее (предком обоих исключений)
    // пугаем ПРЕДКОМ исключений
    public static void main(String[] args) throws IOException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
    // CORRECT
     */

    /*
    // пугаем ОБОИМИ исключениями
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        f0();
        f1();
    }
    public static void f0() throws EOFException {}
    public static void f1() throws FileNotFoundException {}
    // CORRECT
    */

    /*
    //Мы можем точно указать, что выбрасываем
    // пугаем ОБОИМИ исключениями
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
    // CORRECT
    */
}
