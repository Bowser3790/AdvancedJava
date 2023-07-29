package thread.day2;

public class Volatile {

    /*
    Interview Question:
    How might you achieve thread safety?
    Thread safety is an important concept since it prevents your code from hanging or crashing.
    Interviewers may ask you about thread safety to ensure that you can write stable and effective code.
    In your answer, list two or three methods that you might use to achieve thread safety.
ANSWER
    Example: "You can achieve thread safety through several techniques, including synchronization, using the
    Volatile keyword or using atomic wrapper classes."

    INTERVIEW TRICK QUESTION: Probably don't need to know this for the interview-> additional use of volatile.
    24. How do you stop a thread in Java?
This could be a trick question since threads usually only stop once they finish executing. Your answer can show
interviewers that you understand the nuances of working in Java. When you answer, explain how threads usually stop
and provide a method you could use to stop a thread manually.

Example: "There isn't a direct way to stop a thread in Java. Often, you have to wait for a thread to die when
it finishes executing. If you need to manually kill a thread, you can use a Volatile boolean variable within a thread
that throws an exception when triggered from another thread."

-------------------------------

****** Understanding the LOGIC of Volatile: ******

Let's elaborate on the interview question from above:
ANSWER
    Example: "You can achieve thread safety through several techniques, including synchronization, using the
    Volatile keyword or using atomic wrapper classes."

If you don't use the Volatile keyword the Threads will read the data from the cache memory because it is much faster to
retrieve read & write data from the cache. Unfortunately, the problem with this is that the threads run independently of each other
and potentially will give you data that is different.
If you use the Volatile keyword the data will be retrieved from the main method and the data will be in sync with one another.
This will achieve thread safety to give you consistent data.
- using the Volatile keyword will retrieve data slower but all data will be correct.

video 4 multi-threading 15:35 diagram.

     */

    public volatile static int counter = 0; // to make sure this is reading from the main method you have to use the volatile keyword
    // The volatile keyword is used to read data from the main method not the cache memory.

    public static void main(String[] args) {

        // ** note ** that each thread are running on separate memories.
        // meaning that they are updating separate cache memories and thread2 will update counter to 1


        Thread thread1 = new Thread(() -> {
            // if you do not use the local_ keyword the local variable is not being updated.

            int local_counter = counter; // counter value changed to 1 after first loop because in thread 2 we incremented the value
            // meanwhile local_counter will remain 0 and the 2nd loop will run [T1].
            while (local_counter < 10) {
                if (local_counter!=counter){
                    System.out.println("[T1] Local Counter Changed:");
                    local_counter=counter; // this will update local counter that is why it is repeated here.

                }

            }
        });
        Thread thread2 = new Thread(()->{
            int local_counter = counter;
            while (local_counter<10){
                System.out.println("[T2] Incremented counter to " + (local_counter+1));
                counter=++local_counter; // counter will be updated and value will be assigned to thread1 counter
                // meanwhile local_counter in thread1 will remain unchanged with value of 0.
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

            }

        });
        thread1.start();
        thread2.start();


    }
}
