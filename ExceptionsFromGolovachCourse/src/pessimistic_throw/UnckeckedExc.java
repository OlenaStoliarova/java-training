package pessimistic_throw;

public class UnckeckedExc {

    //Вызов метода, который «пугает» unchecked исключением не накладывает на нас никаких обязанностей.
    // CORRECT
    public static void main(String[] args) {
        f();
    }
    public static void f() throws RuntimeException {
    }
}
