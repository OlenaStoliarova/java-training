package nonlocal_control_transfer;

public class NLCT {

    /*
    //При помощи catch мы можем остановить летящее исключение (причина, по которой мы автоматически покидаем фреймы).
    //Останавливаем через 2 фрейма, пролетаем фрейм #4(метод h()) + пролетаем фрейм #3(метод g())

    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись и работаем
    }

    public static void f() {
        System.err.println(".   #2.in");
        try {
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println(".   #2.CATCH");  // и работаем
        }
        System.err.println(".   #2.out");  // работаем дальше
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
//    #1.in
//            .   #2.in
//            .   .   #3.in
//            .   .   .   #4.in
//            .   .   .   #4.THROW
//            .   #2.CATCH
//            .   #2.out
//    #1.out
    */

    /*
    //throw — выходим из ВСЕХ фреймов

    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // ПРОПУСТИЛИ!
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }

//    #1.in
//            .   #2.in
//            .   .   #3.in
//            .   .   .   #4.in
//            .   .   .   #4.THROW
//    Exception in thread "main" java.lang.Error
//    at nonlocal_control_transfer.NLCT.h(NLCT.java:28)
//    at nonlocal_control_transfer.NLCT.g(NLCT.java:20)
//    at nonlocal_control_transfer.NLCT.f(NLCT.java:14)
//    at nonlocal_control_transfer.NLCT.main(NLCT.java:8)
    */


    /*
    //return — выходим из ОДНОГО фрейма (из фрейма #4(метод h()))

        public static void main(String[] args) {
            System.err.println("#1.in");
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println("#1.out"); // вернулись
        } // выходим из текущего фрейма, кончились инструкции

        public static void f() {
            System.err.println(".   #2.in");
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(".   #2.out");  //вернулись
        } // выходим из текущего фрейма, кончились инструкции

        public static void g() {
            System.err.println(".   .   #3.in");
            h(); // создаем фрейм, помещаем в стек, передаем в него управление
            System.err.println(".   .   #3.out"); // вернулись
        } // выходим из текущего фрейма, кончились инструкции

        public static void h() {
            System.err.println(".   .   .   #4.in");
            if (true) {
                System.err.println(".   .   .   #4.RETURN");
                return; // выходим из текущего фрейма по 'return'
            }
            System.err.println(".   .   .   #4.out"); // ПРОПУСКАЕМ
        }

        //>> #1.in
        //>> .   #2.in
        //>> .   .   #3.in
        //>> .   .   .   #4.in
        //>> .   .   .   #4.RETURN
        //>> .   .   #3.out
        //>> .   #2.out
        //>> #1.out
    */
}
