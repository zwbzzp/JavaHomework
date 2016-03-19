package ch4.ch4_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zwb on 16/3/18.
 */
public class CircularBufferTest {
    public static void main(String[] args)
    {
        ExecutorService app = Executors.newCachedThreadPool();
        Buffer sharedLocation = new CircularBuffer();

        System.out.printf("%-40s\t\t%s\n%-40s%s\n\n", "Operation", "Occupied","---------","\t\t--------");

        app.execute(new Producer(sharedLocation));
        app.execute(new Consumer(sharedLocation));

        app.shutdown();
    }
}
