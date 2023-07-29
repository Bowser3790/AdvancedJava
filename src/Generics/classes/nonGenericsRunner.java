package Generics.classes;

import java.util.ArrayList;
import java.util.List;

public class nonGenericsRunner {
    public static void main(String[] args) {
        NonGenerics nonGenerics = new NonGenerics();
        NonGenerics nonGenerics1 = new NonGenerics();
        NonGenerics nonGenerics2 = new NonGenerics(87.4);

        // object class is grandfather class and it will accept all the variable.



        nonGenerics.setObj(45);
        nonGenerics1.setObj("Generics/classes");

        Integer number = (Integer) nonGenerics1.getObj(); // requires us to use type casting
        String str = (String) nonGenerics.getObj();
        String str2 = (String) nonGenerics2.getObj();// no compile time error it will give RTE: ClassCastException

        // array list to store all data types
        List<Object> list = new ArrayList<>();
        list.add(34);
        list.add("string");

        Integer num2 = (Integer) list.get(0);
        String str3 = (String) list.get(1);
        String str4 = (String) list.get(0);//no compile time error it will give RTE: ClassCastException









    }
}
