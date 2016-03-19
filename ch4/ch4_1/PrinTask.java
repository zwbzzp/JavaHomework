package ch4.ch4_1;

import java.util.Random;

/**
 * Created by zwb on 16/3/17.
 */
public class PrinTask implements Runnable{
    private final int sleepTime;
    private final String taskTime;
    private final static Random generator = new Random();

    public PrinTask(String name)
    {
        taskTime = name;
        sleepTime = generator.nextInt(5000);
    }

    public void run()
    {
        try {
            System.out.printf("%s going to sleep for %d milliseconds.\n", taskTime, sleepTime);
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
            System.out.printf("%s %s\n",taskTime,"terminated permaturely due to interruption.");
        }

        System.out.printf("%s done sleeping\n",taskTime);
    }
}
