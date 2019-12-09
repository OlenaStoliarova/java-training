package finally_test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExperimentsWithFinally {

    //Не рекомендуемые практики
    //— return из finally-секции (можем затереть исключение из try-блока)
    //— действия в finally-секции, которые могут бросить исключение (можем затереть исключение из try-блока)




    //Вообще говоря, в finally-секция нельзя стандартно узнать было ли исключение.
    //Конечно, можно постараться написать свой «велосипед»
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        long rnd = System.currentTimeMillis();
        boolean finished = false;
        try {
            if (rnd % 3 == 0) {
                throw new Error();
            } else if (rnd % 3 == 1) {
                throw new RuntimeException();
            } else {
                // nothing
            }
            finished = true;
        } finally {
            if (finished) {
                // не было исключений
                System.err.println("OK");
            } else {
                // было исключение, но какое?
                System.err.println("some exception");
            }
        }
        return 1;
    }

    /*
    //finally-секция может быть использована для завершающего действия, которое гарантированно будет вызвано
    // (даже если было брошено исключение или автор использовал return) по окончании работы
    // open some resource
    try {
        // use resource
    } finally {
        // close resource
    }

    public static void main(String[] args) {
        //Например для освобождения захваченной блокировки
        Lock lock = new ReentrantLock();

        lock.lock();
        try {
            // some code
        } finally {
            lock.unlock();
        }

        //Или для закрытия открытого файлового потока
        InputStream input = new FileInputStream("...");
        try {
            // some code
        } finally {
            input.close();
        }
    }
    */

    /*
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            throw new Error();
        } finally {
            throw new RuntimeException();
        }
    }
    //Exception in thread "main" java.lang.RuntimeException
     */

    /*
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            return 0;
        } finally {
            throw new RuntimeException();
        }
    }
    //Exception in thread "main" java.lang.RuntimeException
    */

    /*
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            throw new RuntimeException();
        } finally {
            return 1;
        }
    }
    // 1 (and NO EXCEPTION)
     */

    /*
    //finally-секция может «перебить» throw/return при помощи другого throw/return
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }
    // 1
    */

    /*
    //finally-секция не может «предотвратить» выход из метода, если try-блок вызвал return («more» — не выводится в консоль)
    public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {return;}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
    //try
    //finally
    */

    /*
    //Трюк с «if (true) {...}» требуется, так как иначе компилятор
    // обнаруживает недостижимый код (последняя строка) и отказывается его компилировать
    public static void main(String[] args) {
        try {
            System.err.println("try");
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
        System.err.println("more"); //COMPILER ERROR: unreachable statement
    }
    //COMPILER ERROR: unreachable statement
    */

    /*
    //finally-секция не может «починить» try-блок завершившийся исключение (заметьте, «more» — не выводится в консоль)
    public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {throw new RuntimeException();}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
    //try
    //finally
    //Exception in thread "main" java.lang.RuntimeException
    */

    /*
    //И при Runtime.getRuntime().halt(42) — тоже не успевает зайти в finally
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().halt(42);
        } finally {
            System.err.println("finally");
        }
    }
    // Process finished with exit code 42
     */

    /*
    //finally-секция НЕ вызывается только если мы «прибили» JVM
    public static void main(String[] args) {
        try {
            System.exit(42);
            //Runtime.getRuntime().exit(42);   //System.exit(42) и Runtime.getRuntime().exit(42) — это синонимы
        } finally {
            System.err.println("finally");
        }
    }
    //Process finished with exit code 42
     */

    /*
    //finally-секция получает управление, даже если try-блок завершился директивой выхода из метода
    public static void main(String[] args) {
        try {
            return;
        } finally {
            System.err.println("finally");
        }
    }
    // >> finally
     */

    /*
    //finally-секция получает управление, даже если try-блок завершился исключением
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
    }
    //finally
    //Exception in thread "main" java.lang.RuntimeException
    */

    /*
    //finally-секция получает управление, если try-блок завершился успешно
    public static void main(String[] args) {
        try {
            System.err.println("try");
        } finally {
            System.err.println("finally");
        }
    }
    //try
    //finally
    */
}
