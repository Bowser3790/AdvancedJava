package Generics.methods;

import java.util.Arrays;



public class GenericMethodDemo {
    public static void main(String[] args) {
        GenericMethodDemo obj = new GenericMethodDemo();

        Integer[] intArray = {3, 5, 7, 9, 12, 13};
        obj.print(intArray);

        Double[] doubleArray = {3.5, 7.5, 10.0, 30.6};
        obj.print(doubleArray);

        String[] stringArray = {"thomas", "Sam", "Gina"};

        // with generics you just need to put the data.
        Float[] floatArray = {2f,5f,10f,35f,98f};// I did not have to create another overloading scenario for float.
        // the generics print() method handles all data types.

        System.out.println("-------Print Generic Method----------\n");

        obj.print(intArray);
        obj.print(doubleArray);
        obj.print(stringArray);
        obj.print(floatArray);

    }

    // This is without doing generics.

    public static void print(Integer[] arr) {
    Arrays.stream(arr).forEach(T-> System.out.println(T+" "));
    }
    public static void print(Double[] arr){
        Arrays.stream(arr).forEach(T-> System.out.println(T+" "));
    }
    public static void print(String[] arr){
        Arrays.stream(arr).forEach(T-> System.out.println(T+" "));
    }
        public<T > void print (T[]array){
            for (T t : array) {
                System.out.println(t + " ");
            }
        }
    }