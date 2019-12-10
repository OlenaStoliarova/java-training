package pessimistic_throw;

import java.io.IOException;

//Я называю связь между проверяемыми исключениями и throws — «пессимистичной», поскольку
//мы можем «напугать» о большем, чем может произойти на самом деле, но не наоборот
public class PT {

    //Хотя они (испугавшиеся) могут перепугать остальных еще больше
    // CORRECT
    // они пугают целым Throwable
    public static void main(String[] args) throws Throwable {
        f();
    }
    // хотя мы пугали всего-лишь Exception
    public static void f() throws Exception {
    }

    /*
    //Даже если предупреждаем о том, чего нет — все обязаны бояться
    public static void main(String[] args) {
        f(); // тут ошибка компиляции
    }

    public static void f() throws Exception {
    }
    // >> COMPILATION ERROR:  unreported exception java.lang.Exception; must be caught or declared to be thrown
    */

    /*
    // CORRECT
    //Можем даже предупредить о том, чего вообще нет
    public static void main(String[] args) throws Exception { // пугаем
        // но ничего не бросаем
    }
    */

    /*
    // CORRECT
    //Мы можем предупредить о большем, чем мы бросаем
    public static void main(String[] args) throws Throwable { // предупреждаем "целом" Throwable
        throw new Exception(); // а кидаем только Exception
    }
     */

    /*
    // CORRECT
    //Мы можем предупредить точно о том, что бросаем
    public static void main(String[] args) throws Exception { // предупреждаем о Exception
        throw new Exception(); // и кидаем Exception
    }
     */

    /*
    //Мы не можем бросать, но предупредить о «меньшем»
    public static void main(String[] args) throws IOException {
        throw new Exception(); // тут ошибка компиляции
    }
    // >> COMPILATION ERROR:  unreported exception java.lang.Exception; must be caught or declared to be thrown
    */

    /*
    //Мы не можем бросать, но не предупредить
    public static void main(String[] args) {
        throw new Exception(); // тут ошибка компиляции
    }
    // >> COMPILATION ERROR:  unreported exception java.lang.Exception; must be caught or declared to be thrown
    */
}
