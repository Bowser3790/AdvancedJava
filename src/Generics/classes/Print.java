package Generics.classes;

public class Print<T> {

    /*
    key:
    <T> this is known as a Diamond operator.

    T -> Type -> every data type we can use
    E -> Element
    K -> Key
    V -> Value
    N -> Number

    one of the benefits is that we can see compile time error which will save us a lot of time. Why? because when
    we are able to see the red underline under our code we know that there is an error.
    if we are not using generics then we will get a runtime error and this we have to run our code in order to see what
    the issue is and this can take more time than compile time error.

     */
    private T thingToPrint;

    public T getThingToPrint() {
        return thingToPrint;
    }

    public void setThingToPrint(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}

