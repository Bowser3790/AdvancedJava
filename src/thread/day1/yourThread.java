package thread.day1;

public class yourThread extends Thread{
   Printer printer;

    public yourThread(Printer printer) { // created constructor
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printDocuments(10,"Bob Documents");
    }
}

