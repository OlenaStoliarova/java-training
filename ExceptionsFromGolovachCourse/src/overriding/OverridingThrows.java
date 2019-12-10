package overriding;

//При переопределении (overriding) список исключений потомка не обязан совпадать с таковым у предка.
//Но он должен быть «не сильнее» списка предка:

import java.io.FileNotFoundException;
import java.io.IOException;

/*
// INCORRECT

class Parent {
    public void f() throws IOException, InterruptedException {}
}

class ChildB extends Parent {
    @Override
    public void f() throws Exception {}
}
//COMPILATION ERROR: f() in overriding.ChildB cannot override f() in overriding.Parent
//  overridden method does not throw java.lang.Exception
*/


// CORRECT

class Parent {
    // предок пугает IOException и InterruptedException
    public void f() throws IOException, InterruptedException {}
}

class Child extends Parent {
    // а потомок пугает только потомком IOException
    @Override
    public void f() throws FileNotFoundException {}
}




public class OverridingThrows {
}
