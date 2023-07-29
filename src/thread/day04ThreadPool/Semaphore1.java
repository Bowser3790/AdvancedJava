package thread.day04ThreadPool;

import java.util.concurrent.Semaphore;

/*
SO what is the importance of Semaphore?

It's important to understand the difference between synchronization and semaphore

Synchronization prevents race conditions where the multi-thread is all running at the same time and competing to finish first.
With Synchronization only 1 thread can run at a time...

With Semaphore unlike Synchronization we can control how many threads run at 1 time. In this example we chose to run 4 codes
at a time.
This is controlling how many threads we can execute at the same time and when the tasks are complete the code will allow another
to fill in and continue to run the next code in line.
 */

public class Semaphore1 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore newSemaphore= new Semaphore(4); // how many cars can we park at the same time? (4)

        Thread.sleep(4000);
        System.out.println("Available parking spots: " + newSemaphore.availablePermits());
        Car car1 = new Car("FordF1", newSemaphore);
        car1.start();
        Car car2 = new Car("FordF2", newSemaphore);
        car2.start();
        Car car3 = new Car("FordF3", newSemaphore);
        car3.start();
        Car car4 = new Car("FordF4", newSemaphore);
        car4.start();
        Car car5 = new Car("FordF5", newSemaphore);
        car5.start();

        // what does this example show?
        // this shows that we can control the amount of threads we can run at the same time.
        // when the process finishes we can execute another thread and then new threads come in and complete task.






    }
}
class Car extends Thread{
    private String carName;
    private Semaphore semaphore;

    public Car(String carName, Semaphore semaphore) {
        this.carName = carName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() { // the 2 methods we use inside of run() is acquire -> to put task into the parking lot
        // and release -> once task is complete we can let the car out of the parking lot.
        // we can also control the time the car is in the parking lot.
        try {
            System.out.println(carName + " is trying to park.");
            semaphore.acquire();// trying to get permission to acquire() /start thread
            System.out.println(carName + " is parked.");

            // suppose that the car is parked for 4 hours
            // after 4 hours the car will leave the parking spot.

            for (int i=1; i<=4; i++){
                System.out.println(carName + " is parked for " + i + " hours!");
                Thread.sleep(4000);
            }
            System.out.println("The car has left the parking area, next car please!");
            semaphore.release();// released car from parking lot for other cars.

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
