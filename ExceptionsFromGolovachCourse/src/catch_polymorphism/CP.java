package catch_polymorphism;

public class CP {


    //catch по одному «брату» не может поймать другого «брата»
    // (Error и Exception не находятся в отношении предок-потомок, они из параллельных веток наследования от Throwable)
        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {throw new Error();}
                System.err.print(" 1");
            } catch (Exception e) {
                System.err.print(" 2");
            }
            System.err.print(" 3");
        }
    //>> 0
    //>> RUNTIME EXCEPTION: Exception in thread "main" java.lang.Error



    /*
    //catch по потомку не может поймать предка
    public static void main(String[] args) throws Exception { // пока игнорируйте 'throws'
        try {
            System.err.print(" 0");
            if (true) {throw new Exception();}
            System.err.print(" 1");
        } catch (RuntimeException e) {
            System.err.print(" 2");
        }
        System.err.print(" 3");
    }
//    >> 0
//    >> RUNTIME EXCEPTION: Exception in thread "main" java.lang.Exception
     */

    /*
    //в блоке catch мы будем иметь ссылку типа Exception на объект типа RuntimeException
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                System.err.print("Это RuntimeException на самом деле!!!");
            } else {
                System.err.print("В каком смысле не RuntimeException???");
            }
        }
    }
    //>> Это RuntimeException на самом деле!!!
    */

    /*
    //catch — полиморфная конструкция,
    // т.е. catch по типу Parent перехватывает летящие экземпляры любого типа, который является Parent-ом
    // (т.е. экземпляры непосредственно Parent-а или любого потомка Parent-а)

    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
            System.err.print(" 2");
        }
        System.err.println(" 3");
    }
    //>> 0 2 3
*/
}
