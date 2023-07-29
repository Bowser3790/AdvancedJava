package thread.day1;

public class MultiThreadRunner {
    public static void main(String[] args) {
        System.out.println("-----------Application With Thread is Started-------------");

        Printer printer = new Printer();

        myThread myThread = new myThread(printer);

        yourThread yourThread = new yourThread(printer);

        myThread.start();
        try {
            myThread.join(50); // this will be the first way to synchronize the thread.
            // this will complete first and then yourThread.start will run.
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        yourThread.start();
        try {
            yourThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Finished Printing!");
    }
}
