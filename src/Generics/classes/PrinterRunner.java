package Generics.classes;

public class PrinterRunner {
    public static void main(String[] args) {
        Print <Integer> printInteger = new Print();
        printInteger.setThingToPrint(56);
        printInteger.print();

        Print <Double> doub = new Print<>();
        doub.setThingToPrint(65.7);
        doub.print();

        Print<String> str = new Print<>();

        str.setThingToPrint("Hello Generics");
        str.print();



    }
}
