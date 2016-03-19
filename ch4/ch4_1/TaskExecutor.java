package ch4.ch4_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zwb on 16/3/17.
 */
public class TaskExecutor {
    public static void main(String[] args)
    {
        PrinTask task1 = new PrinTask("task1");
        PrinTask task2 = new PrinTask("task2");
        PrinTask task3 = new PrinTask("task3");

        System.out.println("Strarting executor.");

        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        threadExecutor.execute(task1);
        threadExecutor.execute(task2);
        threadExecutor.execute(task3);

        //no more threads can be started with this thread pool
        threadExecutor.shutdown();

        System.out.println("Tasks started, main ends.");
    }
}
