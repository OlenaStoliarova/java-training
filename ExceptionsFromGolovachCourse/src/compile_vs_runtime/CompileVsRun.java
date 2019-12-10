package compile_vs_runtime;

//  проверка на cheched исключения происходит в момент компиляции (compile-time checking)
//  перехват исключений (catch) происходит в момент выполнения (runtime checking)

public class CompileVsRun {

    // ТЕПЕРЬ пугаем Throwable
    public static void main(String[] args) throws Throwable {
        try {
            Throwable t = new Exception(); // а лететь будет Exception
            throw t;
        } catch (Exception e) { // и мы перехватим Exception
            System.out.println("Перехвачено!");
        }
    }
    // >> Перехвачено!
    // CORRECT


    /*
    // пугаем Exception
    public static void main(String[] args) throws Exception {
        Throwable t = new Exception(); // и лететь будет Exception
        throw t; // но тут ошибка компиляции
    }
    // COMPILATION ERROR: unreported exception java.lang.Throwable; must be caught or declared to be thrown
     */
}
