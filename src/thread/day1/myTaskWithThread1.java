package thread.day1;

public class myTaskWithThread1 extends Thread {
    @Override
    public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Printer 3 is working: " + i);
            }

        }
    }


