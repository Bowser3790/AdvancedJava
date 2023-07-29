package Generics.genericInterface;

// If you use implements  GenericsInterface your class should also be Generics -> such as GenericInterfaceImplement01
public class GenericInterfaceImplement01 <T> implements GenericInterface<T>{

    @Override
    public void getValue(T t) {

    }

    @Override
    public T getValue() {
        return null;
    }
}
