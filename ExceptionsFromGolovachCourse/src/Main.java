public class Main {


    /*
    //System.out — buffered-поток вывода, а System.err — нет.
    //когда Вы пишете в System.err — ваше сообщение тут же выводится на консоль,
    //но когда пишете в System.out, то оно может на какое-то время быть буферизированно.
    //Stacktrace необработанного исключение выводится через System.err, что позволяет им обгонять «обычные» сообщения.

    public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }

    // >> RUNTIME ERROR: Exception in thread "main" java.lang.Error
    // >> sout
     */

    /*
    // INCORRECT - infinite recursion of throwing and catching NullPointerException

    public static void main(String[] args) {
        f(null);
    }
    public static void f(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe) {
            f(npe);
        }
    }
    // >> RUNTIME ERROR: Exception in thread "main" java.lang.StackOverflowError
    */


    /*
    //ALL CORRECT

    public static void main(String[] args) {
        Error ref = new Error(); // создаем экземпляр
        throw ref;               // "бросаем" его
    }

    //RUNTIME ERROR: Exception in thread "main" java.lang.Error
     */


    /*
    throw null; - >> RUNTIME ERROR: Exception in thread "main" java.lang.NullPointerException
     */

    /*
        // Error - потомок Throwable
        throw new Error(); - CORRECT

        throw new String("Hello!"); - >> COMPILATION ERROR:
     */

    /*
    //incompatible types: java.lang.String cannot be converted to java.lang.Throwable
    try {
    } catch (String s) {} - >> COMPILATION ERROR:

    try {
    } catch (Throwable t) {} - CORRECT
    */

    /*
    //Incompatible types: required 'java.lang.Throwable', found: 'java.lang.String'
    public static void main(String[] args) throws String {} - >> COMPILATION ERROR: incompatible types: java.lang.String cannot be converted to java.lang.Throwable

    public static void main(String[] args) throws Throwable {} - CORRECT
    */
}
