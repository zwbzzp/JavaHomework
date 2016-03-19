package ch4.ch4_1;

/**
 * Created by zwb on 16/3/17.
 */
public class ThreadCreator {
    public static void main(String[] args)
    {
        System.out.println("Creating threads.");

        Thread thread1 = new Thread(new PrinTask("task1"));
        Thread thread2 = new Thread(new PrinTask("task2"));
        Thread thread3 = new Thread(new PrinTask("task3"));

        System.out.println("Threads creates, starting tasks.");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Tasks started, main ends.");
    }
}
