package thread.day1;

public class MultiThreading {
    public static void main(String[] args) {

        long appNoThreadStartedYet = System.currentTimeMillis();
        System.out.println("Application print out thread started");

        myTask1 myTask1 = new myTask1();
        myTask1.executeTask();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Printer 2 is working: " + i);
        }
        System.out.println("Application print out thread Finished");

        long appNoThreadEnd = System.currentTimeMillis();
        System.out.println("total execution time: " + (appNoThreadEnd - appNoThreadStartedYet)); // total execution time: 1559

        System.out.println("App with multi-thread started");

        myTaskWithThread1 myTaskWithThread1 = new myTaskWithThread1();
        myTaskWithThread1.start();
        try {
            myTaskWithThread1.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Printer 4 is working");

        }
        long appWithThreadEnd = System.currentTimeMillis();

        // join() method waits to die/ terminate task1 should be finished task2 should be started.

        System.out.println("App with thread Ending");
        System.out.println("Total time elapsed between app with Multi-thread: " + (appWithThreadEnd - appNoThreadEnd));
        // Total time elapsed between app with Multi-thread: 542

    }


}

