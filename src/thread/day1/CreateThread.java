package thread.day1;

/*
INTERVIEW QUESTION:
Synchronous vs Asynchronous programming:
Example: "Synchronous programming runs tasks individually from a queue. Asynchronous programming allows multiple tasks
 to run at once on the same thread."

1. What's a thread?
Expertise in multithreading requires a proper understanding of instruction threads. An interviewer might ask this
question to determine your programming level and understand how familiar you are with the basic concepts within
multithreading. When answering this question, you can give a simple definition to display your understanding without
offering a response that is too long or detailed.

Answer:
Example: "A thread is a distinct execution path or a subprocess. Within a process, you can have either a single
thread or multiple threads sharing the same process resources."

INTERVIEW QUESTION:

2. What's multithreading?
Multithreading is an important programming concept. Your ability to explain multithreading in a few sentences can
show the interviewer how well you understand the topic. When you answer this question, be specific enough to
demonstrate your expertise while keeping the answer brief.

Answer:
Example: "Multithreading is the ability to have multiple threads executing concurrently. While each thread
shares the same process resources, they operate independently of each other."

INTERVIEW QUESTION:

3. What's the difference between a thread and a process?
Multithreading allows developers to create multiple threads within a single process. Individuals who are unfamiliar
with multithreading may not understand the difference between these two concepts, so an interviewer might ask this
to test your expertise. When answering this question, define both terms briefly and explain how they relate to one
another.

Answer:
Example: "A process is a single application or program, whereas a thread is a subprocess within that application
or program. Each process has its own address space in memory. Threads share their address space."

INTERVIEW QUESTION:
4. Why use multithreading in your applications?
Multithreading is important because it facilitates a wide range of benefits not provided by other programming
techniques. This question allows you to demonstrate to the interviewer how well you appreciate the advantages of
multithreading.
When you answer this question, explain one or two of the main advantages of multithreading, including more efficient
CPU usage, faster task execution and simplification of application structures.

Answer:
Example: "Since each thread runs concurrently, multithreading makes efficient use of the CPU. You can have
background processes running while the application receives user input. Also, tasks can execute faster since each
thread runs independently."

INTERVIEW QUESTION:
How many states are there in a threads Lifetime? Called the thread lifecycle.

Example: "There are five states a thread can have: New, Runnable, Running, Waited/Blocked and Dead/Terminated."

 */



public class CreateThread {


    public static void main(String[] args) {

        // job 1
        System.out.println("...Without Thread Started...");
        // job 2
        myTask myTask = new myTask();
        myTask.executeTask();
        // job 3
        for (int i = 0; i <= 10; i++) {
            System.out.println("Printer 1 is working: " + i);
        }
        // job 4
        System.out.println("...Without Thread Finished...");

        // job 1 w/ thread
        System.out.println("... With Thread Printer 2 is starting ");
        MyTaskWithThread myTaskWithThread = new MyTaskWithThread();
        myTaskWithThread.start();
        System.out.println(" ... With multi-thread is starting ...");

        MyTaskWithMultiThread myTaskWithMultiThread = new MyTaskWithMultiThread();
        Thread Thread = new Thread(myTaskWithMultiThread);
        Thread.start();
        System.out.println("... With multi-thread is finished ");

        // way number 3 we can create a thread ... anonymous function
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is an Anonymous thread ... ");
            }
        });
        // create object
        thread1.start(); // the thread will not start if this is not called.

        // using Lambda

        Thread thread2 = new Thread(()->{
            System.out.println("Using Lambda thread with Lambda expression");
        });
        thread2.start();


    }

    }

class myTask {
    void executeTask() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Printer 2 is working: " + i);
        }
    }
}
// 1st way to create a new thread:
class MyTaskWithThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Printer 3 is working: " + i);
        }

    }
}
class MyTaskWithMultiThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Printer 4 is working: " + i);
        }

    }
}




