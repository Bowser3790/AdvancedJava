package thread.day1;

public class myThread extends Thread{
    Printer printer;

    public myThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printDocuments(10,"Fred Documents");
    }
}
