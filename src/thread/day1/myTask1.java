package thread.day1;

public class myTask1 {
    void executeTask() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Printer 1 is working: " + i);
        }
    }
}
