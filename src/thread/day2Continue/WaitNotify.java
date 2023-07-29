package thread.day2Continue;

/*
INTERVIEW QUESTION:
19. In Java, what's the difference between the wait() and sleep() methods?
These are two common Java methods that accomplish similar tasks. Although they appear to do the same thing,
programmers use them in different contexts, and it's important to distinguish their functions. When you answer the
question, explain what each method is and what it does.

Example: "The wait() method pauses a thread and waits until there are no notify() or notifyAll() method calls
from other threads. The sleep() method pauses for a given period, allowing other threads to run, after which it
resumes execution."

note for above: notify()-> method waiting; notifyAll()-> there are more than one method waiting

INTERVIEW QUESTION:
7. What's a race condition?
Race conditions occur when a system is unable to execute multiple functions simultaneously. This question addresses
one of the primary obstacles to multithreading, so it's important to show awareness of the issue. When you give your
answer, briefly define what a race condition is and mention what strategy a programmer might use to fix the issue.

Answer:
Example: "A race condition occurs when multiple concurrent threads compete to run first. If the thread that wins
the race isn't the one that was supposed to run first, the code may exhibit unexpected behavior.
You can resolve this problem with synchronization."

INTERVIEW QUESTION:

8. What's synchronization?
Synchronization is a useful way to fix race conditions that arise during multithreading. If you mention
synchronization in another answer, the interviewer may ask you to define it further. Understanding synchronization
shows that you are able to mitigate, some of the dangers of multithreading. When answering this question, you can
give a simple explanation of what synchronization accomplishes.

Answer:
Example: "Synchronization forces threads to run one at a time to prevent a race condition or multiple threads
trying to perform the same task."

INTERVIEW QUESTION:


 */

public class WaitNotify {
    static public int balance =5000;
    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();
        Thread newThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.withdraw(2000);


            }
        });
        newThread1.setName("Student");
        newThread1.start();

        Thread newThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                waitNotify.deposit(2000);

            }

        });
        newThread2.setName("Parent");
        newThread2.start();

    }
    public synchronized void withdraw(int amount){
        if (balance<0 || balance<amount){
            System.out.println("Balance is negative, please make a deposit. ");
            System.out.println("Balance is waiting to be updated. ");
            try {
                wait(); // we are making the thread wait until someone deposits sufficient money
                // wait and notify should be in the same object.
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            // if balance becomes sufficient
            if (balance>= amount){
                balance = balance - amount;
                System.out.println("Amount has been withdrawn successfully! Current balance is: " + balance);

            }else{
                System.out.println("Insufficient amount: " + balance);
                System.out.println("Ask your parents to add more");
            }
        }
    }
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName() + "Want to deposit amount");
        balance=balance-amount;
        System.out.println(" The amount is deposited. The current balance is " + balance);
        notify();
        // notifyAll() there are more than one method waiting

    }
}
