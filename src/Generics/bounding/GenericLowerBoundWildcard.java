package Generics.bounding;

import java.util.ArrayList;
import java.util.List;

/*
what is wildcard ? The question mark is represented as a wildcard, which represents unknown type in generics
 */
public class GenericLowerBoundWildcard {

    public static void main(String[] args) {
        List<Object> ol = new ArrayList<>();
        addElements(ol);
        List<Number> nl = new ArrayList<>();
        addElements(nl);
        List<Double> dl = new ArrayList<>();
        //addElements(dl); compile time error
        List<String> sl = new ArrayList<>();// no error here because we are calling string in the list below.


    }

    // parent of Integer = Object, Number, Integer.
    // super Integer -> it brings parent class of integer.
    // extend Integer -> it brings child class of integer.

    public static void addElements(List< ? super Integer> list){
        for (int i = 1; i<10; i++){
            list.add(i);
        }
    }
    public static void addString(List<? super String> List){
    }
}
