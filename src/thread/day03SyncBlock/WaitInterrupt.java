package thread.day03SyncBlock;

/*
see countDownLatch-> for some of the info below.
CountDownLatch is introduced on Java 5 along with other concurrent utilities like CyclicBarrier, Semaphore,
ConcurrentHashMap, and BlockingQueue in java.util.concurrent package.

Sometimes we might need to start our application only when a particular set of tasks are complete. And these
tasks might be running in parallel and getting completed together or maybe at different times. We can achieve this
using CountDownLatch.

CountDownLatch is a kind of synchronizer that allows one Thread to wait for one or more Threads before starting
processing. This is a very crucial requirement and often needed in server-side core Java applications and having
this functionality built-in as CountDownLatch greatly simplifies the development.

One way that you can stop a thread is to use the interrupt() method.

The main focus of interrupt() method is that we can interrupt/ stop a Thread from running with another thread. Such as
example below where we are using thread2 to interrupt and stop thread1.

Main Thread waits on Latch by calling CountDownLatch.await() method while the other thread calls
CountDownLatch.countDown() to inform that they have completed.



 */

public class WaitInterrupt {
    int balance = 500;
    public static void main(String[] args) {

        WaitInterrupt obj = new WaitInterrupt();
        Thread newThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(2000);


            }
        });
        newThread1.setName("Withdraw Thread");
        newThread1.start();

        Thread newThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);// why make it sleep ... we want to wait 3 seconds for other code to run
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                obj.deposit(2000);
                newThread1.interrupt();// this will interrupt the withdrawal

            }

        });
        newThread2.setName("Interrupt");
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
                System.out.println("Withdraw is interrupted, sorry.");
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

    }
}

