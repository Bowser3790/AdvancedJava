package thread.day1;

public class Printer {
    // if you add a synchronized keyword to the void method below it will block/lock the method for one thread at a time.

    synchronized void printDocuments(int numOfCopies, String docName) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 1; i < numOfCopies; i++){
            System.out.println("Number of copies: " + docName + " " + i);

        }

    }
}
