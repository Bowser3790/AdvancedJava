package thread.day04ThreadPool;

/*
17. Can you describe a deadlock situation?
Deadlock is a common problem that can cause code to stall. Your ability to explain the problem indicates you
understand this challenge and may know how to resolve it. When you answer, explain what a deadlock situation is and
describe some reasons a deadlock may occur.

Example: "A deadlock situation occurs when multiple threads are waiting on one another to release CPU resources so
they can run. For example, this can happen when a single thread has exclusive priority but needs resources from a
waiting thread, or all the threads are depending on one another to release needed resources."

// the below code will not work if the eraser and ruler -> synchronized (eraser) and synchronized (ruler) are switched in
thread 1 because the synchronized keyword blocks the other thread2 from running.  If thread1 is holding onto eraser and
not releasing it until ruler is free.  In thread2 ruler is being held onto because its in first position and both thread1
and thread2 are holding onto their first variable-> thread1 eraser and thread2 ruler.

This scenario will cause a "dead lock" and will hold onto each item forever because neither thread1 or 2 will be able to
move to the next task.  They are looking for the free resource that is being held onto by the other thread.

to solve this:

thread1 1st eraser
thread1 2nd ruler

thread2 1st eraser
thread2 2nd ruler

-> this will allow thread1 to move on from the eraser and get the ruler.
-> this will allow the eraser to become free for thread2 to use.
-> then thread 1 will complete the task with the ruler and thread2 will be able to use the ruler and complete the task.



 */

public class DeadLockDemo {
    public static void main(String[] args) {
        final String eraser = "eraser";
        final String ruler = "ruler";

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (eraser) {
                    System.out.println(Thread.currentThread().getName() + " is using eraser.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    synchronized (ruler) {
                        System.out.println(Thread.currentThread().getName() + " is using ruler.");
                    }
                }
            }
        });
        thread1.setName("Mary");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (eraser) {
                    System.out.println(Thread.currentThread().getName() + " is using eraser.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    synchronized (ruler) {
                        System.out.println(Thread.currentThread().getName() + " is using ruler.");
                    }
                }
            }
        });
        thread2.setName("Robert");
        thread2.start();


        }
    }




