

//package thread.day03SyncBlock;
//
//// note that I messed up on this class because its a built in java class and it should be countDownLatch()
///*
//When to use CountDownLatch?
//Use CountDownLatch when one of the Threads, like the main thread, requires waiting for one or more threads to
//complete, before it starts processing.
//
//Always remember we can not reuse CountDownLatch once the count is reached zero, this is the main difference
//between CountDownLatch and CyclicBarrier.
//
//
//
//
//
//
// */
//
//
//public class countDownLatch {
//    public static void main(String[] args) {
//        countDownLatch latch = new countDownLatch(4);
//        assignTaskThread first = new assignTaskThread(1000, latch,"T1");
//        assignTaskThread second = new assignTaskThread(2000, latch,"T2");
//        assignTaskThread Third = new assignTaskThread(3000, latch,"T3");
//        assignTaskThread fourth = new assignTaskThread(4000, latch,"T4");
//
//        first.start();
//        second.start();
//        Third.start();
//        fourth.start();
//        latch.await();
//
//
//    }
//}
//class assignTaskThread extends Thread{
//    private int delay;
//    private countDownLatch latch;
//
//
//    public assignTaskThread(int delay, countDownLatch latch, String name) {
//        super(name);// will get name from parent class
//        this.delay = delay;
//        this.latch = latch;
//
//
//    }
//
//    @Override
//    public void run() {
//        try {
//            System.out.println(Thread.currentThread().getName() + "Started");
//            Thread.sleep(50);
//            System.out.println(Thread.currentThread().getName() + "Finished!");
//            latch.countDown();
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
