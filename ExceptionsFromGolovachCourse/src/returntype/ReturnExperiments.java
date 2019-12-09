package returntype;

public class ReturnExperiments {

    public static void main(String[] args) {
        System.out.println( area(10,-20));
    }

    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }

    /*
    //бросаемое исключение — это дополнительный возвращаемый тип.
    //Если ваш метод объявил, что возвращает double, но у вас нет double — можете бросить исключение.
    //Если ваш метод объявил, что ничего не возвращает (void), но у вам таки есть что сказать — можете бросить исключение.
    public static void main(String[] args) {
        // sqr - "сломается" (из него "выскочит" исключение),
        double d = sqr(10.0);  // выполнение метода main() прервется в этой строчке и
        // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
        System.out.println(d); // и печатать нам ничего не придется!
    }
    public static double sqr(double arg) {
        throw new RuntimeException(); // "бросаем" исключение
    }
    //>> RUNTIME ERROR: Exception in thread "main" java.lang.RuntimeException
    */

    /*
    //у нас есть ТРИ варианта для компилятора
    public static double sqr(double arg) {// согласно объявлению метода ты должен вернуть double
        long time = System.currentTimeMillis();
        if (time % 2 == 0) {
            return arg * arg;             // ок, вот твой double
        } else if (time % 2 == 1) {
            while (true);                 // не, я решил "повиснуть"
        } else {
            throw new RuntimeException(); // или бросить исключение
        }
    }
    */

    /*
    //ALL CORRECT
    public static double sqr(double arg) {
        throw new RuntimeException(); //механизм исключений позволяет НИЧЕГО НЕ ВОЗВРАЩАТЬ!
    }
     */

    /*
    // for some reason it's OK for the compiler

    public static double sqr(double arg) {
        if (System.currentTimeMillis() % 2 == 0) {
            return arg * arg; // ну ладно, вот твой double
        } else {
            while (true);     // а тут "виснем" навсегда
        }
    }
    */

    /*
    // for some reason it's OK for the compiler
    public static void main(String[] args) {
        double d = sqr(10.0);  // sqr - навсегда "повиснет", и
        System.out.println(d); // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
    }
    public static double sqr(double arg) {
        while (true); // Вот тут мы на века "повисли"
    }
    */

    /*
    public static double sqr(double arg) {
        while (true); // Удивительно, но КОМПИЛИРУЕТСЯ!
    }
     */

    /*
    // INCORRECT
    public static void main(String[] args) {
        double d = sqr(10.0); // ну, и чему равно d?
        System.out.println(d);
    }
    public static double sqr(double arg) {
        // nothing
    }
    //COMPILATION ERROR: missing return statement
    */


    /*
    // INCORRECT
    public static double sqr(double arg) {
        if (System.currentTimeMillis() % 2 == 0) {
            return arg * arg; // если currentTimeMillis() - четное число, то все ОК
        }
        // а если нечетное, что нам возвращать?
    }
    //COMPILATION ERROR: missing return statement
    */

    /*
    // INCORRECT
    public static double sqr(double arg) {
    }
    //COMPILATION ERROR: missing return statement
    */

    /*
    // INCORRECT
    public static double sqr(double arg) {
        return "hello!";
    }
    //COMPILATION ERROR: incompatible types: java.lang.String cannot be converted to double
     */

    /*
    //ALL CORRECT
    public double sqr(double arg) { // надо double
        int k = 1;                  // есть int
        return k;                   // можно неявно преобразовать int в double
    }
    */

    /*
    //ALL CORRECT
    public double sqr(double arg) { // надо double
        return arg * arg;           // double * double - это double
    }
    */
}
