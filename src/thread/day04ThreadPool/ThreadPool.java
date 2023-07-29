package thread.day04ThreadPool;
/*

5. What's a thread pool?
A thread pool is a design pattern used to facilitate multithreading. Asking about thread pools might be one way
for an interviewer to determine if you know how to write performance-efficient code. When answering the question,
give a brief but precise definition and explain why thread pools are useful.

Example: "A thread pool is a collection of worker threads created at start-up that programmers can assign tasks to
as needed, then put back in the pool when complete. The main advantage of using a thread pool is having a supply of
ready-made threads when you need them, which improves application performance."

 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        threadCreator thread1 = new threadCreator("Thread 1");
        threadCreator thread2 = new threadCreator("Thread 2");
        threadCreator thread3 = new threadCreator("Thread 3");
        threadCreator thread4 = new threadCreator("Thread 4");
        threadCreator thread5 = new threadCreator("Thread 5");
        threadCreator thread6 = new threadCreator("Thread 6");
        threadCreator thread7 = new threadCreator("Thread 7");
        threadCreator thread8 = new threadCreator("Thread 8");
        threadCreator thread9 = new threadCreator("Thread 9");
        threadCreator thread10 = new threadCreator("Thread 10");

        // This is the normal way to run/ start the thread.  But clearly this will take a lot of time, memory and
        // start adding costs when there are a lot of threads.
        //
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
//        thread9.start();
//        thread10.start();
        // so this is why we have thread pools ...

        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);
        service.execute(thread6);
        service.execute(thread7);
        service.execute(thread8);
        service.execute(thread9);
        service.execute(thread10);
        // when you run this code the thread pool will continue running for when you need the task executed.
        // you need to use service.shutdown() to stop threads in pool after running task
        service.shutdown();







    }

    }
class threadCreator extends Thread{
    private String threadName;

    public threadCreator(String threadName) {
        this.threadName = threadName;

    }

    @Override
    public void run() {
        System.out.println(threadName + "Thread Started to run");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());

        }
        System.out.println("Thread Completed its task!");
    }
    }
