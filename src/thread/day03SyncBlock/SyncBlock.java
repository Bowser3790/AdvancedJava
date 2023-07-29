package thread.day03SyncBlock;

/*
9. Why might you use synchronized block?
Synchronized block allows programmers to synchronize a specific subset of a method. This question shows that you
understand several ways to use synchronization when managing multiple threads. When answering this question, give
a brief explanation of synchronized block and how it works in the context of multithreading.

Answer:
Example: "Synchronized block allows you to designate a particular portion of a method as synchronized. That is,
only a single thread is able to run until it completes, prioritizing that thread above others."
--------------------------------
Synchronization class example:
Say you have 2 threads (objects) Thread 1 and Thread 2
- if both threads use the generated brackets method
- the key here is: thread 2 should wait for thread 1 to finish before trying to access the method
- this will be locked for the address
- When do we need to use Synchronized keyword? ***When we want to use shared resources for thread. Because you want to
block other threads from taking the resource away until the thread you want to finish first. ***

Or

Printer example:
If we use the printer class and create user1 and user 2 threads
if we do not use synchronized keyword in the method signature all the pages will print mixed in with each other.
- if we use the synchronized keyword then user1 docs will print and then user 2 docs will print.
-------------------------------
 */

public class SyncBlock {
    public static void main(String[] args) {
         Brackets brackets = new Brackets();

         Thread thread1 = new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i=0; i<7; i++){
                     brackets.generateBrackets();
                 }
             }
         });
         thread1.start();

         Thread thread2 = new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i = 0; i < 7; i++) {
                     brackets.generateBrackets();
                 }
             }

        });
         thread2.start();
         System.out.println("End of code.");
    }

}
class Brackets {
    public synchronized void generateBrackets() { //
        synchronized (this) { //
            for (int i = 0; i < 10; i++) {
                if (i < 5) {
                    System.out.print("[");

                } else {
                    System.out.print("]");
                }
                System.out.print("");


            }
            //Delaying the method.
            // this will not be blocked like the above synchronized loop.
            for (int i=5; i<5;i++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
